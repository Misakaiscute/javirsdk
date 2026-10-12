package javirsdk.handler;

import javirsdk.Javirsdk;

import java.util.LinkedList;

public record JavirsdkRunner(
    LinkedList<JavirsdkHandler<?>> handlers
) implements Runnable {
    @Override
    public void run() {
        while (!handlers.isEmpty()) {
            try {
                Javirsdk.getInstance().waitForNewData();
                synchronized (handlers) {
                    for (JavirsdkHandler<?> handler : handlers) {
                        handler.execute();
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
