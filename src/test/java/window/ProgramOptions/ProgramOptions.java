package window.ProgramOptions;

import Tools.Elem;
import com.sun.jna.platform.win32.OaIdl;
import daima.DElement;

public class ProgramOptions  extends Elem {
    private DElement prOptions;
    private DElement generalTab;
    private DElement autoTab;
    private DElement securityTab;
    private DElement filtersTab;
    private DElement connetionTab;
    private DElement aboutTab;


    public ProgramOptions(){
        try {
            prOptions = g(mainWindow, "", 1, "N", "Program Options - GoodSync");
            generalTab = g(prOptions, "", 1, "N", "General");
            autoTab = g(prOptions, "", 1, "N", "Auto");
            securityTab = g(prOptions, "", 1, "N", "Security");
            filtersTab = g(prOptions, "", 1, "N", "Filters");
            connetionTab = g(prOptions, "", 1, "N", "Connection");
            aboutTab = g(prOptions, "", 1, "N", "About");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
