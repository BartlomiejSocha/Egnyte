package com.share.tests;

import com.aventstack.extentreports.Status;
import com.share.helpers.TestListener;
import com.share.pages.HomePage;
import com.share.pages.ItemEditPages;
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
    public void checkSortByDropdown() throws ConfigurationException, IOException {

        Configuration config = loadProperties();
        test = reports.createTest("Main Page Tests");

        HomePage homePage = new HomePage(driver);
        ItemEditPages itemEditPages = new ItemEditPages(driver);

        driver.get(config.getString("baseURL"));
        homePage.logIn();

        test.log(Status.INFO, "Start Test", getScreenshot());
        homePage.selectSortByDate();
        Assert.assertEquals(homePage.getSortByText(), "DATE");
        test.log(Status.INFO, "Date", getScreenshot());
        homePage.selectSortBySize();
        Assert.assertEquals(homePage.getSortByText(), "SIZE");
        test.log(Status.INFO, "Size", getScreenshot());
        homePage.selectSortByName();
        Assert.assertEquals(homePage.getSortByText(), "NAME");
        test.log(Status.INFO, "Name", getScreenshot());
        homePage.selectSortDescending();
        Assert.assertEquals(itemEditPages.getThirdFileName(), "DataFolder1");
        test.log(Status.INFO, "Descending", getScreenshot());
        homePage.selectSortAscending();
        test.log(Status.INFO, "Ascending", getScreenshot());
        Assert.assertEquals(itemEditPages.getThirdFileName(), "readme.txt");

        test.log(Status.PASS,"Sort By Dropdown Tests PASSED", getScreenshot());
    }
}
