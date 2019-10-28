package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForIdLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //id="disappearing_button"
        //refresh the page to see that button again
        WebElement button = driver.findElement(By.id("disappearing_button"));

        button.click();
        //<p id="result" style="color:green">Now it's gone!</p>
        WebElement result = driver.findElement(By.id("result"));

        //        Now it's gone! <--- text, .getText() will return this text
        System.out.println(result.getText());

        driver.quit();
    }
}
