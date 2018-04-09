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
        super();
        try {
            analyze = g(mainWindow, "", 1, "N", "Analyze");
        } catch (Exception e) {
            throw  new Error("Can not find element Job context-> analyze");
        }
        try {
            synchronyze = g(mainWindow, "", 1,"N", "Synchronize");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> synchronize");
        }
        try {
            analyzeAndSync = g(mainWindow, "", 1, "N", "Analyze and Sync");
        } catch (Exception e) {
            throw new Error("can not find element Job context -> analyze and sync");
        }
        try {
            clear = g(mainWindow, "", 1, "N", "Clear");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> clear");
        }
        try {
            pause = g(mainWindow, "", 1, "N", "Pause");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> pause");
        }
        try {
            options = g(mainWindow, "", 1, "N", "Options...");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> options...");
        }
        try {
            logsOnLeftSide = g(mainWindow, "", 1, "N", "Logs on Left Side");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> logs on left side");
        }
        try {
            logsOnRightSide = g(mainWindow, "", 1, "N", "Logs on Right Side");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> logs on right side");
        }
        try {
            groups = g(mainWindow, "", 1, "N", "Groups");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> groups");
        }
        try {
            neW = g(mainWindow, "", 1, "N", "New");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> new");
        }
        try {
            delete = g(mainWindow, "", 1, "N", "Delete");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> delete");
        }
        try {
            rename = g(mainWindow, "", 1, "N", "Rename...");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> rename...");
        }
        try {
            clone = g(mainWindow, "", 1, "N", "Clone...");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> clone...");
        }
        try {
            advanced = g(mainWindow, "", 1, "N", "Advanced");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> advanced");
        }
        try {
            exit = g(mainWindow, "", 1, "N", "Exit");
        } catch (Exception e) {
            throw new Error("Can not find element Job context -> exit");
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
