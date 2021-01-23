package com.share.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.share.exceptions.NoSuchDriverException;
import com.share.helpers.SeleniumHelper;
import com.share.utils.DriverFactory;
import com.share.utils.DriverType;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalTime;

import static com.share.utils.PropertyLoader.loadProperties;

public class BaseSeleniumTest {

    protected WebDriver driver;
    public static ExtentReports reports = new ExtentReports();
    public static ExtentSparkReporter sparkReporter;
    public ExtentTest test;

    @BeforeSuite
    public void setUpReporter() {
        sparkReporter = new ExtentSparkReporter("src//test//resources//reports//testExtentReport" + LocalTime.now().getNano() + ".html");
        sparkReporter.config().setTheme(Theme.DARK);
        reports.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void setUp() throws NoSuchDriverException, ConfigurationException {
        Configuration config = loadProperties();
        System.out.println("Before method");
        driver = DriverFactory.getDriver(DriverType.valueOf(config.getString("browser")));
    }
    @AfterMethod
    public void AfterMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName()
                                    + " Test case FAILED due to below issues:",
                            ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(
                    Status.PASS,
                    MarkupHelper.createLabel(result.getName()
                            + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(
                    Status.SKIP,
                    MarkupHelper.createLabel(result.getName()
                            + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("After method");
        driver.quit();
        DriverFactory.driverInstance.remove();
    }

    @AfterSuite
    public void tearDownReporter() {
        System.out.println("tear down reporter");
        reports.flush();
    }

    protected Media getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();
    }

}
