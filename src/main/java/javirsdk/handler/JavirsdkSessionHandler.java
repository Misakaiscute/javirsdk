package javirsdk.handler;

import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javirsdk.Javirsdk;
import javirsdk.variable.SessionRoot;

public final class JavirsdkSessionHandler extends JavirsdkHandler<SessionRoot>{
    private int latestSelfTick = -1;
    private static int latestUpdateTick = -1;
    private static SessionRoot latestState = null;


    private JavirsdkSessionHandler(String id, int timeoutMs, int priority, Consumer<SessionRoot> handler) {
        super(id, timeoutMs, priority, handler);
    }

    public static final class Builder extends JavirsdkHandler.Builder<Builder, JavirsdkSessionHandler, SessionRoot> {
        @Override
        protected Builder self() { return this; }
        @Override 
        public JavirsdkSessionHandler build() {
            return new JavirsdkSessionHandler(hId, hTimeoutMs, hPriority, hHandler);
        }
    }

    private static void parseSessionString(String sessionStr) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            sessionStr = sessionStr.split("\0")[0];
            JavirsdkSessionHandler.latestState = mapper.readValue(sessionStr, SessionRoot.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeJsonMappingException(e.getMessage());
        }
    }

    @Override
    public void reset() {
        super.reset();
        JavirsdkSessionHandler.latestState = null;
        JavirsdkSessionHandler.latestUpdateTick = -1;
        this.latestSelfTick = -1;
    }

    @Override
    public void executeBody() {
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
