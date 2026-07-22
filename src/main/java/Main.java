import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HANDLE hMemMappedFile = Kernel32.INSTANCE.OpenFileMapping(WinNT.FILE_MAP_READ, false, IRSDKDefines.MEM_MAPPED_FILENAME);

        while (hMemMappedFile == null) {
            clearConsole();
            System.out.println("iRacing not running, waiting for it opening...");
            Thread.sleep(2000);
            hMemMappedFile = Kernel32.INSTANCE.OpenFileMapping(WinNT.FILE_MAP_READ, false, IRSDKDefines.MEM_MAPPED_FILENAME);
        }

        Pointer buffer = Kernel32.INSTANCE.MapViewOfFile(hMemMappedFile, WinBase.FILE_MAP_READ, 0, 0, 0);
        IRSDKVarHeader carIdxSpeed = null;
        while(true){
            IRSDKHeader.update(buffer);
            if (carIdxSpeed == null) {
                System.out.printf("IRSDK version: %s", IRSDKHeader.getInstance().getVersion());
                int speed_idx = IRSDKHeader.getInstance().scoutNameToIdx("Speed");
                carIdxSpeed = IRSDKHeader.getInstance().getVarHeaderEntry(speed_idx);
            }
            IRSDKVarBuf curBuf = IRSDKHeader.getInstance().varBuf[IRSDKHeader.getInstance().getCurBuf()];
            float[] carSpeeds = curBuf.getFloats(carIdxSpeed.getOffset(), carIdxSpeed.getCount());
            for (int i = 0; i < carSpeeds.length; i++) {
                System.out.printf("Car speed: %f km/h \n", carSpeeds[i] * 3.6);
            }
            Thread.sleep(20);
        }
    }
    private static void clearConsole() {
        System.out.println("\f");
    }
}
