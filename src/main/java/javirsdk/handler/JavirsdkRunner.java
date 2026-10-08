package javirsdk.handler;

import javirsdk.Javirsdk;
import javirsdk.exceptions.JavirsdkIRacingClosingException;
import javirsdk.exceptions.JavirsdkIRacingNotRunningException;

import java.util.LinkedList;

public record JavirsdkRunner(
    LinkedList<JavirsdkHandler> handlers
) implements Runnable {
    @Override
    public void run() {
        while (!handlers.isEmpty()) {
            try {
                Javirsdk.getInstance().waitForNewData();
                synchronized (handlers) {
                    for (JavirsdkHandler handler : handlers) {
                        handler.execute();
                    }
                }
            } catch (JavirsdkIRacingClosingException e) {
                Javirsdk.getInstance().onIRacingClosing();
                return;
            } catch (JavirsdkIRacingNotRunningException e) {
                return;
            }
        }
    }
}
