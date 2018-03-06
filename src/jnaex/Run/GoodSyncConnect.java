package jnaex.Run;

import jnaex.Tests.GoodSyncConnect.GoodSyncConnectTest;
import testLogger.Test;
import testLogger.TestSet;


/**
 * Created by Evgenia on 30-May-17.
 */
public class GoodSyncConnect extends RunnerMother{

    public static void main(TestSet set, String[] args) throws Exception {
        Test pr121 = new Test("GoodSync Connect Test");
        performTest(new GoodSyncConnectTest (), buf, pr121);
        set.addTest(pr121);

    }
}






