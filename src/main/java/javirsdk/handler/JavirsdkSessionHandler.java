package javirsdk.handler;

import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javirsdk.Javirsdk;
import javirsdk.variable.SessionRoot;

public final class JavirsdkSessionHandler implements JavirsdkHandler<String>{
    private int latestSelfTick = -1;
    private static int latestUpdateTick = -1;
    private static SessionRoot latestState = null;

    private final String id;
    @Override
    public String getId() { return this.id; }
    private final Consumer<SessionRoot> handler;

    private JavirsdkSessionHandler(String id, Consumer<SessionRoot> handler) {
        this.id = id;
        this.handler = handler;
    }

    public static final class Builder {
        private String hId;
        public Builder setId(String hId) {
            this.hId = hId;
            return this;
        }
        private Consumer<SessionRoot> hHandler;
        public Builder setHandler(Consumer<SessionRoot> handler) {
            this.hHandler = handler;
            return this;
        }

        public JavirsdkSessionHandler build() {
            return new JavirsdkSessionHandler(hId, hHandler);
        }
    }

    private static void parseSessionString(String sessionStr) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            sessionStr = sessionStr.split("CarSetup:")[0];
            JavirsdkSessionHandler.latestState = mapper.readValue(sessionStr, SessionRoot.class);
        } catch (JsonProcessingException e) {
            System.out.printf("Runtime e: %s", e.getMessage());
            System.out.printf("Session string: %s", sessionStr);
            throw new RuntimeJsonMappingException(e.getMessage());
        }
    }

    @Override
    public void execute() {
        int sdkSessionTick = Javirsdk.getInstance().getSessionTick();

        boolean sessionStringUpdated = sdkSessionTick != JavirsdkSessionHandler.latestUpdateTick;
        if (sessionStringUpdated) {
            JavirsdkSessionHandler.latestUpdateTick = sdkSessionTick;
            JavirsdkSessionHandler.parseSessionString(Javirsdk.getInstance().getSessionString());
        }

        boolean hasRunWithNewData = this.latestSelfTick == JavirsdkSessionHandler.latestUpdateTick;
        if (!hasRunWithNewData) {
            this.latestSelfTick = JavirsdkSessionHandler.latestUpdateTick;
            this.handler.accept(JavirsdkSessionHandler.latestState);
        }
    }
}
