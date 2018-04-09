package window.ProgramOptions;

import Tools.Elem;
import daima.DElement;

public class GeneralTab extends Elem {
    private DElement noAnimationOnAnalyzecheckBox;
    private DElement sortJobNamesByAlphabet;
    private DElement showBackUpSyncJobGroups;
    private DElement showGoodSyncIconInSysTray;
    private DElement hideToSysTrayMainClosed;
    private DElement startGSwhenWinStarts;
    private DElement addGoodSyncShortcutDesktop;

    public GeneralTab(){
        super();
        DElement prOptions = null;
        try {
            prOptions = g(mainWindow, "", 1, "da", "76937328");
        } catch (Exception e) {
            throw new Error("Can not find element program options wnd");
        }
        try {
            noAnimationOnAnalyzecheckBox = g(prOptions, "", 1, "N", "No animations on Analyze");
        } catch (Exception e) {
            throw new Error("Can not find element No animation on analyze checkbox");
        }
        try {
            sortJobNamesByAlphabet = g(prOptions, "", 1, "N", "Sort job names by alphabet (restart required)");
        } catch (Exception e) {
            throw new Error("Can not find element Sort job names by alphabet");
        }
        try {
            showBackUpSyncJobGroups = g(prOptions, "", 1, "N", "Show Backup / Sync Jobs groups (restart required)");
        } catch (Exception e) {
            throw new Error("Can not find element Show backup/sync jobs groups");
        }
        try {
            showGoodSyncIconInSysTray = g(prOptions, "", 1, "N", "Show GoodSync icon in system tray.");
        } catch (Exception e) {
            throw new Error("Can not find element Show goodsync icon in sys tray");
        }
        try {
            hideToSysTrayMainClosed = g(prOptions, "", 1, "N", "Hide to System Tray when Main Window is closed.");
        } catch (Exception e) {
            throw new Error("Can not find element Hide to sys tray when main is closed");
        }
        try {
            startGSwhenWinStarts = g(prOptions, "", 1, "N", "Start GoodSync when Windows starts.");
        } catch (Exception e) {
            throw new Error("Can not find element start GS when windows starts");
        }
        try {
            addGoodSyncShortcutDesktop = g(prOptions, "", 1, "N", "Add GoodSync shortcut to desktop");
        } catch (Exception e) {
            throw new Error("Can not find element Add GS shortcut to desktop");
        }
    }

    // TODO needs to step by step debug - might not work at all
    public GeneralTab setLanguage(String _language){
        try {
            DElement list = g(mainWindow, "", 1, "dN", _language);
            list.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GeneralTab();
    }

    public GeneralTab setNoAnimationOnAnalyzeCheckBox(boolean _boolValue){
        setCheckBoxToValue(noAnimationOnAnalyzecheckBox, _boolValue);
        return this;
    }

    public GeneralTab setSortJobNamesByAlphabet(boolean _boolValue){
        setCheckBoxToValue(sortJobNamesByAlphabet, _boolValue);
        return this;
    }

    public GeneralTab setShowBackupSyncJobGroupsCheckBox(boolean _boolValue){
        setCheckBoxToValue(showBackUpSyncJobGroups, _boolValue);
        return this;
    }

    public GeneralTab setShowBackUpSyncJobsGroupsCheckBox(boolean _boolValue){
        setCheckBoxToValue(showBackUpSyncJobGroups, _boolValue);
        return this;
    }

    public GeneralTab setShowGoodSyncIconSystemTrayCheckBox(boolean _boolValue){
        setCheckBoxToValue(showGoodSyncIconInSysTray, _boolValue);
        return this;
    }

    public GeneralTab setHideSystemTrayMainWindowClosedCheckBox(boolean _boolValue){
        setCheckBoxToValue(hideToSysTrayMainClosed, _boolValue);
        return this;
    }

    public GeneralTab setStartGoodSyncOnWindowsStarts(boolean _boolValue){
        setCheckBoxToValue(startGSwhenWinStarts, _boolValue);
        return this;
    }

    public GeneralTab setAddGoodSyncShortcutDesktopCheckBox(boolean _boolValue){
        setCheckBoxToValue(addGoodSyncShortcutDesktop, _boolValue);
        return this;
    }


}
