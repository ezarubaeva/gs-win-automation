package jnaex.Tests.GoodSyncConnect;

import daima.DElement;
import jnaex.RFWin.Proc;
import testLogger.ITest;

import java.util.Vector;

import static Tools.Elem.g;
import static Tools.Elem.sleep;

/**
 * Created by Autotester on 12/13/2017.
 */
public class GoodSyncConnectTest implements ITest{
    private void sleepy(double s) {  //in seconds
        Proc.sleepy(s);
    }

    private void log(String s) { //normal log
        Proc.log(s);
    }

    private void logE(String s) { //error log
        Proc.logE(s);
    }

    private static DElement gL(DElement _parent, String _descr, int _attempts, String _XattrList, String..._Xattrs) throws Exception{
        return Proc.gL(_parent,_descr,_attempts,_XattrList,_Xattrs);
    }

    @Override
    public void performTest(Vector<String> buf) {
        Proc.setBuf(buf);

        try {
            ITest.preinstall(Proc.preinstallRF);

            Proc.setGLP("GoodSync");
            Proc.lgP = "Connect Test";

            setupLocal();
            setupExistingAccount ();

            log("Test was completed without fatal exceptions");
    } catch (Exception e) {
        logE(e.getMessage());
        ITest.uninstallIfError(Proc.preinstallRF);
    }
    buf = Proc.getBuf();
}
    public static void setupLocal () throws Exception {
        callSetup();
        chooseMode ("no");
        sleep (1);
        clickNext ();
        DElement gsW = g(null,"GoodSync Connect Setup window",2,"ln","window", "GoodSync Connect Setup");
        DElement wrk = g(gsW, "Button Apply", 1, "n", "Apply");
        wrk.click();
        wrk = g(gsW, "Text - Local Only", 6, "ln", "text", "Local Only mode");
        wrk = g(gsW, "Button Apply", 1, "n", "Apply");
        wrk.click();
    }
    public static void clickNext () {
        DElement gsW = null;
        try {
            gsW = g(null,"GoodSync Connect Setup window",2,"ln","window", "GoodSync Connect Setup");
            DElement wrk = g(gsW, "Button Next", 1, "n", "Next >");
            wrk.click();
            sleep (1);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public static void setupExistingAccount () throws Exception {
        callSetup();
        chooseMode ("yes");
        clickNext ();
        DElement gsW = g(null,"GoodSync Connect Setup window",2,"ln","window", "GoodSync Connect Setup");
        DElement wrk = g(gsW, "Text - UserId or Email", 2, "n", "UserId or Email");
        wrk.setEditValue ("testbot");
        sleep (1);
    }

    public static void setupNewAccount () throws Exception {
        callSetup();
        chooseMode ("yes");
        sleep (1);
    }

    public static void chooseMode (String arg ) throws Exception {
        DElement gsW = g(null,"GoodSync Connect Setup window",2,"n","GoodSync Connect Setup");
        DElement wrk = g(gsW, "Radio button Yes", 1, "n", "Yes, connect my computers using GoodSync Connect");
        if(arg.equals("no")) {
            wrk = g(gsW, "Radio button No", 1, "n", "No, do not setup GoodSync Connect");
        }

        wrk.click();
        wrk = g (gsW, "Choose mode: Button Next", 1, "n", new String[]{"Next >"});
        wrk.click();
        if(arg.equals("no")) {
            wrk = g(gsW, "Button Apply", 2, "n", "Apply >");
        }
        else {
            wrk = g(gsW, "Button Next", 2, "n", "Next >");
        }
        wrk.click();
    }

    public static void callSetup () throws Exception {
        DElement gsW = g(null,"GoodSync main window",1,"N","GoodSync - All Jobs");
        gsW.setForeground();
        DElement toolbar = g(gsW,"Main tool bar",1,"l","tool bar");
        DElement menuItem = g(toolbar,"Tools menu item",1,"n","Tools");
        menuItem.click();
        DElement wrk = g(null,"Name",1,"n","Context");
        wrk = g (wrk, "Tools > GoodSync Connect Setup menu item", 1, "n", new String[]{"GoodSync Connect Setup..."});
        wrk.click();
        sleep (1);
    }
}