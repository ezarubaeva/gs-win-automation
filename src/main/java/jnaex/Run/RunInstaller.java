package jnaex.Run;

import jnaex.Tests.Utils.AmazonWorkspacesTest;
import testLogger.ITest;
import testLogger.Test;
import testLogger.TestSet;


/**
 * Created by Evgenia on 30-May-17.
 */
public class RunInstaller extends RunnerMother{

    public static void main(TestSet set, String[] args) throws Exception {
        Test pr121 = new Test("Amazon1");
        performTest(new AmazonWorkspacesTest(), buf, pr121); //not actual //ok jna
        set.addTest(pr121);

        Test pr122 = new Test("Amazon2 - the same");
        performTest(new AmazonWorkspacesTest(), buf, pr122); //ok jna
        set.addTest(pr122);
    }
}






