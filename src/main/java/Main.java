import irsdkdef.IRSDKVarHeader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JavirsdkNewDataHandler print_speed = () -> {
            clearConsole();
            IRSDKVarHeader speedHeader = Javirsdk.getInstance().getVarHeaderByName("Speed");
            System.out.printf("%s: %d km/h", speedHeader.getName(), (int)(speedHeader.getFloat() * 3.6));
        };
        Javirsdk.getInstance().bindOnNewDataHandler("print_speed", print_speed);
        while(true) {
            while (!Javirsdk.getInstance().isConnected()) {
                try {
                    Javirsdk.getInstance().openConnection();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(2000L);
                clearConsole();
            }
            if (!Javirsdk.getInstance().isSimRunning()) {
                Javirsdk.getInstance().closeConnection();
            }
        }
    }
    private static void clearConsole() {
        System.out.println("\f");
    }
}
