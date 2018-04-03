package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import window.LeftPane.LeftPaneTree;
import window.MainWindow;

public class testClass {
    MainWindow mainWindow;

    @BeforeClass
    public void beforeClass(){
        mainWindow = new MainWindow();
    }

    @Test
    public void newJobIsPlacedInAllJobsTest(){
            mainWindow.clickNewJobButton()
                    .setJobName("blabla")
                    .setBackUPradioButton()
                    .clickOkbutton();
        Assert.assertTrue(new LeftPaneTree().isJobPresentInAllJobsTree("blabla"));
    }

    @Test
    public void newBackUpJobPresentInBackupGroupTest(){
        mainWindow.clickNewJobButton()
                .setJobName("azaza")
                .setBackUPradioButton()
                .clickOkbutton();
        Assert.assertTrue(new LeftPaneTree().isJobPresentInBackupTree("azaza"));
    }

    @Test
    public void newBackupJobIsNotPresentInSyncJobsTest(){
        mainWindow.clickNewJobButton()
                .setJobName("troll")
                .setBackUPradioButton()
                .clickOkbutton();
        Assert.assertFalse(new LeftPaneTree().isJobPresentInSyncTree("troll"));
    }
}
