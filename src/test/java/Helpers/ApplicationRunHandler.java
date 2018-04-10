package Helpers;

import org.apache.commons.io.FileUtils;

import java.io.*;

import static Tools.Elem.g;
import static Tools.Elem.sleep;

public class ApplicationRunHandler {
    private String pathToApp = "C:\\Program Files\\Siber Systems\\GoodSync\\GoodSync-v10.exe";
    private Process process;

    // http://stackoverflow.com/a/19005828/3764804
    private boolean isProcessRunning() throws IOException {
        String line = "";
        String pidInfo = "";

        Process p = null;
        try {
            p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
        } catch (Exception e) {
            throw new Error("Error on getting tasklist.exe: " + e.getMessage());
        }

        BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));

        while ((line = input.readLine()) != null) {
            pidInfo += line;
        }

        input.close();
        return pidInfo.contains ("GoodSync-v10.exe");
    }

    public void runGoodSyncApp() {
        int counter = 0;

        try {
            while (isProcessRunning ()) {
                Runtime.getRuntime().exec ("taskkill /F /IM GoodSync-v10.exe");
                Runtime.getRuntime().exec ("taskkill /F /IM gs-runner.exe");
            }
        } catch (Exception e){
            throw new Error("Error on killing GS process: " + e.getMessage());
        }


        WinRegistry.setValue_HKCU_Software_SiberSys_GoodSync_DWORD("TreeViewSelected", 1);
        FileOperations.deleteAllInAppData();
        FileOperations.copyFileFromProjectDirToAppData("Files\\jobs-groups-options.tic",
                "jobs-groups-options.tic");
        /*String appdataPath = System.getenv("APPDATA");
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
        }*/
        File gs = new File(pathToApp);
        if (!gs.exists() && !gs.isFile()){
            throw new Error("Can not find GoodSync executable file at path: " + pathToApp);
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

    // Closes
    public void closeGoodSyncApp(){
        int counter = 0;
        while (process.isAlive()){
            process.destroy();
            counter++;
            sleep(1);
            if (counter > 10){
                throw new Error("Can not close GoodSync application");
            }
        }
    }

}