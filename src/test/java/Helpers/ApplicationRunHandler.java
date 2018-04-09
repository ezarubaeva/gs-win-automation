package Helpers;

import Tools.Elem;

import java.io.IOException;

public class ApplicationRunHandler extends Elem {
    private String pathToApp = "C:\\Program Files\\Siber Systems\\GoodSync\\GoodSync-v10.exe";
    private Process process;

    public void runGoodSyncApp(){
        int counter = 0;
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