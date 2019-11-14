package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;

    //   <select id="dropdown">
//      <option value="" disabled="disabled" selected="selected">Please select an option</option>
//      <option value="1">Option 1</option>
//      <option value="2">Option 2</option>
//    </select>
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1() {
        // to work with select dropdowns, we need to use Select class in Selenium
        //step 1. Find dropdown and create a webelement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //ste 2. Create a select object
        //select class requires webelemnt object as a parameter
        Select select = new Select(dropdown);
        //to select any option by visible text:
        // also you can select by value, or index
        //<option value="1">Option 1</option> value is 1, Option 1 is a visible text, in between >Text< (in between angled brackets)
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        //how to verify that option 2 is selected
        //select.getFirstSelectedOption() - to get selected option/this is what is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "Print list of states")
    public void test2() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();//will return available options to select
        //how to print every option, as a text, one by one?
        for (WebElement option : states) {
            System.out.println(option.getText());
        }
    }

    @Test(description = "Select your state and verify that state is selected")
    public void test3() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
//        <option value="MD">Maryland</option>
        //we can use tes, value or index for selection
        select.selectByValue("MD");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Maryland");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
