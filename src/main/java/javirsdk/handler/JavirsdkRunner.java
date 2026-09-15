package javirsdk.handler;

import javirsdk.Javirsdk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public record JavirsdkRunner(
    LinkedList<JavirsdkHandler> handlers
) implements Runnable {
    @Override
    public void run() {
        while (!handlers.isEmpty()) {
            Javirsdk.getInstance().waitForNewData();
            synchronized (handlers) {
                for (JavirsdkHandler handler : handlers) {
                    handler.execute();
                }
            }
        }
    }
}
