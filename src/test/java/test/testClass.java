package test;

import Helpers.ApplicationRunHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import window.LeftPane.LeftPaneTree;
import window.MainWindow;

import java.io.IOException;

public class testClass {
    ApplicationRunHandler app;
    MainWindow mainWindow;

    @BeforeClass
    public void beforeClass() throws IOException, InterruptedException {
        app =new ApplicationRunHandler();
        app.runGoodSyncApp();
        mainWindow = new MainWindow();
    }

    @AfterClass
    public void afterClass(){
        app.closeGoodSyncApp();
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
