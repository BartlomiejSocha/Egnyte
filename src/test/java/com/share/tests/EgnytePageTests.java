package com.share.tests;

import com.aventstack.extentreports.Status;
import com.share.helpers.TestListener;
import com.share.pages.HomePage;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
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
        test.log(Status.INFO, "Descending", getScreenshot());
        Assert.assertEquals(homePage.getThirdFileName(), "DataFolder1");
        homePage.selectSortAscending();
        test.log(Status.INFO, "Ascending", getScreenshot());
        Assert.assertEquals(homePage.getThirdFileName(), "Wrong expected readme.txt");
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
        test.log(Status.INFO, "Third File Checked", getScreenshot());
    }

    @Test
    public void checkIfFilesOpenTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Files Open Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start checkIfFilesOpenTest", getScreenshot());
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        homePage.openThirdFile();
        Assert.assertEquals(homePage.getHeaderInfoText(), "readme.txt");
        homePage.clickDownloadButton()
                .clickGoBackButton()
                .openSecondFile()
                .openFirstFile();
        Assert.assertNotEquals(homePage.getFirstFileName(),"blablabla");
        test.log(Status.INFO, "Open Multiple Files", getScreenshot());
    }

    @Test
    public void switchToEmptyViewTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Files Open Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start switchToEmptyViewTest", getScreenshot());
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        homePage.switchFolderViewButton();
        test.log(Status.INFO, "Switch Folder To Empty View", getScreenshot());
        Assert.assertEquals(homePage.getEmptyGalleryViewText(), "There are no images to show in this folder");
        homePage.clickLogInButton()
                .clickLogInContinueButton();
        test.log(Status.INFO, "Go To Log In Page", getScreenshot());
        Assert.assertEquals(homePage.getErrorMessageContainerText(),"Enter your e-mail or username");
        homePage.logInUsernameBox.sendKeys("testUsername");
        homePage.clickLogInContinueButton();
        Assert.assertEquals(homePage.getErrorMessageContainerText(),"No account found");
    }

    @Test
    public void previewOfFilesTest() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Files Open Tests");
        HomePage homePage = new HomePage(driver);
        driver.get(config.getString("baseURL"));

        test.log(Status.INFO, "Start previewOfFilesTest", getScreenshot());
        homePage.logIn();
        test.log(Status.INFO, "Logged In", getScreenshot());
        homePage.openFirstFile()
                .openSecondFile()
                .openThirdFile();
        test.log(Status.INFO, "empty.xxx File Opened", getScreenshot());
        Assert.assertEquals(homePage.getErrorPreviewMessageText(),"This file type cannot be previewed");
        homePage.clickNextArrow();
        test.log(Status.INFO, "Next File",getScreenshot());
        homePage.clickNextArrow()
                .clickNextArrow()
                .clickPreviousArrow();
        test.log(Status.INFO, "Next File",getScreenshot());
    }

}


