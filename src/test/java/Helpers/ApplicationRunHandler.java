package Helpers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static Tools.Elem.g;
import static Tools.Elem.sleep;

public class ApplicationRunHandler {
    private String pathToApp = "C:\\Program Files\\Siber Systems\\GoodSync\\GoodSync-v10.exe";
    private Process process;

    public void runGoodSyncApp(){
        int counter = 0;
        WinRegistry.setValue_HKCU_Software_SiberSys_GoodSync_DWORD("TreeViewSelected", 1);
        String appdataPath = System.getenv("APPDATA");
        String projectDirectory = System.getProperty("user.dir");
        try {
            FileUtils.cleanDirectory(new File(appdataPath + "\\GoodSync"));
        } catch (IOException e) {
            throw new Error("Error on cleaning directory %appdata% /GoodSync : " + e.getMessage());
        }
        try {
            FileUtils.copyFile(new File(projectDirectory + "\\Files\\jobs-groups-options.tic"),
                    new File(appdataPath + "\\GoodSync\\jobs-groups-options.tic") );
        } catch (IOException e) {
            throw new Error("Error on copy jobs-groups-options.tic to %appdata% folder: " + e.getMessage());
        }
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

}