package window.ContextMenu;

import Tools.Elem;
import daima.DElement;
import jnaex.Tests.GoodSyncConnect.GoodSyncConnectTest;
import window.GoodSyncConnect.GoodSyncConnectWindow;
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

    public ToolsContextMenu() {
        super();
        DElement parentMenu = null;
        try {
            parentMenu = g(null, "Whole menu - Tools", 1, "lN", "menu", "Context");
        } catch (Exception e) {
            throw new Error("Can not find element Whole menu -> Tools: " + e.getMessage());
        }
        try {
            programOptions = g(parentMenu, "Tools -> Program options", 1, "lN", "menu item", "Program Options...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Program options");
        }
        try {
            goodsyncConnectSetup = g(parentMenu, "Tools -> GS connect setup", 1, "N", "GoodSync Connect Setup...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> GS connect setup");
        }
        try {
            runnerServiceSetup = g(parentMenu, "Tools -> Runner service setup", 1, "N", "Runner Service Setup...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Runner service setup");
        }
        try {
            serverAdvancedOptions = g(parentMenu, "Tools -> Server Advanced Options", 1, "N", "Server Advanced Options...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Server Advanced Options");
        }
        try {
            uploadAccountsToControlCenter = g(parentMenu, "Tools -> Upload accounts", 1, "N", "Upload Accounts to");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Upload accounts to");
        }
        try {
            uploadJobsToControlCenter = g(parentMenu, "Tools -> upload jobs to", 1, "N", "Upload Jobs to");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> upload jobs to");
        }
        try {
            exportAllJobs = g(parentMenu, "Tools -> Export all jobs", 1, "N", "Export All Jobs...");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Export all jobs");
        }
        try {
            exportSelectedJobs = g(parentMenu, "Tools -> Export selected jobs", 1, "N", "Export Selected Jobs");
        } catch (Exception e) {
            throw new Error("Can not find element Tools -> Export selected jobs");
        }
        try {
            importJobList = g(parentMenu, "Tools -> Import job list", 1, "N", "Import Job List...");
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

    public GoodSyncConnectWindow selectGSconnectSetup(){
        try {
            goodsyncConnectSetup.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GoodSyncConnectWindow ();
    }
}
