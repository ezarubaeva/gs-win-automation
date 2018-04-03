package window.ProgramOptions;

import Tools.Elem;
import daima.DElement;

public class AutoTab extends Elem {
    private DElement autoHideMiniWindNoActiveJobsCheckBox;
    private DElement checkForNewVerDailyCheckBox;
    private DElement autoInstallNewVerWhenFoundCheckBox;

    public AutoTab(){
        try {
            DElement autoWnd = g(mainWindow, "", 1, "da", "76937328");
            autoHideMiniWindNoActiveJobsCheckBox = g(autoWnd, "", 1, "N", "Auto-hide Mini Window when there is no active jobs.");
            checkForNewVerDailyCheckBox = g(autoWnd, "", 1, "N", "Check for a new version daily");
            autoInstallNewVerWhenFoundCheckBox = g(autoWnd, "", 1, "N", "Auto Install new version when found");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
