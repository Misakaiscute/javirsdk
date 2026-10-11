import javirsdk.Javirsdk;
import javirsdk.handler.JavirsdkHandler;
import javirsdk.variable.JavirsdkVariable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Javirsdk sdk = Javirsdk.getInstance();

        JavirsdkHandler handler = new JavirsdkHandler.Builder()
            .setId("print_speed")
            .setRequiredVariables(JavirsdkVariable.SPEED)
            .setHandler((state) -> { System.out.printf("Speed: %.2f", state.getSpeed() * 3.6);} )
            .build();

        sdk.handlerExecutor.bind(handler);
        
        Javirsdk.RunHelper runner = new Javirsdk.RunHelper.Builder()
            .setConnectionRetryIntervalMs(500)
            .setOnConnect(() -> { System.out.println("\tiRacing CONN!");})
            .setOnDisconnect(() -> { System.out.println("\tiRacing DISCONN!");})
            .setOnSimOpen(() -> { System.out.println("\tiRacing SIM_OPENED!");})
            .setOnSimClose(() -> { System.out.println("\tiRacing SIM_CLOSED!");})
            .build();

        runner.run();
    }
}
