package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestsForLinkText {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
//      <a href="/autocomplete">Autocomplete</a>
//        Autocomplete - it's the text that you see in the link
//        place where it will navigate you specified in href
//        it works only if tag name is <a>
//        if you want to use linkText or partialLinkText locator strategy
//        element must start with <a>
//        this is how we specify linkd in HTML
        driver.findElement(By.linkText("Autocomplete")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
