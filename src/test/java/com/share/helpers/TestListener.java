package com.share.helpers;

import com.aventstack.extentreports.Status;
import com.share.exceptions.NoSuchDriverException;
import com.share.utils.DriverFactory;
import com.share.utils.DriverType;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.share.utils.PropertyLoader.loadProperties;

public class TestListener implements ITestListener {

    Logger log = Logger.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.debug("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.debug("On test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Configuration config = loadProperties();
            log.debug("On test failure");
            com.share.helpers.SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.valueOf(config.getString("browser"))));
        } catch (IOException | ConfigurationException | NoSuchDriverException e) {
            log.error(e.getStackTrace());    }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("On test failure but within percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.debug("On test failure without timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        log.debug("On start");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.debug("On finish");
    }
}
