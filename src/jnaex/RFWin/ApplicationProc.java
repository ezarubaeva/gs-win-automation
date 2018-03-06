package jnaex.RFWin;

import java.util.List;

import daima.DElement;

public class ApplicationProc extends Proc{
    private static String logString = "Application Proc";
    private static String logPrefixBlock = "AppProc" + Proc.logSeparator;
    public static void log(String s){ //normal log
        Proc.log(logPrefixBlock + logString + Proc.logSeparator + s);
    }
    public static void logE(String s){ //error log
        Proc.logE(logPrefixBlock + logString + Proc.logSeparator + s);
    }
    public static void logW(String s){
        Proc.logW(logPrefixBlock + logString + Proc.logSeparator + s);
    }

    /*
        script string handle path moves handler to a series of window jumps to element deep inside application window
        Usage: {subwindow name}[counter of the same subwindows]
        if '~' specified, then it is searched by ClassName, else - by Name
     */

    /**
     * cut the string before specific char (cuts char too)
     * # String s = "abra kadabra";
     * # String res = cutBeforeChar(s,"r");
     * >> res: "a kadabra";
     * @param _string string to process
     * @param _char string (represents 1 char) to look for
     * @return cut string
     */
    private static String cutBeforeChar(String _string, String _char){
        int st = _string.indexOf(_char) + 1;
        int end = _string.length();
        if (end - st > 0){
            char[] buf = new char[end - st];
            _string.getChars(st,end,buf,0);
            return new String(buf);
        }
        else{
            return "";
        }

    }
    public static DElement calculateParent(DElement _dElement,String _lookingScript) throws Exception{
        DElement res = null;
        String s = _lookingScript;
        String nm;
        int ind;
        Boolean cntC; // continue calculation
        int i = 0;
        do{
            cntC = false;
            if ((s.indexOf("{") == 0)||(s.indexOf("~") == 0)){
                String symStart = "{";
                String symStop = "}";
                if (s.indexOf("~") == 0){
                    symStart = "~";
                    symStop = "~";
                }
                cntC = true;

                int st;
                if (symStart.equals("~")){
                    st = 0;
                    s = cutBeforeChar(s,symStop);
                }
                else{
                    st = s.indexOf(symStart) + 1;
                }
                int end = s.indexOf(symStop);
                if (end - st > 0){
                    char[] buf = new char[end - st];
                    s.getChars(st,end,buf,0);
                    nm = new String(buf);
                }
                else
                {
                    nm = "";
                }
                s = cutBeforeChar(s,symStop);
                if (s.indexOf("[") == 0){
                    int st1 = s.indexOf("[") + 1;
                    int end1 = s.indexOf("]");
                    if (end1 - st1 > 0){
                        char[] buf1 = new char[end1-st1];
                        s.getChars(st1,end1,buf1,0);
                        try{
                            ind = Integer.parseInt(new String(buf1));
                        }
                        catch (Exception e){
                            throw new Exception(e.getMessage());
                        }

                        if (symStart.equals("~")){
                            if (ind > 1){
                                List<DElement> jack;
                                if (i > 0){
                                    jack = gVL(res,nm,1,"c",nm);
                                }
                                else
                                {
                                    jack = gVL(_dElement,nm,1,"c",nm);
                                }

                                res = jack.get(ind - 1);
                            }
                            else
                            {
                                if (i > 0){
                                    res = gL(res,nm,1,"c",nm);
                                }
                                else{
                                    res = gL(_dElement,nm,1,"c",nm);
                                }

                            }
                        }
                        else
                        {
                            if (ind > 1){
                                List<DElement> jack;
                                if (i > 0){
                                    jack = gVL(res,nm,1,"n",nm);
                                }
                                else
                                {
                                    jack = gVL(_dElement,nm,1,"n",nm);
                                }

                                res = jack.get(ind - 1);
                            }
                            else
                            {
                                if (i > 0){
                                    res = gL(res,nm,1,"n",nm);
                                }
                                else{
                                    res = gL(_dElement,nm,1,"n",nm);
                                }

                            }
                        }
                        s = cutBeforeChar(s,"]");
                        i++;
                    }

                }
                else{
                    throw new Exception("Parsing error. The rest is: " + s);
                }
            }
        }while ((cntC)&&(!(s.isEmpty())));
        return res;
    }


}
