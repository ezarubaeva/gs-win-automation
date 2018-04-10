package test;

import Helpers.ApplicationRunHandler;
import daima.DElement;
import jnaex.RFWin.Proc;
import Helpers.ApplicationRunHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import window.GoodSyncConnect.GoodSyncConnectWindow;
import window.MainWindow;

import java.io.IOException;

import static Tools.Elem.g;
import static Tools.Elem.sleep;

/**
 * Created by E.Zarubaeva on 03/21/2017.
 */
public class GoodSyncConnectTest {
    GoodSyncConnectWindow gsConnectWin;
    ApplicationRunHandler app;
    MainWindow mainWindow;

    @BeforeClass
    public void beforeClass() throws IOException, InterruptedException {
        app = new ApplicationRunHandler();
        app.runGoodSyncApp();
        mainWindow = new MainWindow ();
    }

    @AfterClass
    public void afterClass(){
        app.closeGoodSyncApp();
    }

    private void sleepy(double s) {  //in seconds
        Proc.sleepy ( s );
    }

    private void log(String s) { //normal log
        Proc.log ( s );
    }

    private void logE(String s) { //error log
        Proc.logE ( s );
    }

    private static DElement gL(DElement _parent, String _descr, int _attempts, String _XattrList, String... _Xattrs) throws Exception {
        return Proc.gL ( _parent, _descr, _attempts, _XattrList, _Xattrs );
    }

    @Test
    public void setupLocalTest() throws Exception {
        try {
            gsConnectWin = mainWindow.clickToolsToolBarMenu().selectGSconnectSetup();
            sleep ( 1 );
            gsConnectWin.setupLocal ();
        } catch (Exception e) {
        }
    }

    @Test
    void setupExistingAccountTest() throws Exception {
        try {
            gsConnectWin = mainWindow.clickToolsToolBarMenu().selectGSconnectSetup();
            gsConnectWin.setupExistingAccount ("test");
        } catch (Exception e) {
        }
    }

    @Test
    void setupNewAccountTest() throws Exception {
        try {
            gsConnectWin = mainWindow.clickToolsToolBarMenu().selectGSconnectSetup();
            gsConnectWin.setupNewAccount ( "test" );
        } catch (Exception e) {
        }
    }
}