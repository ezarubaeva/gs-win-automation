package window;

import Tools.Elem;
import daima.DElement;
import window.ContextMenu.AllContextMenu;
import window.ContextMenu.GroupContextMenu;
import window.ContextMenu.JobContextMenu;
import window.ContextMenu.ToolsContextMenu;
import window.LeftPane.LeftPaneTree;

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
            newJobButton = g(mainWindow, "New Job Button", 2, "N", "New Job");
        } catch (Exception e) {
            throw new Error("Can not find element New Job button");
        }
        try {
            newGroupButton = g(mainWindow, "New Group Button", 2, "N", "New Group");
        } catch (Exception e) {
            throw new Error("Can not find element New group button");
        }
        try {
            autoRunButton = g(mainWindow, "Auto Run On/Off Button", 2, "N", "AutoRun ");
        } catch (Exception e) {
            throw new Error("can not find element Auto run on/off button");
        }
        try {
            analyzeButton =  g(mainWindow, "Analyze Button", 2, "N", "Analyze");
        } catch (Exception e) {
            throw new Error("Can not find element Analyze button");
        }
        try {
            syncButton = g(mainWindow, "Sync Button", 2, "N", "Sync");
        } catch (Exception e) {
            throw new Error("Can not find element Sync button");
        }
        try {
            moreLink = g(mainWindow, "More Button", 2, "N", "More");
        } catch (Exception e) {
            throw new Error("can not find element More button");
        }

        DElement toolbar = null;
        try {
            toolbar = g(mainWindow, "Main GS toolbar", 3, "a", "48151623");
        } catch (Exception e) {
            throw new Error("Can not find element toolbar");
        }
        try {
            jobToolBar = g(toolbar, "Job ToolBar", 3, "N", "Job");
        } catch (Exception e) {
            throw new Error("can not find element job in toolbar");
        }
        try {
            allToolBar = g(toolbar, "All ToolBar", 3, "N", "All");
        } catch (Exception e) {
            throw new Error("can not find element All in toolbar");
        }
        try {
            viewToolBar = g(toolbar, "View ToolBar", 3, "N", "View");
        } catch (Exception e) {
            throw new Error("can not find element view in toolbar");
        }
        try {
            actionToolBar = g(toolbar, "Action ToolBar", 3, "N", "Action");
        } catch (Exception e) {
            throw new Error("can not find element action in toolbar");
        }
        try {
            toolsToolBar = g(toolbar, "Tools ToolBar", 3, "N", "Tools");
        } catch (Exception e) {
            throw new Error("can not find element tools in toolbar");
        }
        try {
            helpToolBar = g(toolbar, "Help ToolBar", 3, "N", "Help");
        } catch (Exception e) {
            throw new Error("can not find element help in toolbar");
        }
    }

    public DElement getChangeDirections(){
        try {
            changeDirections = g(mainWindow, "Change Directions and other settings", 2, "N", "Change job direction and other settings");
        } catch (Exception e) {
            throw new Error("Can not find element change directions and other settings");
        }
        return changeDirections;
    }

    public DElement getRightSideBrwsDlg(){
        try {
            rightSideBrowseDlg = g(mainWindow, "Right Side Browse Dialog", 2, "N", "Right Side");
        } catch (Exception e) {
            throw new Error("can not find Right side browse dialog");
        }
        return rightSideBrowseDlg;
    }

    public DElement getLeftSideBrwsDlg(){
        try {
            leftSideBrowseDlg = g(mainWindow, "Left Side Browse Dialog", 2, "N", "Left Side");
        } catch (Exception e) {
            throw new Error("Can not find element Left Side browse dialog");
        }
        return leftSideBrowseDlg;
    }


    public DElement getAutoBtn(){
        try {
            autoButton = g(mainWindow, "Auto Options Button", 2, "N", "Auto");
        } catch (Exception e) {
            throw new Error("Can not find element Auto options button");
        }
        return autoButton;
    }

    public DElement getOptionsBtn(){
        try {
            optionsButton = g(mainWindow, "Options Button", 2, "N", "Options");
        } catch (Exception e) {
            throw new Error("Can not find element Options button");
        }
        return optionsButton;
    }


    public DElement getAllJobsTree() {
        try {
            allJobsTree = g(mainWindow, "All Jobs Tree Node", 1, "dN", "All Jobs");
        } catch (Exception e) {
            throw new Error("Can not find element All jobs tree node");
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

    public ToolsContextMenu clickToolsToolBarMenu() throws Exception {
        try {
            toolsToolBar.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ToolsContextMenu();
    }


}
