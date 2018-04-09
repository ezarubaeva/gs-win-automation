package window.ProgramOptions;

import Tools.Elem;
import daima.DElement;

public class ProgramOptions extends Elem {
    private DElement generalTab;
    private DElement autoTab;
    private DElement securityTab;
    private DElement filtersTab;
    private DElement connetionTab;
    private DElement aboutTab;


    public ProgramOptions(){
        DElement prOptions = null;
        try {
            prOptions = g(mainWindow, "", 1, "N", "Program Options - GoodSync");
        } catch (Exception e) {
            throw new Error("Can not find element program options wnd");
        }
        try {
            generalTab = g(prOptions, "", 1, "N", "General");
        } catch (Exception e) {
            throw new Error("Can not find element General tab");
        }
        try {
            autoTab = g(prOptions, "", 1, "N", "Auto");
        } catch (Exception e) {
            throw new Error("Can not find element Auto tab");
        }
        try {
            securityTab = g(prOptions, "", 1, "N", "Security");
        } catch (Exception e) {
            throw new Error("Can not find element Security tab");
        }
        try {
            filtersTab = g(prOptions, "", 1, "N", "Filters");
        } catch (Exception e) {
            throw new Error("Can not find element Filters tab");
        }
        try {
            connetionTab = g(prOptions, "", 1, "N", "Connection");
        } catch (Exception e) {
            throw new Error("Can not find element Connection tab");
        }
        try {
            aboutTab = g(prOptions, "", 1, "N", "About");
        } catch (Exception e) {
            throw new Error("can not find element About tab");
        }
    }

    public GeneralTab clickGeneralTab(){
        try {
            generalTab.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GeneralTab();
    }

    public AutoTab clickAutoTab(){
        try {
            autoTab.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AutoTab();
    }
}
