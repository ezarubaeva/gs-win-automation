package window.ContextMenu;

import Tools.Elem;
import daima.DElement;
import window.*;
import window.JobOptions.JobOptions;

public class JobContextMenu extends Elem {

    DElement analyze;
    DElement synchronyze;
    DElement analyzeAndSync;
    DElement clear;
    DElement pause;
    DElement options;
    DElement logsOnLeftSide;
    DElement logsOnRightSide;
    DElement groups;
    DElement neW;
    DElement delete;
    DElement rename;
    DElement clone;
    DElement advanced;
    DElement exit;

    public JobContextMenu() {
        try {
            analyze = g(mainWindow, "", 1, "N", "Analyze");
            synchronyze = g(mainWindow, "", 1,"N", "Synchronize");
            analyzeAndSync = g(mainWindow, "", 1, "N", "Analyze and Sync");
            clear = g(mainWindow, "", 1, "N", "Clear");
            pause = g(mainWindow, "", 1, "N", "Pause");
            options = g(mainWindow, "", 1, "N", "Options...");
            logsOnLeftSide = g(mainWindow, "", 1, "N", "Logs on Left Side");
            logsOnRightSide = g(mainWindow, "", 1, "N", "Logs on Right Side");
            groups = g(mainWindow, "", 1, "N", "Groups");
            neW = g(mainWindow, "", 1, "N", "New");
            delete = g(mainWindow, "", 1, "N", "Delete");
            rename = g(mainWindow, "", 1, "N", "Rename...");
            clone = g(mainWindow, "", 1, "N", "Clone...");
            advanced = g(mainWindow, "", 1, "N", "Advanced");
            exit = g(mainWindow, "", 1, "N", "Exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public MainWindow selectAnalyze(){
            try {
                analyze.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public MainWindow selectSynchronyze(){
            try {
                synchronyze.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public MainWindow selectAnalyzeAndSync(){
            try {
                analyzeAndSync.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public MainWindow selectClear(){
            try {
                clear.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public MainWindow selectPause(){
            try {
                pause.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public JobOptions selectOptions(){
            try {
                options.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new JobOptions();
        }

        public LogWindow selectLogsOnSide(String side){
        if (side.toUpperCase().equals("LEFT")){
            try {
                logsOnLeftSide.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (side.toUpperCase().equals("RIGHT")){
            try {
                logsOnRightSide.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new Error("Wrong param: use Left or Right only");
        }
        return new LogWindow();
        }

        public NewGoodSyncJobWindow selectNew(){
            try {
                neW.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new NewGoodSyncJobWindow();
        }

        public MainWindow selectDelete() {
            try {
                delete.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MainWindow();
        }

        public RenameWindow selectRename(){
            try {
                rename.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new RenameWindow();
        }

        public CloneWindow selectClone(){
            try {
                clone.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CloneWindow();
        }

        public void selectExit(){
        // TODO application is closed on this action
        }
}
