package javirsdk.handler;

import javirsdk.Javirsdk;
import javirsdk.exceptions.JavirsdkIRacingClosingException;
import javirsdk.exceptions.JavirsdkIRacingNotRunningException;

import java.util.List;

public record JavirsdkHandlerRunner (
    List<JavirsdkHandler<?>> handlers
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
            } catch (JavirsdkIRacingClosingException e) {
                for (JavirsdkHandler<?> handler : handlers) {
                    handler.reset();
                }
            } catch (JavirsdkIRacingNotRunningException e) { return; }
        }
    }
}
