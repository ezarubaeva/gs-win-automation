package window;

import Tools.Elem;
import daima.DElement;
import mmarquee.demo.Main;

public class CloneWindow extends Elem {
    // TODO rewrite as both classes Clone and Rename are the same except main form.
    private DElement clone;
    private DElement jobNameInputField;
    private DElement okBtn;
    private DElement cancelBtn;

    public CloneWindow(){
        try {
            clone = g(mainWindow, "", 1, "N", "Clone Job");
            jobNameInputField = g(clone, "", 1, "N", "Enter Job Name");
            okBtn = g(clone, "", 1, "N", "OK");
            cancelBtn = g(clone, "", 1, "N", "Cancel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CloneWindow setJobName(String _name){
        try {
            jobNameInputField.setValue(_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainWindow clickOkBtn(){
        try {
            okBtn.clickMM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }

    public MainWindow clickCancelBtn(){
        try {
            cancelBtn.clickMM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }
}
