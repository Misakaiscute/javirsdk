package javirsdk.handler;

import java.util.function.Consumer;

import javirsdk.Javirsdk;

public final class JavirsdkSessionHandler implements JavirsdkHandler<String>{
    private final String id;
    @Override
    public String getId() {
        return this.id;
    }
    private int latestSessionStringTick = -1;
    private String latestSessionString;

    private final Consumer<String> handler;
    private JavirsdkSessionHandler(String id, Consumer<String> handler) {
        this.id = id;
        this.handler = handler;
    }

    public static final class Builder {
        private String hId;
        public Builder setId(String hId) {
            this.hId = hId;
            return this;
        }
        private Consumer<String> hHandler;
        public Builder setHandler(Consumer<String> handler) {
            this.hHandler = handler;
            return this;
        }

        public JavirsdkSessionHandler build() {
            return new JavirsdkSessionHandler(hId, hHandler);
        }
    }

    @Override
    public void execute() {
        //Check if the session string was updated
        //If it was, run the handler provided by the user
        int javirsdkSessionStringTick = Javirsdk.getInstance().getSessionTick();
        if (javirsdkSessionStringTick != this.latestSessionStringTick) {
            this.latestSessionStringTick = javirsdkSessionStringTick;
            this.latestSessionString = Javirsdk.getInstance().getSessionString();
            this.handler.accept(latestSessionString);
        }
    }
}
