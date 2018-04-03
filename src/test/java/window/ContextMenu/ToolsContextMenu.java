package window.ContextMenu;

import Tools.Elem;
import daima.DElement;
import jnaex.Tests.GoodSyncConnect.GoodSyncConnectTest;
import window.ProgramOptions.ProgramOptions;

public class ToolsContextMenu extends Elem {
    private DElement programOptions;
    private DElement goodsyncConnectSetup;
    private DElement runnerServiceSetup;
    private DElement serverAdvancedOptions;
    private DElement uploadAccountsToControlCenter;
    private DElement uploadJobsToControlCenter;
    private DElement exportAllJobs;
    private DElement exportSelectedJobs;
    private DElement importJobList;

    public ToolsContextMenu(){
        try {
            programOptions = g(mainWindow, "", 1, "N", "Program Options...");
            goodsyncConnectSetup = g(mainWindow, "", 1, "N", "GoodSync Connect Setup...");
            runnerServiceSetup = g(mainWindow, "", 1, "N", "Runner Service Setup...");
            serverAdvancedOptions = g(mainWindow, "", 1, "N", "Server Advanced Options...");
            uploadAccountsToControlCenter = g(mainWindow, "", 1, "N", "Upload Accounts to");
            uploadJobsToControlCenter = g(mainWindow, "", 1, "N", "Upload Jobs to");
            exportAllJobs = g(mainWindow, "", 1, "N", "Export All Jobs...");
            exportSelectedJobs = g(mainWindow, "", 1, "N", "Export Selected Jobs");
            importJobList = g(mainWindow, "", 1, "N", "Import Job List...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProgramOptions selectProgramOptions(){
        try {
            programOptions.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProgramOptions();
    }

    public GoodSyncConnectTest selectGSconnectSetup(){
        try {
            goodsyncConnectSetup.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GoodSyncConnectTest();
    }
}
