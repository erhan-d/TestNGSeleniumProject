package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class NewCalendarEventsTests extends TestBase {


    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events'")
    public void test1() {
        //this step is required for every test
        //otherwise you will get nullpointer exception
        //you must create a test at the beginning
        extentTest = extentReports.createTest("Verify that page subtitle is equals to 'All Calendar Events'");

        LoginPage loginPage = new LoginPage(); //login page object

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Activities", "Calendar Events");

        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verified that page subtitle 'All Calendar Events' is displayed");
    }
}
