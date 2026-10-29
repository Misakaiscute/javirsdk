package javirsdk.handler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.concurrent.Executors;

public abstract class JavirsdkHandler<T> {
    protected boolean timeoutElapsed = true;
    protected ScheduledExecutorService timeoutTimer = Executors.newSingleThreadScheduledExecutor();
    protected final int timeoutMs;
    protected final String id;
    public String getId() {
        return id;
    };
    protected final int priority;
    public int getPriority() {
        return priority;
    }
    protected final Consumer<T> handler;

    protected JavirsdkHandler(String id, int timeoutMs, int priority, Consumer<T> handler) {
        this.id = id;
        this.timeoutMs = timeoutMs;
        this.priority = priority;
        this.handler = handler;
    }

    public abstract static class Builder<B extends Builder<B, Tout, Tcons>, Tout extends JavirsdkHandler<?>, Tcons> {
        protected abstract B self();

        protected String hId;
        public B setId(String hId) {
            this.hId = hId;
            return self();
        }
        protected Consumer<Tcons> hHandler;
        public B setHandler(Consumer<Tcons> handler) {
            this.hHandler = handler;
            return self();
        }
        protected int hTimeoutMs;
        public B setTimeout(int hTimeoutMs) {
            this.hTimeoutMs = hTimeoutMs;
            return self();
        }
        protected int hPriority;
        public B setPriority(int hPriority) {
            this.hPriority = hPriority;
            return self();
        }

        public abstract Tout build();
    }

    public final void execute() {
        if (!timeoutElapsed) {
            return;
        }

        timeoutElapsed = false;
        executeBody();
        timeoutTimer.schedule(() -> { 
            timeoutElapsed = true;
        }, timeoutMs, TimeUnit.MILLISECONDS);
    }

    public abstract void executeBody();
    public void reset() {
        timeoutElapsed = true;
    }
}
