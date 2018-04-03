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
        try {
            DElement prOptions = g(mainWindow, "", 1, "da", "76937328");
            noAnimationOnAnalyzecheckBox = g(prOptions, "", 1, "N", "No animations on Analyze");
            sortJobNamesByAlphabet = g(prOptions, "", 1, "N", "Sort job names by alphabet (restart required)");
            showBackUpSyncJobGroups = g(prOptions, "", 1, "N", "Show Backup / Sync Jobs groups (restart required)");
            showGoodSyncIconInSysTray = g(prOptions, "", 1, "N", "Show GoodSync icon in system tray.");
            hideToSysTrayMainClosed = g(prOptions, "", 1, "N", "Hide to System Tray when Main Window is closed.");
            startGSwhenWinStarts = g(prOptions, "", 1, "N", "Start GoodSync when Windows starts.");
            addGoodSyncShortcutDesktop = g(prOptions, "", 1, "N", "Add GoodSync shortcut to desktop");
        } catch (Exception e) {
            e.printStackTrace();
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
