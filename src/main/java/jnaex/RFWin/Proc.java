package jnaex.RFWin;


import com.sun.jna.platform.win32.WinDef;
import daima.DElement;
import daima.KeyboardHandler;
import daima.MouseHandler;
import java.util.Vector;


/**
 * Process handling jueton
 */
public class Proc {
    public static DElement gL(DElement _parent, String _descr, int _attempts, String _XattrList, String..._Xattrs) throws Exception{
        DElement res;
        log("Looking for " + _descr);
        try{
            res = DElement.gimMeP(_parent,_descr,_attempts,_XattrList,_Xattrs);
        } catch (Exception e) {
            log(_descr + " finding failure");
            throw e;
        }
        return res;
    }
    public static Vector<DElement> gVL(DElement _parent, String _descr, int _attempts, String _XattrList, String..._Xattrs) throws Exception{
        Vector<DElement> res= new Vector<>();
        log("Looking for vector: " + _descr);
        try{
            res = DElement.gimMePV(_parent,_descr,_attempts,_XattrList,_Xattrs);
        } catch (Exception e) {
            log(_descr + " finding failure");
        }
        return res;
    }
    /**
     * Log everything to file
     */
    private static boolean Log = true;
    /**
     * Log everything to console
     */
    private static boolean LogConsole = true;


    /**
     * Used in editor tests - specifies whether RF should be installed/uninstalled before/after tests or not
     * If preinstallRF ==
     */
    public static Boolean preinstallRF = false;

    /**
     * Log prefix - redefine in procedures
     */
    public static String lgP = "Default log prefix";

    /**
     * Global Log prefix (redefine in classes)
     */
    private static String logGPr = "Global log prefix";
    public static String logSeparator = ": ";
    private static String logDeprecatedMarker = "[deprecated]";
    private static String makeLogString(String s){
        String res = "";
        if (!(logGPr.isEmpty())){
            res = logGPr + logSeparator;
        }
        if (!(lgP.isEmpty())){
            res += lgP + logSeparator;
        }
        res += s;
        return res;
    }
    public static void log(String s){ //normal log
        wrLog(makeLogString(s));
    }
    public static void log(String s1, String s2) {
        wrLog(s1 + logSeparator + makeLogString(s2));
    }
    public static void logE(String s){ //error log
        wrLog("ERROR" + logSeparator + makeLogString(s));
    }
    public static void logE(String s1, String s2) {
        wrLog("ERROR" + logSeparator + s1 + logSeparator + makeLogString(s2));
    }
    public static void logW(String s){ //warning log
        wrLog("WARNING" + logSeparator + makeLogString(s));
    }
    public static void logW(String s1, String s2){
        wrLog("WARNING" + logSeparator + s1 + logSeparator + makeLogString(s2));
    }
    private static void wrLog(String s){ // writes log
        if (Log){
            buf.add(s);
        }
        if (LogConsole){
            System.out.println(s);
        }
    }

    /**
     * Set global log prefix
     * @param s log prefix
     */
    public static void setGLP(String s){
        logGPr = s;
    }

    /**
     * Clear global log prefix
     */
    public static void clearGLP(){
        logGPr = "";
    }

    private static Vector <String> buf = new Vector<String>();

    /**
     * Clear log prefix string
     */
    private static void cl(){
        lgP = "";
    }
    public static void sleepy(double s){  //in seconds
        lgP = "Sleeping";
        double multiplierFastMachine = 0.9;
        try {
            log("Waiting for " + s * multiplierFastMachine + " seconds.");
            Thread.sleep(Math.round(s * multiplierFastMachine * 1000));                 //milliseconds
        } catch(InterruptedException ex) {
            logE("Interrupted exception appeared");
            Thread.currentThread().interrupt();
        }
        cl();
    }


    public static void setBuf(Vector<String> _buff){
        buf = _buff;
    }
    public static Vector<String> getBuf(){
        Proc.clearGLP();
        return buf;
    }

    public static void doubleClick(DElement _dElement) throws Exception{
        log("Double-clicking on " + _dElement.getNativeWindowHandleHEXStr());
        _dElement.doubleClick();
    }
    public static void contextClick(DElement _dElement) throws Exception{
        log("Context-clicking on " + _dElement.getNativeWindowHandleHEXStr());
        _dElement.contextClick();
    }
    public static void offsetClick(DElement _dElement, int _offsetX, int _offsetY) throws Exception{
        log("Clicking with offset " + _offsetX + ":" + _offsetY + " on " + _dElement.getNativeWindowHandleHEXStr());

        WinDef.RECT rc =_dElement.element.getBoundingRectangle();
        int xP = rc.left + (rc.right - rc.left) / 2 + _offsetX;
        int yP = rc.top + (rc.bottom - rc.top) / 2 + _offsetY;
        MouseHandler.moveMouseTo(xP,yP);
        Thread.sleep(250);
        MouseHandler.clickLeft();

    }
    public static void offsetClick(DElement _dElement, int _offsetX) throws Exception{
        offsetClick(_dElement,_offsetX,0);
    }
    public static void offsetClick(DElement _dElement, int _offsetX, int _offsetY, String _keys) throws Exception{
        log("Clicking with offset " + _offsetX + ":" + _offsetY + " on " + _dElement.getNativeWindowHandleHEXStr());
        log("After that entering key sequence: " + _keys);
        offsetClick(_dElement,_offsetX,_offsetY);
        KeyboardHandler.sendKeysHere(_keys);
    }
    public static void offsetClick(DElement _dElement, int _offsetX, String _keys) throws Exception{
        offsetClick(_dElement,_offsetX,0,_keys);
    }

    protected Proc()    {
    }
}
