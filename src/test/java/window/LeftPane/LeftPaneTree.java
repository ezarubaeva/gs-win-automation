package window.LeftPane;

import Tools.Elem;
import daima.DElement;
import window.ContextMenu.GroupContextMenu;
import window.ContextMenu.JobContextMenu;

public class LeftPaneTree extends Elem {
    private DElement allJobs;
    private DElement backupJobs;
    private DElement syncJobs;

    public LeftPaneTree(){
        try {
            allJobs = g(mainWindow, "All Jobs Tree", 1, "dN", "All Jobs");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public LeftPaneTree expand_collapseAllJobsNode(){
        try {
            allJobs.doubleClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new LeftPaneTree();
    }

    public LeftPaneTree expand_collapseBackupJobsNode(){
        try {
            backupJobs.doubleClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new LeftPaneTree();
    }

    public boolean isAllJobsExpanded(){
        return allJobs.isExpanded();
    }

    public boolean isBackupJobsExpanded(){
        return backupJobs.isExpanded();
    }

    public boolean isSyncJobsExpanded(){
        return syncJobs.isExpanded();
    }

    public DElement getBackupJobsElem(){
        try {
            backupJobs = g(mainWindow, "Back Up Job", 1, "dN", "Backup Jobs");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return backupJobs;
    }

    public DElement getSyncJobsElem(){
        try {
            syncJobs = g(mainWindow, "Sync Jobs", 1, "dN", "Sync Jobs");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return syncJobs;
    }

    public DElement getAllJobsElem(){
        return allJobs;
    }

    public boolean isJobPresentInAllJobsTree(String _str){
        try {
            g(getAllJobsElem(), "All Jobs Tree", 1, "N", _str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isJobPresentInBackupTree(String _name){
        try {
            g(getBackupJobsElem(), "Backup Jobs Tree", 1, "N", _name);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isJobPresentInSyncTree(String _name){
        try {
            g(getSyncJobsElem(), "Sync Jobs Tree", 1, "N", _name);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public LeftPaneTree doubleClickOnAllJobs(){
        try {
            allJobs.doubleClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public LeftPaneTree doubleClickOnBackupJobs(){
        try {
            backupJobs.doubleClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public LeftPaneTree doubleClickOnSyncJobs(){
        try {
            syncJobs.doubleClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public LeftPaneTree selectElement(String _element){
        try {
            DElement element = g(mainWindow, "Select Element", 1, "dN", _element);
            element.click();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return this;
    }

    public JobContextMenu callJobContextMenu(String _jobName){
        try {
            DElement job = g(mainWindow, "", 1, "dN", _jobName);
            job.contextClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new JobContextMenu();
    }

    public GroupContextMenu callGroupContextMenu(String _groupName){
        try {
            DElement group = g(mainWindow, "", 1, "dN", _groupName);
            group.contextClick();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new GroupContextMenu();
    }
}
