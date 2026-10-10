package javirsdk.handler;

import javirsdk.Javirsdk;
import javirsdk.exceptions.JavirsdkIRacingNotRunningException;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public final class JavirsdkHandlerExecutor {
    private final LinkedList<JavirsdkHandler> entries = new LinkedList<>();
    /**
     * @return true if there's one or more handlers bound
     */
    public boolean hasHandlers() {
        return !entries.isEmpty();
    }
    private final JavirsdkRunner runner = new JavirsdkRunner(entries);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    /**
     * Binds a new handler to be run when iRacing writes to its buffer.
     *
     * If Javirsdk is connected, but no handlers were bound on connection to IRacing,
     * bounding a handler will start the executor on the fly, and begins to run the 
     * handler, and any new ones specified after.
     *
     * @param handler to be run when buffer is written
     * @throws IllegalArgumentException if handler exists with the same id
     */
    public void bind(JavirsdkHandler handler) throws IllegalArgumentException {
        if (entries.contains(handler)) {
            throw new IllegalArgumentException("Handler id already in use.");
        }
        if (entries.isEmpty()) {
            synchronized (entries) {
                entries.add(handler);
            }
            if (Javirsdk.getInstance().isConnected()) {
                executor.execute(runner);
            }
        } else {
            synchronized (entries) {
                entries.add(handler);
            }
        }
    }
    /**
     * Unbinds handlers from executor.
     *
     * If the last handler is removed, the handler stops executing until a
     * handler is bound again.
     *
     * @param id of handler to unbind 
     * @throws IllegalArgumentException if handler doesn't exist with the id specified
     */
    public void unbind(String id) throws IllegalArgumentException {
        int item_idx;
        synchronized (entries) {
            item_idx = linkedListFind(entries, (JavirsdkHandler h) -> { return h.id == id; });
            entries.remove(item_idx);
        }
        if (item_idx == -1) {
            throw new IllegalArgumentException("No handler found with id %s.".formatted(id));
        } 
    }
    private <T> int linkedListFind(LinkedList<T> list, Predicate<T> cond) {
        int idx = -1;
        for (var item : list) {
            if (cond.test(item)) {
                return idx; 
            }
        }
        return idx;
    }
    /**
     * Start running all the bound handlers, if Javirsdk is connected.
     *
     * If not connected, thorws JavirsdkIRacingNotRunningException
     */
    public void start() throws JavirsdkIRacingNotRunningException {
        if (Javirsdk.getInstance().isConnected()) {
            executor.execute(runner);
        } else {
            throw new JavirsdkIRacingNotRunningException("iRacing not running");
        }
    }
}
