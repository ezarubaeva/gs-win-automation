package Messages;

import Tools.Elem;
import daima.DElement;

public class AlertWindow extends Elem {
    DElement alertWnd;
    DElement okBtn;

    public AlertWindow(){
        try {
            alertWnd = g(mainWindow, "", 1, "dc", "#32770");
        } catch (Exception e) {
            throw new Error("Can not find alert window: " + e.getMessage());
        }
        try {
            okBtn = g(alertWnd, "", 1, "N", "OK");
        } catch (Exception e) {
            throw new Error("Can not find OK btn in alert window:" + e.getMessage());
        }
    }

    public String getAlertText(){
        try {
            return alertWnd.getEditText();
        } catch (Exception e) {
            throw new Error("Can not get alert text message: " + e.getMessage());
        }
    }

    public void clickOkBtn(){
        try {
            okBtn.clickMM();
        } catch (Exception e) {
            throw new Error("Error on clicking OK button: " + e.getMessage());
        }
    }
}
