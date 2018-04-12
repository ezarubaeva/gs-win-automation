package Tools;

import daima.DElement;
import daima.KeyboardHandler;

import java.util.Vector;

public class Elem {
    protected DElement mainWindow; // Its possible should be in Elem class

    public Elem(){
        try {
            //mainWindow = g(null, "GoodSync Main Window", 1, "N", "GoodSync -");
            mainWindow = g(null, "GoodSync Main Window", 1, "C", "{B26B00DA-2E5D-4CF2-83C5-911198C0F009}");
        } catch (Exception e) {
            throw new Error("Can not find GoodSync window element");
        }
    }
    public static DElement g(DElement _parent, String _dn, int _a, String _x, String..._xx) throws Exception{
        return DElement.gimMeP(_parent,_dn,_a,_x,_xx);
    }
    // should be used if we need to choose Nth element from the array of the controls
    public static DElement gN(DElement _parent, String _dn, int _a, int _index, String _xattrlist, String..._xattrs) throws Exception{
        return DElement.gimMePN ( _parent,_dn,_a,_index,_xattrlist,_xattrs );
    }

    public static Vector<DElement> gV(DElement _parent, String _dn, int _a, String _xattrlist, String..._xattrs) throws Exception {
        return DElement.gimMePV ( _parent, _dn, _a , _xattrlist, _xattrs);
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

    protected void setCheckBoxToValue(DElement _element, boolean _value){
        String currentCheckBoxState = null;
        try {
            currentCheckBoxState = _element.getToggleState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (currentCheckBoxState.isEmpty()){
            throw new Error("CheckBox doesn't have toggle state on/off");
        }
        if (_value){
            if (currentCheckBoxState.equals("Off")){
                try {
                    _element.click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (currentCheckBoxState.equals("On")){
                try {
                    _element.click();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
