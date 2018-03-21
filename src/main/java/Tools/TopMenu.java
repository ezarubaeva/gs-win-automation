package Tools;

import daima.KeyboardHandler;

public class TopMenu extends Elem {
    public static void jobNew (String fileSystem) throws Exception {
        KeyboardHandler.sendKeysHere(true,"%n");
        KeyboardHandler.sendKeysHere(true, fileSystem);
        KeyboardHandler.sendKeysHere(true, "{ENTER}");
    }
}
