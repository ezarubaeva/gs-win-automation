package window;

import Tools.Elem;
import daima.DElement;

public class NewGoodSyncJobWindow extends Elem {
    private DElement window;
    private DElement enterJobNameInputField;
    private DElement synchronizeButton;
    private DElement backupButton;
    private DElement okButton;
    private DElement cancelBtn;

    public NewGoodSyncJobWindow(){
        super();
        try {
            window = g(mainWindow, "New job dialog", 1, "N", "New GoodSync Job");
        } catch (Exception e) {
            throw new Error("Can not find element New job dialog wnd");
        }
        try {
            enterJobNameInputField = g(window, "Enter Job Name Field", 1, "N", "Enter Job Name");
        } catch (Exception e) {
            throw new Error("Can not find element Enter job name field");
        }
        try {
            synchronizeButton = g(window, "Synchronize radio Button", 1, "N", "Synchronize");
        } catch (Exception e) {
            throw new Error("Can not find element Synchronize radio button");
        }
        try {
            backupButton = g(window, "Back Up Button", 1, "N", "Backup");
        } catch (Exception e) {
            throw new Error("Can not find element BackUp button");
        }
    }

    public NewGoodSyncJobWindow setJobName(String _name) {
        try {
            enterJobNameInputField.setValue(_name);
            sleep(1);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public NewGoodSyncJobWindow setBackUPradioButton() {
        try {
            backupButton.clickRadioBtn();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public MainWindow clickOkbutton() {
        try {
            okButton = g(window, "OK Button", 1, "N", "OK");
            okButton.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new MainWindow();
    }

    public MainWindow clickCancelButton(){
        try {
            cancelBtn = g(window, "Cancel Button", 1, "N", "Cancel");
            cancelBtn.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new MainWindow();
    }

}
