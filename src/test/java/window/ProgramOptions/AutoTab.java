package window.ProgramOptions;

import Tools.Elem;
import daima.DElement;
import mmarquee.automation.ElementNotFoundException;
import org.openqa.selenium.NotFoundException;

public class AutoTab extends Elem {
    private DElement autoHideMiniWindNoActiveJobsCheckBox;
    private DElement checkForNewVerDailyCheckBox;
    private DElement autoInstallNewVerWhenFoundCheckBox;
    private DElement autoJobRunParallelInputField;
    private DElement autoJobsQuantInputField;
    private DElement keepFileHistoryMoonthsInputField;
    private DElement autoWnd;

    public AutoTab(){
        try {
            autoWnd = g(mainWindow, "", 1, "da", "76937328");
            autoHideMiniWindNoActiveJobsCheckBox = g(autoWnd, "", 1, "N", "Auto-hide Mini Window when there is no active jobs.");
            checkForNewVerDailyCheckBox = g(autoWnd, "", 1, "N", "Check for a new version daily");
            autoInstallNewVerWhenFoundCheckBox = g(autoWnd, "", 1, "N", "Auto Install new version when found");
            autoJobRunParallelInputField = g(autoWnd, "", 1, "N", "Maximal number of auto jobs that can be run in parallel");
            autoJobsQuantInputField = g(autoWnd, "", 1, "N", "All jobs get reviewed every this many seconds to determine");
            keepFileHistoryMoonthsInputField = g(autoWnd, "", 1, "N", "Discard file history (generations) that is older than");
        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    public AutoTab incrementAutoRunJobsInParallel(int _amountOfClicks){
        DElement spinner;
        DElement btn = null;
        try {
            spinner = g(autoWnd, "", 1, "lN", "spinner", "Maximal number of auto jobs that can be run in parallel");
            btn = g(spinner, "", 1, "a", "SmallIncrement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < _amountOfClicks; i++) {
            try {
                btn.clickMM();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new AutoTab();
    }

    public AutoTab decrementAutoRunJobsInParallel(int _amountOfClicks){
        DElement spinner;
        DElement btn = null;
        try {
            spinner = g(autoWnd, "", 1, "lN", "spinner", "Maximal number of auto jobs that can be run in parallel");
            btn = g(spinner, "", 1, "a", "SmallDecrement");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < _amountOfClicks; i++) {
            try {
                btn.clickMM();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new AutoTab();
    }

}
