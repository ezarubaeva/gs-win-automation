package window;

import Tools.Elem;
import daima.DElement;

public class RenameWindow extends Elem {
    private DElement rename;
    private DElement jobNameInputField;
    private DElement okBtn;
    private DElement cancelBtn;

    public RenameWindow(){
        super();
        try {
            rename = g(mainWindow, "", 1, "N", "Rename Job");
        } catch (Exception e) {
            throw new Error("Can not found element 'rename job'");
        }
        try {
            jobNameInputField = g(rename, "", 1, "N", "Enter Job Name");
        } catch (Exception e) {
            throw new Error("Can not find element input field 'Enter job name");
        }
        try {
            okBtn = g(rename, "", 1, "N", "OK");
        } catch (Exception e) {
            throw new Error("can not find element OK button");
        }
        try {
            cancelBtn = g(rename, "", 1, "N", "Cancel");
        } catch (Exception e) {
            throw new Error("Can not fine element Cancel button");
        }
    }
    public RenameWindow inputJobName(String _name){
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

    public MainWindow clickCancleBtn(){
        try {
            cancelBtn.clickMM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MainWindow();
    }
}
