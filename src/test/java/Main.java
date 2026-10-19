import javirsdk.Javirsdk;
import javirsdk.handler.JavirsdkSessionHandler;
import javirsdk.handler.JavirsdkVariableHandler;
import javirsdk.variable.JavirsdkVariable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Javirsdk sdk = Javirsdk.getInstance();

        JavirsdkVariableHandler varHnd = new JavirsdkVariableHandler.Builder()
            .setId("print_speed")
            .setRequiredVariables(JavirsdkVariable.SPEED)
            .setHandler((state) -> { System.out.printf("Speed: %.2f", state.getSpeed() * 3.6);} )
            .build();
        sdk.handlerExecutor.bind(varHnd);

        JavirsdkSessionHandler sessHnd = new JavirsdkSessionHandler.Builder()
            .setId("print_track_name")
            .setHandler((state) -> { System.out.println(state.getWeekendInfo().getTrackName()); })
            .build();
        sdk.handlerExecutor.bind(sessHnd);
        
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
