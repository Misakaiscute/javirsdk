import java.io.IOException;

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

        while (true) {
            while (!sdk.isSimRunning()) {
                System.out.println("Waiting for iRacing to open...");
                try {
                    sdk.openConnection();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }   
            }
            System.out.println("Connected to iRacing!");
        }
    }
}
