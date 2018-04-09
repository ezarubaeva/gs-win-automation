package window;

import Tools.Elem;
import daima.DElement;

public class NewGroupWindow extends Elem {
    private DElement window;
    private DElement groupNameInputField;
    private DElement okBtn;
    private DElement cancelBtn;

    public NewGroupWindow(){
        super();
        try {
            window = g(mainWindow, "Create New Group Window", 1, "N", "New Group");
        } catch (Exception e) {
            throw new Error("can not find element Create new group window");
        }
        try {
            groupNameInputField = g(window, "New Group Input field", 1, "N", "Enter Group Name");
        } catch (Exception e) {
            throw new Error("Can not find element New group input field");
        }
        try {
            okBtn = g(window, "OK Button", 1, "N", "OK");
        } catch (Exception e) {
            throw new Error("Can not find element OK button");
        }
        try {
            cancelBtn = g(window, "Cancel Button", 1, "N", "Cancel");
        } catch (Exception e) {
            throw new Error("Can not find element Cancel button");
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
