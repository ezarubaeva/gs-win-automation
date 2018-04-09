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
            throw new Error("Can not find element All jobs tree");
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
            throw new Error("Can not find element Backup Jobs in tree");
        }
        return backupJobs;
    }

    public DElement getSyncJobsElem(){
        try {
            syncJobs = g(mainWindow, "Sync Jobs", 1, "dN", "Sync Jobs");
        } catch (Exception e) {
            throw new Error("Can not find element Sync jobs in tree");
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
        DElement element;
        try {
                element = g(mainWindow, "Select Element", 1, "dN", _element);
            } catch (Exception ex){
                throw new Error("Can not find element:" + _element);
            }
        try {
            element.click();
        } catch (Exception e) {
            throw new Error("Error on clicking element: " + _element + ". " + e.getCause());
        }
        return this;
    }

    public JobContextMenu callJobContextMenu(String _jobName){
        DElement job = null;
        try {
            job = g(mainWindow, "", 1, "dN", _jobName);
        } catch (Exception e) {
            throw new Error("Can not find element: " + _jobName);
        }
        try {
            job.contextClick();
        } catch (Exception e) {
            throw new Error("Error on context click on: " + _jobName + ". " + e.getCause());
        }
        return new JobContextMenu();
    }

    public GroupContextMenu callGroupContextMenu(String _groupName){
        DElement group = null;
        try {
            group = g(mainWindow, "", 1, "dN", _groupName);
        } catch (Exception e) {
            throw new Error("Can not find element: " + _groupName);
        }
        try {
            group.contextClick();
        } catch (Exception e) {
            throw new Error("Error on context click on: " + _groupName + ". " + e.getCause());
        }
        return new GroupContextMenu();
    }
}
