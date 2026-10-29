package javirsdk.handler;

import javirsdk.Javirsdk;
import javirsdk.exceptions.JavirsdkIRacingNotRunningException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public final class JavirsdkHandlerExecutor {
    private final List<JavirsdkHandler<?>> entries = new ArrayList<>();
    /**
     * @return true if there's one or more handlers bound
     */
    public boolean hasHandlers() {
        return !entries.isEmpty();
    }
    private final JavirsdkHandlerRunner runner = new JavirsdkHandlerRunner(entries);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    /**
     * Binds a new handler to be run when iRacing writes to its buffer.
     *
     * On binding, it appends the handler to the rest based on its priority.
     * When more than one handlers have the same priority, the handlers will be executed in order of binding.
     * All handlers have a priority of 0 by default. The higher the priority, the earlier they are executed.
     *
     * If Javirsdk is connected, but no handlers were bound on connection to IRacing,
     * bounding a handler will start the executor on the fly, and begins to run the 
     * handler, and any new ones specified after.
     *
     * @param handler to be run when buffer is written
     * @throws IllegalArgumentException if handler exists with the same id
     */
    public void bind(JavirsdkHandler<?> handler) throws IllegalArgumentException {
        if (entries.contains(handler)) {
            throw new IllegalArgumentException("Handler id already in use.");
        }

        synchronized (entries) {
            if (entries.isEmpty()) {
                entries.add(handler);
            } else {
                int idxToAdd = listFind(entries, (JavirsdkHandler<?> h) -> { return h.getPriority() < handler.getPriority(); });
                if (idxToAdd == -1) {
                    entries.addLast(handler);
                }
                entries.add(idxToAdd, handler);
            }
        }
        if (Javirsdk.getInstance().isConnected()) {
            executor.execute(runner);
        }
    }
    /**
     * Unbinds handlers from the executor and resets the handler's internal state.
     *
     * If the last handler is removed, the handler executor stops executing until a
     * handler is bound again.
     *
     * @param id of handler to unbind 
     * @throws IllegalArgumentException if handler doesn't exist with the id specified
     */
    public void unbind(String id) throws IllegalArgumentException {
        int item_idx;
        synchronized (entries) {
            item_idx = listFind(entries, (JavirsdkHandler<?> h) -> { return h.getId() == id; });
            var removedHandler = entries.remove(item_idx);
            removedHandler.reset();
        }
        if (item_idx == -1) {
            throw new IllegalArgumentException("No handler found with id %s.".formatted(id));
        } 
    }
    private <T> int listFind(List<T> list, Predicate<T> cond) {
        int idx = 0;
        for (var item : list) {
            if (cond.test(item)) {
                return idx; 
            }
            ++idx;
        }
        return -1;
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
