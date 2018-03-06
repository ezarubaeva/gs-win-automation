package jnaex.Tests.Utils;

import daima.DElement;
import daima.KeyboardHandler;
import daima.MouseHandler;
import daima.WindowHandler;
import jnaex.RFWin.Proc;
import testLogger.ITest;

import java.util.Vector;

/**
 * Created by Autotester on 12/13/2017.
 */
public class AmazonWorkspacesTest implements ITest{
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

            Proc.setGLP("Amazon semi-dummy test");
            Proc.lgP = "Second-level log prefix";

            DElement x = gL(null,"Amazon",1,"N","Amazon");
            WindowHandler.setForegroundWindow(x);
            MouseHandler.moveMouseTo(164 + 79, 173 + 188);
            MouseHandler.clickLeft();
            KeyboardHandler.sendKeysHere("userID");
            sleepy(2);
            MouseHandler.moveMouseTo(164+79, 173 + 231);
            MouseHandler.clickLeft();
            KeyboardHandler.sendKeysHere("password");


        log("Test was completed without fatal exceptions");
    } catch (Exception e) {
        logE(e.getMessage());
        ITest.uninstallIfError(Proc.preinstallRF);
    }
    buf = Proc.getBuf();
}
}