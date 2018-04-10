package Helpers;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class WinRegistry {

    public static void setValue_HKCU_Software_SiberSys_GoodSync_DWORD(String _key, int _value){
        try {
            Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER,
                    "Software\\Siber Systems\\GoodSync", _key, _value);
        } catch (Exception ex) {
            throw new Error(" Can not set REG_DWORD for " + _key + ", " + _value + " : " + ex.getCause());
        }
    }

    public static void setValue_HKCU_Software_SiberSys_GoodSync_REGSZ(String _key, String _value){
        try {
            Advapi32Util.registrySetStringValue(WinReg.HKEY_CURRENT_USER,
                    "Software\\Siber Systems\\GoodSync", _key, _value);
        } catch (Exception ex) {
            throw new Error(" Can not set REG_SZ for " + _key + ", " + _value + " : " + ex.getCause());
        }
    }

    public static void deleteKey_HKCU_Software_SiberSys_GoodSync(String _key){
        try {
            Advapi32Util.registryDeleteKey(WinReg.HKEY_CURRENT_USER, "Software\\Siber Systems\\GoodSync", _key);
        } catch (Exception ex) {
            throw new Error("Can not delete key " + _key + " : " + ex.getCause());
        }
    }

    public static void createKey_HKCU_Software_SiberSys_GoodSync(String _key){
        try {
            Advapi32Util.registryDeleteKey(WinReg.HKEY_CURRENT_USER, "Software\\Siber Systems\\GoodSync", _key);
        } catch (Exception ex){
            throw new Error("Can not create key: " + _key + " : " + ex.getCause());
        }
    }

    public static void deleteValue_HKCU_Software_SiberSys_GoodSync(String _key, String _value){
        try {
            Advapi32Util.registryDeleteValue(WinReg.HKEY_CURRENT_USER,
                    "Software\\Siber Systems\\GoodSync\\" + _key, _value);
        } catch (Exception ex){
            throw new Error("Can not delete value: " + _value + " " + ex.getCause());
        }
    }

    public static String read_REGSZ_value_HKCU_Software_SiberSys_GoodSync(String _key){
        try {
            return Advapi32Util.registryGetStringValue(WinReg.HKEY_CURRENT_USER, "Software\\Siber Systems\\GoodSync", _key);
        } catch (Exception ex){
            throw new Error("Can not read value from key: " + _key + " : " + ex.getCause());
        }
    }

    public static int read_DWORD_value_HKCU_Software_SiberSys_GoodSync(String _key){
        try {
            return Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Siber Systems\\GoodSync", _key);
        } catch (Exception ex){
            throw new Error("Can not read value from key: " + _key + " : " + ex.getCause());
        }
    }


}
