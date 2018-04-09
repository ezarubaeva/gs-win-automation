package WebTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Tools.Elem.sleep;
import static jnaex.RFWin.Proc.log;

public class MediatorPage {
    public static void gsUserLogin (WebDriver _webDriver, String login, String password) {
        try {
            _webDriver.navigate().to("https://www.goodsync.com/gs-connect/user-login");
            WebElement element = _webDriver.findElement(By.name("email"));
            element.sendKeys(login);
            element = _webDriver.findElement(By.name("password"));
            element.sendKeys(password);
            //element.sendKeys(new CharSequence[]{Keys.ENTER});
            //click submit:
            element = _webDriver.findElement (By.xpath ("//input[@name='button']"));
            element.click();
        } catch (Exception e) {
            log("User login failed: " + e.getMessage());
            throw new java.lang.Error ("User login failed: " + login + " / " +  password );
        }
    }

    public static void deleteGSUser (WebDriver _webDriver, String login, String password) {
        try {
            gsUserLogin (_webDriver, login, password);
            sleep (1);
            WebElement element = _webDriver.findElement(By.linkText ( "Delete User"));
            element.click();
        } catch (Exception e) {
            log("User deletion failed: " + e.getMessage());
            throw e;
        }
    }
}
