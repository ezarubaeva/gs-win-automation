package Tools; /**
 * Created by Autotester on 10/4/2017.
 */
import Tools.Elem;
import daima.DElement;
import daima.KeyboardHandler;

public class BrowseDialog extends Elem {
    public static void selectLeftFolder (String fileSystem, String path) throws Exception {
        DElement editorW = g(null,"GoodSync",1,"N","GoodSync - All Jobs");
        editorW.setForeground();
        DElement wrk = g(editorW,"Text",1,"n","Please click here to select folder");
        wrk = g(editorW,"Text",1,"n","Please click here to select folder");
        wrk.click();
        sleep(1);
    }
    public static void selectRightFolder (String fileSystem, String path) throws Exception {
        DElement editorW = g(null,"GoodSync",1,"N","GoodSync - All Jobs");
        editorW.setForeground();
        // create new job
        DElement wrk = g(editorW,"Text",1,"n","Please click here to select folder");
        wrk.click();
        sleep(1);
    }
}
