package test;

import Helpers.ApplicationRunHandler;
import WebTools.MediatorPage;
import daima.DElement;
import jnaex.RFWin.Proc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import window.MainWindow;

import java.util.Random;

import static Tools.Elem.g;
import static Tools.Elem.sleep;

/**
 * Created by E.Zarubaeva on 03/21/2017.
 */
public class GoodSyncConnectTest {
    ApplicationRunHandler app;
    MainWindow mainWindow;

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

    @BeforeClass
    public void beforeClass(){
        app =new ApplicationRunHandler();
        app.runGoodSyncApp();
        mainWindow = new MainWindow();
    }

    @AfterClass
    public void afterClass(){
        app.closeGoodSyncApp();
    }

    @Test
    public void setupLocal() throws Exception {
        try {
            callSetup ();
            chooseMode ( "no" );
            sleep ( 1 );
            DElement gsW = g ( null, "setupLocal: GoodSync Connect Setup window", 2, "ln", "window", "GoodSync Connect Setup" );
            DElement wrk = g ( gsW, "Text: Local Only mode", 2, "lN", "text", "Local Only mode" );
            clickApply (gsW);
            wrk = g ( gsW, "Text: Committing", 10, "UlN", "100", "text", "Committing" );
            DElement.gimMeP ( null, "setupLocal: wait GoodSync Connect Setup to close", 4, "Dn", "GoodSync Connect Setup" );
        } catch (Exception e) {
        }
    }

    @Test
    public void setupExistingAccountTest(String windowsUser, String windowsPassword) throws Exception {
        try {
            callSetup ();
            chooseMode ( "yes" );
            DElement gsW = g ( null, "setupExistingAccount: GoodSync Connect Setup window", 2, "n", "GoodSync Connect Setup" );
            configureGSAccount ( "testbot", "testbot" );

            // Do not change windows user for now
            //wrk.setEditValue (windowsUser);
            DElement wrk = g ( gsW, "Edit: Windows Password", 3, "lN", "edit", "Windows Password" );
            wrk.setEditValue ( windowsPassword );
            clickNext (gsW);

            verifyServerMode ( "testbot", "gs_qa@siber.com" );
        } catch (Exception e) {
        }
    }

    public void setupNewAccount(String windowsUser, String windowsPassword) throws Exception {
        callSetup ();
        chooseMode ( "yes" );
        sleep ( 1 );
        DElement gsW = g ( null, "setupNewAccount: GoodSync Connect Setup window", 2, "n", "GoodSync Connect Setup" );
        DElement wrk = g ( gsW, "Radio button Yes", 1, "lN", "radio button", "Create a new GoodSync Connect Account" );
        wrk.click ();

        Random rn = new Random ();
        int tail = rn.nextInt ( 1000 );
        String gsUser = "testbot" + tail;
        String gsEmail = "gs_qa" + tail + "@siber.com";

        wrk = g ( gsW, "GS Account Email = "+ gsEmail , 2, "ln", "edit", "Email" );
        wrk.setEditValue ( gsEmail );
        wrk = g ( gsW, "GS Account Password = testbot", 1, "ln", "edit", "Password" );
        wrk.setEditValue ( "testbot" );
        wrk = g ( gsW, "GS Account Retype", 1, "ln", "edit", "Retype" );
        wrk.setEditValue ( "testbot" );
        wrk = g ( gsW, "GS Account Email = " + gsUser, 1, "ln", "edit", "Your Name" );
        wrk.setEditValue ( gsUser );

        clickNext (gsW);

        // Do not change windows user for now
        //wrk.setEditValue (windowsUser);
        wrk = g ( gsW, "Edit: Windows Password", 3, "lN", "edit", "Windows Password" );
        wrk.setEditValue ( windowsPassword );
        clickNext (gsW);

        sleep (1);
        verifyServerMode("gs_qa" + tail, gsEmail);

        deleteGSAccount ( gsEmail, "testbot");
    }

