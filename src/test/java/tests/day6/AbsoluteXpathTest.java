package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //click on login without entering username and password
        //to invoke warning message
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //for windows , just use control instead of command
        //command + c - copy, command + v - paste, command + x  - cut, command + z - step back (changes), command + z + shift - step forward
        //PLEASE USE ONLY CHROME BROWSER
        System.out.println(warningMessage.getText()); // to read the text of warning message
        //to end the test execution
        driver.quit();
    }
}
