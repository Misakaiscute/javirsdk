package javirsdk.handler;

import javirsdk.Javirsdk;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class JavirsdkHandlerExecutor {
    private final LinkedList<JavirsdkHandler> entries = new LinkedList<>();
    public boolean hasHandlers() {
        return !entries.isEmpty();
    }
    private final JavirsdkRunner runner = new JavirsdkRunner(entries);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void bind(JavirsdkHandler handler) throws IllegalArgumentException {
        if (entries.contains(handler)) {
            throw new IllegalArgumentException("Handler id already in use.");
        }
        if (entries.isEmpty()) {
            synchronized (entries) {
                entries.add(handler);
            }
            if (Javirsdk.getInstance().isConnected()) {
                executor.submit(runner);
            }
        } else {
            synchronized (entries) {
                entries.add(handler);
            }
        }
    }
    public void unbind(JavirsdkHandler handler) throws IllegalArgumentException {
        boolean removed;
        synchronized (entries) {
            removed = entries.remove(handler);
        }
        if (!removed) {
            throw new IllegalArgumentException("No handler found with id %s.".formatted(handler.id));
        }
    }
    public void start() {
        executor.execute(runner);
    }
}
