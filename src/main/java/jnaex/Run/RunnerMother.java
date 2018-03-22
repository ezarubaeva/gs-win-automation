package jnaex.Run;


import java.util.Vector;

import jnaex.RFWin.*;
import testLogger.ITest;
import testLogger.Test;

/**
 * Created by Autotester on 6/21/2017.
 */
public class RunnerMother {
    static Vector<String> buf = new Vector<String>();

    public static void sleepy(double s){  //in seconds
        Proc.sleepy(s);
    }


    /**
     * Method that determines whether the test is successful or not by analyzing the last string
     * @param marker the last test string
     * @return True if the test is successful
     */
    private static boolean isTSuccessful(String marker){
        boolean result = true;
        //'ERROR' + logSeparator (': ' was in the beginning)
        if (marker.indexOf("ERROR" + Proc.logSeparator) == 0){
            result = false;
        }
        return result;
    }

    static void bufToTest(Vector<String> _buf, Test _test){
        for (String st : _buf){
            _test.writeDebugInfo(st);
        }
        if (isTSuccessful(_buf.elementAt(_buf.size() - 1))){
            _test.stop();
        } else {
            _test.stop(false);
        }
        _buf.clear();
    }
    public static void performTest(ITest _met, Vector<String> _buf, Test _watcher){
        int att = 1;
        _met.performTest(_buf);
        bufToTest(_buf,_watcher);
        while (!(_watcher.isSuccessful()) && (att < 3)) {
            _watcher.reset();
            _buf.clear();
            _met.performTest(_buf);
            bufToTest(_buf,_watcher);
            att++;
        }
    }

}
