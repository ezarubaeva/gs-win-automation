package jnaex.Run;

import Tools.BrowseDialog;
import Tools.Elem;
import daima.DElement;

public class CreateFSAccounts extends Elem {
    public static void main(String[] args) throws Exception {
        DElement editorW = g(null,"GoodSync",1,"N","GoodSync - All Jobs");
        editorW.setForeground();

        String[] fileSystems = {
                "myComp",
                "gsConnect",
                "SMB",
                "MTP",
                "FTP",
                "SFTP",
                "WebDAV",
                "GDriveV3",
                "TeamDrive",
                "GDocs",
                "AmazonS3",
                "ACD",
                "WinAzure",
                "AzureFilesAPI",
                "dropbox",
                "onedrivePersonal",
                "onedriveBusinessRoot",
                "onedriveBusinessPersonal",
                "sharepoint",
                "boxcom",
                "backblaze",
                "onefile"
        };

        for (int i = 0; i < fileSystems.length; i++) {
            createAccount(fileSystems [i]);
        }

        sleep(1);
        System.exit(0);
    }

    public static void createAccount(String fileSystem) throws Exception {
        DElement editorW = g(null,"GoodSync",1,"N","GoodSync - All Jobs");
        editorW.setForeground();
        // create new job
        createJob (fileSystem);

        BrowseDialog bd = new BrowseDialog ();
        bd.selectLeftFolder("myComp", "test-dir");
        bd.selectLeftFolder(fileSystem, "test-dir");
        sleep(1);
        System.exit(0);
    }
}
