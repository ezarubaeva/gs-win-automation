package window.ToolsContextClasses;

import Tools.Elem;
import daima.DElement;
import window.MainWindow;

public class RunnerServiceSetup extends Elem {
    private DElement windowsUserInputField;
    private DElement windowsPasswdInputField;
    private DElement applyBtn;
    private DElement backBtn;
    private DElement cancelBtn;

    public RunnerServiceSetup(){
        super();
        DElement runServiceWnd = null;
        try {
            runServiceWnd = g(mainWindow, "", 1, "N", "Runner Service Setup");
        } catch (Exception e) {
            throw new Error("Can not find element Runner service setup");
        }
        try {
            windowsUserInputField = g(runServiceWnd, "", 1, "N", "Windows User");
        } catch (Exception e) {
            throw new Error("Can not find element windows user id field");
        }
        try {
            windowsPasswdInputField = g(runServiceWnd, "", 1, "N", "Windows Password");
        } catch (Exception e) {
            throw new Error("Can not find element windows password field");
        }
        try {
            backBtn = g(runServiceWnd, "", 1, "N", "< Back");
        } catch (Exception e) {
            throw new Error("Can not find element Back btn");
        }
        try {
            applyBtn = g(runServiceWnd, "", 1, "N", "Apply");
        } catch (Exception e) {
            throw new Error("Can not find element apply btn");
        }
        try {
            cancelBtn = g(runServiceWnd, "", 1, "N", "Cancel");
        } catch (Exception e) {
            throw new Error("Can not find element Cancel btn");
        }
    }

    public RunnerServiceSetup inputWindowsUserName(String _name){
        try {
            windowsUserInputField.setValue(_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getWindowsUserName(){
        String str = null;
        try {
            str = windowsUserInputField.getEditText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public RunnerServiceSetup inputWindowsPassword(String _password){
        try {
            windowsPasswdInputField.setValue(_password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainWindow clickApplyBtn(){
        try {
            applyBtn.clickMM();
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