    public void deleteGSAccount(String gsUser, String gsPassword) throws Exception {
        WebDriver driverBrowser = new ChromeDriver ();
        MediatorPage.deleteGSUser (driverBrowser, gsUser, gsPassword);
    }

    public void clickNext(DElement gsW) {
        try {
            DElement wrk = g ( gsW, "Clicking Button Next", 1, "ln", "button", "Next >" );
            wrk.click ();
            sleep ( 1 );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void clickApply(DElement gsW) {
        //DElement gsW = null;
        try {
            DElement wrk = g ( gsW, "Clicking Button Apply", 1, "ln", "button", "Apply" );
            wrk.click ();
            sleep ( 1 );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void chooseMode(String mode) throws Exception {
        DElement gsW = g ( null, "chooseMode: GoodSync Connect Setup window", 3, "lN", "window", "GoodSync Connect Setup" );
        DElement wrk;
        if (mode.equals ( "yes" )) {
            wrk = g ( gsW, "Radio button Yes", 1, "lN", "radio button", "Yes, connect my computers using GoodSync Connect" );
        } else {
            wrk = g ( gsW, "Radio button No", 1, "lN", "radio button", "No, do not setup GoodSync Connect" );
        }

        wrk.click ();
        clickNext (gsW);
    }

    public void callSetup() throws Exception {
        try {
            mainWindow.clickToolsToolBarMenu ();
            DElement wrk = g ( null, "callSetup: Tools items", 1, "n", "Context" );
            wrk = g ( wrk, "Tools > GoodSync Connect Setup menu item", 1, "n", "GoodSync Connect Setup..." );
            wrk.click ();
            sleep ( 1 );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void verifyServerMode(String gsUser, String gsEmail) throws Exception {
        try {
            DElement gsW = g ( null, "verifyServerMode: GoodSync Connect Setup window", 1, "lN", "window", "GoodSync Connect Setup" );
            DElement wrk = g ( gsW, "Result text - sever label", 1, "lN", "text", "GoodSync Connect: Server Mode" );

            String gstp_Address = "." + gsUser + "-siber-com.goodsync";
            String gstp_Email = "Connect Email: " + gsEmail;
            String gstp_Account = "Connect Account: " + gsUser + "-siber-com";
            wrk = g ( gsW, "Result text - computer label", 1, "lN", "text", "This Computer address: gstp://" );
            wrk = g ( gsW, "Result text - gstp_Address" + gstp_Address, 1, "lN", "text", gstp_Address );
            wrk = g ( gsW, "Result text - gstp_Email" + gstp_Email, 1, "lN", "text", gstp_Email );
            wrk = g ( gsW, "Result text - Connect Account" + gstp_Account, 1, "lN", "text", gstp_Account );
            wrk = g ( gsW, "Result text - label Windows User", 1, "lN", "text", "Windows User:" );
            wrk = g ( gsW, "Result text - label Auth User", 1, "lN", "text", "Auth User:" );
            wrk = g ( gsW, "Result text - label Auth Name", 1, "lN", "text", "Auth Name:" );

            clickApply (gsW);
            DElement.gimMeP ( null, "verifyServerMode: wait GoodSync Connect Setup to close", 4, "Dn", "GoodSync Connect Setup" );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void configureGSAccount(String gsUser, String password) throws Exception {
        try {
            DElement gsW = g ( null, "configureGSAccount: GoodSync Connect Setup window", 2, "n", "GoodSync Connect Setup" );
            DElement wrk = g ( gsW, "Text - UserId or Email", 2, "n", "UserId or Email" );
            wrk.setEditValue ( gsUser );
            wrk = g ( gsW, "Text - Password", 2, "n", "Password" );
            wrk.setEditValue ( password );
            clickNext (gsW);

            sleep (2);

            wrk = g ( gsW, "Explaining text", 5, "lN", "text", "GoodSync Server needs your Windows password to impersonate you for GoodSync client." );
            wrk = g ( gsW, "Windows User", 3, "lN", "edit", "_GoodSync_Dialog_" );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}