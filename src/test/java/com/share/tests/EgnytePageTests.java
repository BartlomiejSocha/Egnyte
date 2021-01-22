package com.share.tests;

import com.aventstack.extentreports.Status;
import com.share.helpers.TestListener;
import com.share.pages.HomePage;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.share.utils.PropertyLoader.loadProperties;

@Listeners(TestListener.class)
public class EgnytePageTests extends BaseSeleniumTest {

    @Test
    public void checkSortByDropdownTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Main Page Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start checkSortByDropdownTest");
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        homePage.selectSortByDate();
        Assert.assertEquals(homePage.getSortByTitleText(), "DATE");
        test.log(Status.INFO, "Date", getScreenshot());
        homePage.selectSortBySize();
        Assert.assertEquals(homePage.getSortByTitleText(), "SIZE");
        test.log(Status.INFO, "Size", getScreenshot());
        homePage.selectSortByName();
        Assert.assertEquals(homePage.getSortByTitleText(), "NAME");
        test.log(Status.INFO, "Name", getScreenshot());
        homePage.selectSortDescending();
        Assert.assertEquals(homePage.getThirdFileName(), "DataFolder1");
        test.log(Status.INFO, "Descending", getScreenshot());
        homePage.selectSortAscending();
        test.log(Status.INFO, "Ascending", getScreenshot());
        Assert.assertEquals(homePage.getThirdFileName(), "readme.txt");

        test.log(Status.PASS,"Sort By Dropdown Tests PASSED", getScreenshot());
    }

    @Test
    public void checkDownloadButtonsTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Download Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start checkDownloadButtonsTest");
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        Assert.assertEquals(homePage.getDownloadFolderText(), "Download Folder");
        test.log(Status.INFO, "Download Folder Text", getScreenshot());
        homePage.selectFirstItemOnTheList();
        Assert.assertEquals(homePage.getDownloadSelectedItems(), "Download Selected");
        test.log(Status.INFO, "Download Selected Text", getScreenshot());

        test.log(Status.PASS,"checkDownloadButtonsTest PASSED");
    }

    @Test
    public void checkFilesTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Files Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start checkFilesTest", getScreenshot());
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        Assert.assertEquals(homePage.getFirstFileName(), "DataFolder1");
        test.log(Status.INFO, "First File Checked");
        Assert.assertEquals(homePage.getSecondFileName(), "folder1");
        test.log(Status.INFO, "Second File Checked");
        Assert.assertEquals(homePage.getThirdFileName(), "dsadas.txt");
        test.log(Status.FAIL, "Third File Checked");

        test.log(Status.PASS,"checkFilesTest PASSED", getScreenshot());
    }

    @Test
    public void checkIfFilesOpenTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Files Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start checkFilesTest", getScreenshot());
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        homePage.openThirdFile();
        Assert.assertEquals(homePage.getHeaderInfoText(), "readme.txt");
        homePage.clickDownloadButton()
                .clickGoBackButton()
                .openSecondFile()
                .openFirstFile();
        Assert.assertEquals(homePage.getFirstFileName(), "folder3");
        test.log(Status.INFO, "Open Multiple Files", getScreenshot());

        test.log(Status.PASS,"checkIfFilesOpenTest PASSED", getScreenshot());
    }

}


