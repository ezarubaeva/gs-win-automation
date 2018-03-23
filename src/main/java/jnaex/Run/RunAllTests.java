package jnaex.Run;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jnaex.RFWin.*;
import testLogger.TestLogger;
import testLogger.TestSet;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class RunAllTests {
    private static final String iniFilename = "testBlank.ini";

    public static void main(String[] args) throws Exception {
        setParametersJSON();
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        TestLogger.startLogging();

        TestSet inst1 = new TestSet("GoodSync Connect Setup");
        TestLogger.addTestSet(inst1);
        GoodSyncConnect.main(inst1, args);

//        TestSet file_systems = new TestSet("Create FS Accounts");
//        TestLogger.addTestSet(file_systems);
//        CreateFSAccounts.main(file_systems, args);

        TestLogger.stopLogging();
//        TestLogger.writeLogs(); //to keep locally
        TestLogger.writeLogsHTML(); //to send on server
        System.exit(0);
    }

    private static String getValue(JsonObject _o, String _property){
        if (_o.has(_property)){
            return _o.get(_property).getAsString();
        }
        else
        {
            return null;
        }
    }
    private static Vector<String> getValueArray(JsonObject _o, String _property){
        if (_o.has(_property)){
            JsonArray ar = _o.get(_property).getAsJsonArray();
            Vector<String> tempest = new Vector<String>();
            for (JsonElement el : ar){
                tempest.add(el.getAsString());
            }
            return tempest;
        }
        else
        {
            return new Vector<>();
        }
    }



    private static void setParametersJSON() throws Exception{
        File iniF = new File(iniFilename);
        try
        {
            JsonParser parser = new JsonParser();
            JsonObject o = (JsonObject) parser.parse(new FileReader(iniF));

            String s = getValue(o, "reportEmailFromName");
            if (s != null) {
                TestLogger.setReportEmailFromName(s);
            }

            s = getValue(o, "reportEmailFromPassword");
            if (s != null) {
                TestLogger.setReportEmailFromPassword(s);
            }

            s = getValue(o, "reportEmailSMTPServer");
            if (s != null) {
                TestLogger.setReportEmailSMTPServer(s);
            }

            s = getValue(o, "reportEmailSMTPPort");
            if (s != null) {
                TestLogger.setReportEmailSMTPPort(s);
            }

            Vector<String> sa = getValueArray(o, "reportEmailList");
            if (!(sa.isEmpty())) {
                TestLogger.setEmailList(sa);
            }

        } catch (Exception e) {
            Proc.logW("JSON parsing exception: " + e.getMessage());
        }
    }

}
