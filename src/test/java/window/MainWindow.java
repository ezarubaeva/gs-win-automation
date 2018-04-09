package window;

import Tools.Elem;
import daima.DElement;
import window.ContextMenu.AllContextMenu;
import window.ContextMenu.GroupContextMenu;
import window.ContextMenu.JobContextMenu;
import window.ContextMenu.ToolsContextMenu;

public class MainWindow extends Elem {

    private DElement newJobButton;
    private DElement newGroupButton;
    private DElement autoRunButton;
    private DElement analyzeButton;
    private DElement syncButton;
    private DElement optionsButton;
    private DElement autoButton;
    private DElement moreLink;
    private DElement leftSideBrowseDlg;
    private DElement rightSideBrowseDlg;
    private DElement changeDirections;
    private DElement allJobsTree;
    private DElement jobToolBar;
    private DElement allToolBar;
    private DElement viewToolBar;
    private DElement actionToolBar;
    private DElement toolsToolBar;
    private DElement helpToolBar;

    public MainWindow(){
        super();
        try {
            mainWindow.setForeground ();
            // some elements are not here cuz they depend on left pane\tree selection
            newJobButton = g(mainWindow, "New Job Button", 2, "N", "New Job");
            newGroupButton = g(mainWindow, "New Group Button", 2, "N", "New Group");
            autoRunButton = g(mainWindow, "Auto Run On/Off Button", 2, "N", "AutoRun ");
            analyzeButton =  g(mainWindow, "Analyze Button", 2, "N", "Analyze");
            syncButton = g(mainWindow, "Sync Button", 2, "N", "Sync");
            moreLink = g(mainWindow, "More Button", 2, "N", "More");
            DElement toolbar = g(mainWindow, "", 1, "a", "48151623");
            jobToolBar = g(toolbar, "", 1, "N", "Job");
            allToolBar = g(toolbar, "", 1, "N", "All");
            viewToolBar = g(toolbar, "", 1, "N", "View");
            actionToolBar = g(toolbar, "", 1, "N", "Action");
            toolsToolBar = g(toolbar, "", 1, "N", "Tools");
            helpToolBar = g(toolbar, "", 1, "N", "Help");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public DElement getChangeDirections(){
        try {
            changeDirections = g(mainWindow, "Change Directions and other settings", 2, "N", "Change job direction and other settings");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return changeDirections;
    }

    public DElement getRightSideBrwsDlg(){
        try {
            rightSideBrowseDlg = g(mainWindow, "Right Side Browse Dialog", 2, "N", "Right Side");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return rightSideBrowseDlg;
    }

    public DElement getLeftSideBrwsDlg(){
        try {
            leftSideBrowseDlg = g(mainWindow, "Left Side Browse Dialog", 2, "N", "Left Side");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return leftSideBrowseDlg;
    }


    public DElement getAutoBtn(){
        try {
            autoButton = g(mainWindow, "Auto Options Button", 2, "N", "Auto");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return autoButton;
    }

    public DElement getOptionsBtn(){
        try {
            optionsButton = g(mainWindow, "Options Button", 2, "N", "Options");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return optionsButton;
    }


    public DElement getAllJobsTree() {
        try {
            allJobsTree = g(mainWindow, "All Jobs Tree Node", 1, "dN", "All Jobs");
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return allJobsTree;
    }

    public NewGoodSyncJobWindow clickNewJobButton() {
        try {
            newJobButton.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new NewGoodSyncJobWindow();
    }

    public NewGroupWindow clickNewGroupBtn(){
        try {
            newGroupButton.clickMM();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return new NewGroupWindow();
    }

    public JobContextMenu clickJobToolBarMenuForJob(){
        try {
            jobToolBar.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JobContextMenu();
    }

    public GroupContextMenu clickJobToolBarMenuForGroup(){
        try {
            jobToolBar.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GroupContextMenu();
    }

    public AllContextMenu clickAllToolBarMenu(){
        try {
            allToolBar.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AllContextMenu();
    }

    public ToolsContextMenu clickToolsToolBarMenu(){
        try {
            toolsToolBar.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ToolsContextMenu();
    }


}
