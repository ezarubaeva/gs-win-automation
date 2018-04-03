package window;

import Tools.Elem;
import daima.DElement;

public class RenameWindow extends Elem {
    private DElement rename;
    private DElement jobNameInputField;
    private DElement okBtn;
    private DElement cancelBtn;

    public RenameWindow(){
        try {
            rename = g(mainWindow, "", 1, "N", "Rename Job");
            jobNameInputField = g(rename, "", 1, "N", "Enter Job Name");
            okBtn = g(rename, "", 1, "N", "OK");
            cancelBtn = g(rename, "", 1, "N", "Cancel");
        } catch (Exception e) {
            e.printStackTrace();
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
