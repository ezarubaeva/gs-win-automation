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
        } catch (Exception e) {
            throw new Error("Can not find element Clone job");
        }
        try {
            jobNameInputField = g(clone, "", 1, "N", "Enter Job Name");
        } catch (Exception e) {
            throw new Error("Can not find element Enter job name field");
        }
        try {
            okBtn = g(clone, "", 1, "N", "OK");
        } catch (Exception e) {
            throw new Error("Can not find element Ok btn");
        }
        try {
            cancelBtn = g(clone, "", 1, "N", "Cancel");
        } catch (Exception e) {
            throw new Error("Can not find element cancel btn");
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
