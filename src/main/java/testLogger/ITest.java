package testLogger;


import java.util.Vector;

import static jnaex.Run.RunnerMother.sleepy;

/**
 * Created by Autotester on 10/17/2017.
 */
public interface ITest {
    void performTest(Vector<String> buf);
    static void preinstall(boolean shouldDo) throws Exception{
        if (shouldDo){
            //pre-install actions
            sleepy(2);
        }
    }
    static void uninstallIfError(boolean shouldDo){
        if (shouldDo){
            //uninstall actions
            sleepy(2);
        }
    }
}
