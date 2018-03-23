package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Tools.Elem.sleep;
import static jnaex.RFWin.Proc.log;

public class WebTools {
    public static void gsUserLogin (WebDriver _webDriver, String login, String password) {
        try {
            _webDriver.navigate().to("https://www.goodsync.com/gs-connect/user-login");
            WebElement element = _webDriver.findElement(By.name("email"));
            element.sendKeys(login);
            element = _webDriver.findElement(By.name("password"));
            element.sendKeys(password);
            //element.sendKeys(new CharSequence[]{Keys.ENTER});
            //click submit:
            element = _webDriver.findElement (By.name ("button"));
            element.click();
        } catch (Exception e) {
            log("Procedure failed: " + e.getMessage());
            throw e;
        }
    }

    public static void deleteGSUser (WebDriver _webDriver, String login, String password) {
        try {
            gsUserLogin (_webDriver, login, password);
            sleep (1);
            WebElement element = _webDriver.findElement(By.linkText ( "Delete User"));
            element.click();
        } catch (Exception e) {
            log("Procedure failed: " + e.getMessage());
            throw e;
        }
    }
}
