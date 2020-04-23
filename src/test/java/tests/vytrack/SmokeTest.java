package tests.vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;


public class SmokeTest extends TestBase {

    @Test(dataProvider = "navigationInfo",timeOut = 10000)

    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle) {
        extentTest = extentReports.createTest("Verify that page subtitle is equals to " + pageSubTitle);

        LoginPage loginPage = new LoginPage();

        loginPage.login("storemanager85", "UserUser123");

        loginPage.navigateTo(moduleName, subModuleName);

        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.waitForPageSubTitle(pageSubTitle);

        Assert.assertEquals(loginPage.getPageSubTitle(), pageSubTitle);

        extentTest.pass("Verified that page subtitle '" + pageSubTitle + "' is displayed");

    }



    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo() {
        return new Object[][]{
                {"Dashboards", "Dashboard", "Dashboard"},
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards"},
                {"Fleet", "Vehicles", "All Cars"},
                {"Customers", "Accounts", "All Accounts"},
                {"Activities", "Calls", "All Calls"},
                {"Activities", "Calendar Events", "All Calendar Events"},
                {"Sales", "Opportunities", "Open Opportunities"}
        };
    }
}
