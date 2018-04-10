package Helpers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {
    public static void copyFile(String source, String destination) {
        try {
            FileUtils.copyFile(new File(source),
                    new File(destination));
        } catch (Exception e) {
            throw new Error("Error on copy file: " + source + " to " + destination + e.getMessage());
        }
    }

    public static void deleteFile(String filePath){
        try {
            Files.delete(Paths.get(filePath));
        } catch (Exception e) {
            throw new Error("Error on deleting file " + filePath + " : " + e.getMessage());
        }
    }

    public static void deleteAllInAppData(){
        String appdataPath = System.getenv("APPDATA");
        try {
            FileUtils.cleanDirectory(new File(appdataPath + "\\GoodSync"));
        } catch (Exception e) {
            throw new Error("Error on cleaning directory %appdata% /GoodSync : " + e.getMessage());
        }
    }

    public static void copyFileToAppData(String toAppDataFolder, String fileName, String source){
        String appdataPath = System.getenv("APPDATA");
        try {
            FileUtils.copyFile(new File(source), new File(appdataPath + "\\GoodSync\\" + toAppDataFolder + "\\" + fileName));
        } catch (Exception e) {
            throw new Error("Error on copy file to AppData: " + source + " : " + e.getMessage());
        }
    }

    public static void copyFileToAppData(String fileName, String source){
        String appdataPath = System.getenv("APPDATA");
        try {
            FileUtils.copyFile(new File(source), new File(appdataPath + "\\GoodSync\\"  + fileName));
        } catch (Exception e) {
            throw new Error("Error on copy file to AppData: " + source + " : " + e.getMessage());
        }

    }

    public static void copyFileFromProjectDirectory(String source, String destination){
        String projectDirectory = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(new File(projectDirectory + "\\" + source),
                    new File(destination) );
        } catch (Exception e) {
            throw new Error("Error on copy file from project dir : " + e.getMessage());
        }

    }

    public static void copyFileFromProjectDirToAppData(String source, String destinationAppData){
        String projectDirectory = System.getProperty("user.dir");
        String appdataPath = System.getenv("APPDATA");
        try {
            FileUtils.copyFile(new File(projectDirectory + "\\" + source),
                    new File(appdataPath + "\\GoodSync\\" + destinationAppData) );
        } catch (Exception e) {
            throw new Error("Error on copy file from project dir to destination folder: " + e.getMessage());
        }
    }
}
