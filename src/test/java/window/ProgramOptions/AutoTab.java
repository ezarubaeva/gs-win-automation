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
    private DElement keepFileHistoryMonthsInputField;
    private DElement autoWnd;

    public AutoTab(){
        super();
        try {
            autoWnd = g(mainWindow, "", 1, "da", "76937328");
        } catch (Exception e) {
            throw new Error("Can not find element Auto window");
        }
        try {
            autoHideMiniWindNoActiveJobsCheckBox = g(autoWnd, "", 1, "N", "Auto-hide Mini Window when there is no active jobs.");
        } catch (Exception e) {
            throw new Error("Can not find element Auto hide mini window no active jobs check box");
        }
        try {
            checkForNewVerDailyCheckBox = g(autoWnd, "", 1, "N", "Check for a new version daily");
        } catch (Exception e) {
            throw new Error("Can not find element Check for a new ver daily checkbox");
        }
        try {
            autoInstallNewVerWhenFoundCheckBox = g(autoWnd, "", 1, "N", "Auto Install new version when found");
        } catch (Exception e) {
            throw new Error("Can not find element auto install new ver when found checkbox");
        }
        try {
            autoJobRunParallelInputField = g(autoWnd, "", 1, "N", "Maximal number of auto jobs that can be run in parallel");
        } catch (Exception e) {
            throw new Error("Can not find element auto job runs in parallel input field");
        }
        try {
            autoJobsQuantInputField = g(autoWnd, "", 1, "N", "All jobs get reviewed every this many seconds to determine");
        } catch (Exception e) {
            throw new Error("Can not find element auto jobs quant input field");
        }
        try {
            keepFileHistoryMonthsInputField = g(autoWnd, "", 1, "N", "Discard file history (generations) that is older than");
        } catch (Exception e) {
            throw new Error("Can not find element keep file history months input field");
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
