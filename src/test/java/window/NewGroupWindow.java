package window;

import Tools.Elem;
import daima.DElement;

public class NewGroupWindow extends Elem {
    private DElement window;
    private DElement groupNameInputField;
    private DElement okBtn;
    private DElement cancelBtn;

    public NewGroupWindow(){
        try {
            window = g(mainWindow, "Create New Group Window", 1, "N", "New Group");
            groupNameInputField = g(window, "New Group Input field", 1, "N", "Enter Group Name");
            okBtn = g(window, "OK Button", 1, "N", "OK");
            cancelBtn = g(window, "Cancel Button", 1, "N", "Cancel");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public NewGroupWindow inputGroupName(String _name){
        try {
            groupNameInputField.setValue(_name);
        } catch (Exception e) {
            throw  new Error(e.getMessage());
        }
        return this;
    }

    public MainWindow clikOKbutton(){
        try {
            okBtn.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new MainWindow();
    }

    public MainWindow clickCancelBtn(){
        try {
            cancelBtn.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new MainWindow();
    }
}
