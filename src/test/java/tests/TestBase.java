package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigurationReader;
import utils.Driver;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {
// * ExtentReports itself does not build any reports, but allows reporters to access information, which in
// * turn build the said reports. An example of building an HTML report and adding information to ExtentX:
// * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
// * ExtentXReporter extentx = new ExtentXReporter("localhost");

    protected ExtentReports extentReports;
//    The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
    protected ExtentHtmlReporter extentHtmlReporter;
//    Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){
        //location of report
        //it's gonna be next to target folder, test-output folder
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
        //system information
        extentReports.setSystemInfo("Environment", "QA1");
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }
    //please comeback at 12:17

    @AfterTest
    public void afterTest(){
//         Writes test information from the started reporters to their output view
        extentReports.flush();
    }

    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }


}
