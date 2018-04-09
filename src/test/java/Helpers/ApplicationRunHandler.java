package Helpers;

import Tools.Elem;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ApplicationRunHandler extends Elem {
    private String pathToApp = "C:\\Program Files\\Siber Systems\\GoodSync\\GoodSync-v10.exe";
    private Process process;

    public void runGoodSyncApp(){
        int counter = 0;
        setRegistryToInit();
        try {
            process = Runtime.getRuntime().exec(pathToApp);
            while (counter < 10){
                try {
                    g(null, "", 1, "N", "GoodSync - ");
                    break;
                } catch (Exception e) {
                    counter++;
                    sleep(1);
                }
            }
        } catch (IOException e) {
            throw new Error("Can not start GoodSync application on: " + pathToApp);
        }
    }

    public void closeGoodSyncApp(){
        int counter = 0;
        while (process.isAlive()){
            process.destroy();
            counter++;
            if (counter > 10){
                throw new Error("Can not close GoodSync application");
            }
        }
    }

    public void setRegistryToInit(){
        try {
            Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Siber Systems\\GoodSync", "TreeViewSelected", 1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }

    }

}