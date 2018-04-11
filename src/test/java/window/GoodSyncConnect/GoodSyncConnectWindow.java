package window.GoodSyncConnect;
import Tools.Elem;
import WebTools.MediatorPage;
import daima.DElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import window.MainWindow;

import java.io.IOException;
import java.util.Random;

public class GoodSyncConnectWindow extends Elem {
    private DElement gsW;

    public GoodSyncConnectWindow() {
        try {
            gsW = g ( null, "GoodSyncConnectWindow init: GoodSync Connect Setup window", 5, "dlN",
                    "window", "GoodSync Connect Setup" );
        } catch (Exception e) {
            throw new Error ( "Can not find GoodSyncConnectWindow in 3 sec: " + e.getMessage() );
        }
    }

    public void setupLocal() {
        try {
            chooseMode ( "no" );
            DElement wrk = g ( gsW, "Text: Local Only mode", 1, "lN", "text", "Local Only mode" );
            clickApply ();
            //wrk = g ( gsW, "Text: Committing", 10, "UlN", "100", "text", "Committing" );
            DElement.gimMeP ( null, "setupLocal: wait GoodSync Connect Setup to close", 4, "Dn", "GoodSync Connect Setup" );
        } catch (Exception e) {
            throw new Error ( "Error in setupLocal: Local Mode was not set" );
        }
    }

    public void setupNewAccount( String windowsPassword) throws Exception {
        try {
        chooseMode ( "yes" );
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

        clickNext ();

        // Do not change windows user for now
        wrk = g ( gsW, "Edit: Windows Password", 2, "lN", "edit", "Windows User" );
        wrk.setEditValue (System.getProperty("user.name"));
        wrk = g ( gsW, "Edit: Windows Password", 1, "lN", "edit", "Windows Password" );
        wrk.setEditValue ( windowsPassword );
        clickNext ();

        sleep (1);
        verifyServerMode("gs_qa" + tail, gsEmail);

        deleteGSAccount ( gsEmail, "testbot");
        } catch (Exception e) {
            throw new Error ( "GoodSync Connect: New account was not setup" );
        }
    }

    public void setupExistingAccount(String windowsPassword) {
        DElement gsW = null;
        try {
            gsW = g ( null, "setupExistingAccount: GoodSync Connect Setup window", 2, "dN", "GoodSync Connect Setup" );
        } catch (Exception e) {
            throw new Error("Can not find element GoodSync Connect Setup Wnd: " + e.getMessage());
        }
        try {
            configureGSAccount ( "testbot", "testbot" );
        } catch (Exception e) {
            throw new Error("Error on configuring GS Account: " + e.getMessage());
        }

        // Do not change windows user for now
        DElement wrk = null;
        try {
            wrk = g ( gsW, "Edit: Windows User", 3, "lN", "edit", "Windows User" );
        } catch (Exception e) {
            throw new Error("Can not find element Edit: Windows user: " + e.getMessage());
        }
        try {
            wrk.setEditValue (System.getProperty("user.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            wrk = g ( gsW, "Edit: Windows Password", 1, "lN", "edit", "Windows Password" );
        } catch (Exception e) {
            throw new Error("Can not find element Edit: Windows password: " + e.getMessage());
        }
        try {
            wrk.setEditValue ( windowsPassword );
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickNext ();

        try {
            verifyServerMode ( "testbot", "gs_qa@siber.com" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGSAccount(String gsUser, String gsPassword) throws Exception {
        WebDriver driverBrowser = new ChromeDriver ();
        MediatorPage.deleteGSUser (driverBrowser, gsUser, gsPassword);
    }

    public void clickNext() {
        try {
            DElement wrk = g ( gsW, "Clicking Button Next", 1, "ln", "button", "Next >" );
            wrk.click ();
            sleep ( 1 );
        } catch (Exception e) {
            throw new Error("clickNext: cannot click Next button in Configure GoodSync Connect window");
        }
    }

    public void clickApply () {
        try {
            DElement wrk = g ( gsW, "Clicking Button Apply", 1, "ln", "button", "Apply" );
            wrk.click ();
            sleep ( 1 );
        } catch (Exception e) {
            throw new Error("clickApply: cannot click Apply button in Configure GoodSync Connect window");
        }
    }

    public void chooseMode(String mode) throws Exception {
        try {
            DElement wrk;
            if (mode.equals ( "yes" )) {
                wrk = g ( gsW, "Radio button Yes", 1, "lN", "radio button", "Yes, connect my computers using GoodSync Connect" );
            } else {
                wrk = g ( gsW, "Radio button No", 1, "lN", "radio button", "No, do not setup GoodSync Connect" );
            }

            wrk.click ();
            clickNext ();
        } catch (Exception e) {
            throw new Error("chooseMode: cannot choose mode in Configure GoodSync Connect window");
        }
    }

    public void verifyServerMode(String gsUser, String gsEmail) throws Exception {
        try {
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

            clickApply ();
            DElement.gimMeP ( null, "verifyServerMode: wait GoodSync Connect Setup to close", 4, "Dn", "GoodSync Connect Setup" );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void configureGSAccount(String gsUser, String password) throws Exception {
        try {
            DElement wrk = g ( gsW, "Text - UserId or Email", 2, "n", "UserId or Email" );
            wrk.setEditValue ( gsUser );
            wrk = g ( gsW, "Text - Password", 2, "n", "Password" );
            wrk.setEditValue ( password );
            clickNext ();

            sleep (2);

            wrk = g ( gsW, "Explaining text", 5, "lN", "text", "GoodSync Server needs your Windows password to impersonate you for GoodSync client." );
            wrk = g ( gsW, "Windows User", 3, "lN", "edit", "_GoodSync_Dialog_" );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

}
