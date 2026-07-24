import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            if (!IRSDKAccess.getInstance().isConnected()) {
                try {
                    IRSDKAccess.getInstance().openConnection();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                Thread.sleep(2000L);
                clearConsole();
            } else if (!IRSDKAccess.getInstance().isSimRunning()) {
                try {
                    boolean isNewData = IRSDKAccess.getInstance().waitForNewData();
                    if (isNewData) {
                        clearConsole();
                        IRSDKVarHeader hSpeed = IRSDKAccess.getInstance().getVarHeaderByName("Speed");
                        System.out.printf("Speed: °%d km/h", (int)(IRSDKAccess.getInstance().getFloat(hSpeed) * 3.6));
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
    private static void clearConsole() {
        System.out.println("\f");
    }
}
