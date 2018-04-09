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
        super();
        try {
            programOptions = g(mainWindow, "", 1, "N", "Program Options...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Program options");
        }
        try {
            goodsyncConnectSetup = g(mainWindow, "", 1, "N", "GoodSync Connect Setup...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> GS connect setup");
        }
        try {
            runnerServiceSetup = g(mainWindow, "", 1, "N", "Runner Service Setup...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Runner service setup");
        }
        try {
            serverAdvancedOptions = g(mainWindow, "", 1, "N", "Server Advanced Options...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> server advanced options");
        }
        try {
            uploadAccountsToControlCenter = g(mainWindow, "", 1, "N", "Upload Accounts to");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Upload accounts to");
        }
        try {
            uploadJobsToControlCenter = g(mainWindow, "", 1, "N", "Upload Jobs to");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> upload jobs to");
        }
        try {
            exportAllJobs = g(mainWindow, "", 1, "N", "Export All Jobs...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Export all jobs");
        }
        try {
            exportSelectedJobs = g(mainWindow, "", 1, "N", "Export Selected Jobs");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Export selected jobs");
        }
        try {
            importJobList = g(mainWindow, "", 1, "N", "Import Job List...");
        } catch (Exception e) {
            throw new Error("can not find element Tools -> Import job list");
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
