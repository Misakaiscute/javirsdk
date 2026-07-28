import java.util.concurrent.ConcurrentHashMap;

public record JavirsdkNewIrsdkDataRunner (
    ConcurrentHashMap<String, JavirsdkNewDataHandler> handlers
) implements Runnable {
    @Override
    public void run() {
        while (!handlers.isEmpty()) {
            handlers.forEach((String id, JavirsdkNewDataHandler fn) -> {
                Javirsdk.getInstance().waitForNewData();
                fn.invoke();
            });
        }
    }
}
