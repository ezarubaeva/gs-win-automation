package window.ContextMenu;

import Tools.Elem;
import daima.DElement;

public class GroupContextMenu extends Elem {
    private DElement analyze;
    private DElement synchronize;
    private DElement analyzeAndSync;
    private DElement clear;
    private DElement pause;
    private DElement delete;
    private DElement rename;
    private DElement exportGroup;
    private DElement exit;

    public GroupContextMenu(){
        try {
            analyze = g(mainWindow, "Group context -> analyze", 1, "da", "Item 901");
        } catch (Exception e) {
            throw new Error("Can not find element Group context-> analyze");
        }
        try {
            synchronize = g(mainWindow, "Group context -> sync", 1, "da", "Item 907");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> sync");
        }
        try {
            analyzeAndSync = g(mainWindow, "Group context -> analyze and sync", 1, "da", "Item 911");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> analyze and sync");
        }
        try {
            clear = g(mainWindow, "Group context -> clear", 1, "da", "Item 906");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> clear");
        }
        try {
            pause = g(mainWindow, "Group context -> pause", 1, "da", "Item 905");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> pause");
        }
        try {
            delete = g(mainWindow, "Group context -> delete", 1, "da", "Item 32505");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> delete");
        }
        try {
            rename = g(mainWindow, "Group context -> rename", 1, "da", "Item 32518");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> rename");
        }
        try {
            exportGroup = g(mainWindow, "Group context -> export group", 1, "da", "Item 32511");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> export group");
        }
        try {
            exit = g(mainWindow, "Group context -> exit", 1, "da", "Item 57665");
        } catch (Exception e) {
            throw new Error("Can not find element Group context -> exit");
        }
    }

    public boolean isElementEnabled(String element){
        DElement res = null;
        switch(element.toUpperCase()){
            case "ANALYZE":
                res = analyze;
                break;
            case "SYNCHRONIZE":
                res = synchronize;
                break;
            case "ANALYZE AND SYNC":
            case "ANALYZEANDSYNC":
                res = analyzeAndSync;
                break;
            case "CLEAR":
                res = clear;
                break;
            case "PAUSE":
                res = pause;
                break;
            case "DELETE":
                res = delete;
                break;
            case "RENAME":
                res = rename;
                break;
            case "EXPORT GROUP":
            case "EXPORTGROUP":
                res = exportGroup;
                break;
            case "EXIT":
                res = exit;
                break;
        }
        boolean bool;
        try {
            bool = res.getIsEnabled();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return bool;
    }
}
