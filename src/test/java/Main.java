import javirsdk.Javirsdk;
import javirsdk.handler.JavirsdkHandler;
import javirsdk.variable.JavirsdkVariable;
import javirsdk.variable.JavirsdkVariableStateSnapshot;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Javirsdk sdk = Javirsdk.getInstance();
        
        sdk.setOnIRacingClosingAction(() -> {
            System.out.println("iRacing closed"); 
        });

        var handler = new JavirsdkHandler("print_speed", (JavirsdkVariableStateSnapshot state) -> {
            System.out.printf("Speed: %.2f\n", state.getSpeed() * 3.6);
        }, JavirsdkVariable.SPEED);
        sdk.handlerExecutor.bind(handler);

        Javirsdk.RunHelper runner = new Javirsdk.RunHelper.Builder()
            .setConnectionRetryIntervalMs(500)
            .build();

        runner.run();
    }
}
