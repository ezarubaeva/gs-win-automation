package Tools;

import daima.DElement;
import daima.KeyboardHandler;

public class Elem {
    protected DElement mainWindow; // Its possible should be in Elem class

    public Elem(){
        try {
            mainWindow = g(null, "GoodSync Main Window", 1, "N", "GoodSync -");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DElement g(DElement _parent, String _dn, int _a, String _x, String..._xx) throws Exception{
        return DElement.gimMeP(_parent,_dn,_a,_x,_xx);
    }
    public static void sleep(int _i){
        try{
            Thread.sleep(_i*1000);
        } catch (Exception e){
            System.out.println("!");
        }

    }

    public static void createJob (String fileSystem) throws Exception {
        KeyboardHandler.sendKeysHere(true,"%n");
        KeyboardHandler.sendKeysHere(true, fileSystem);
        KeyboardHandler.sendKeysHere(true, "{ENTER}");
        BrowseDialog.selectLeftFolder("folder", "");
    }
}
