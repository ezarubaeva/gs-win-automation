package window.ContextMenu;

import Tools.Elem;
import daima.DElement;
import window.MainWindow;

public class AllContextMenu extends Elem {
    private DElement analyzeAll;
    private DElement synchronyzeAll;
    private DElement analyzeAndSyncAll;
    private DElement stopAll;
    private DElement autoRunOFF;

    public AllContextMenu(){
        try {
            analyzeAll = g(mainWindow, "", 1, "N", "Analyze All");
        } catch (Exception e) {
            throw new Error("Can not find element Analyze all");
        }
        try {
            synchronyzeAll = g(mainWindow, "", 1, "N", "Synchronize All");
        } catch (Exception e) {
            throw new Error("Can not find element Synchronize all");
        }
        try {
            analyzeAndSyncAll = g(mainWindow, "", 1, "N", "Analyze and Sync All");
        } catch (Exception e) {
            throw new Error("Can not find element Analyze and Sync all");
        }
        try {
            stopAll = g(mainWindow, "", 1, "N", "Stop All");
        } catch (Exception e) {
            throw new Error("Can not find element Stop all");
        }
        try {
            autoRunOFF = g(mainWindow, "", 1, "N", "AutoRun OFF");
        } catch (Exception e) {
            throw new Error("Can not find element AutoRun OFF");
        }
    }

    public MainWindow selectAnalyzeAll(){
        try {
            analyzeAll.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }

    public MainWindow selectSynchronizeAll(){
        try {
            synchronyzeAll.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }

    public MainWindow selectAnalyzeAndSyncAll(){
        try {
            analyzeAndSyncAll.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }

    public MainWindow selectStopAll(){
        try {
            stopAll.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }

    public MainWindow selectAutoRunOff(){
        try {
            autoRunOFF.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }
}
