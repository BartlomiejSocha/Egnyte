package com.share.pages;

import com.share.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(className = "primaryBtn")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='folderLink-topbar-select']")
    private WebElement itemNameCheckBox;

    @FindBy(xpath = "//div[@class='folderLink-buttons-download']")
    private WebElement downloadSelectedButton;

    @FindBy(id = "download-folder")
    private WebElement downloadFolderButton;

    @FindBy(xpath = "//div[@class='folderLink-sort']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='folderLink-viewSwitch']")
    private WebElement folderViewSwitchButton;

    @FindBy(className = "gallery-empty")
    public WebElement emptyGalleryView;

    @FindBy(xpath = "//div[@class='folderLink-buttons-redirection']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement sortByToggle;

    @FindBy(xpath = "//ul[@class='dropdown-menu']")
    private WebElement sortByDropdown;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/div/ul/li[1]/a")
    private WebElement sortByName;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/div/ul/li[2]/a")
    private WebElement sortByDate;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/div/ul/li[3]/a")
    private WebElement sortBySize;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/div/ul/li[5]/a")
    private WebElement sortAscending;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[1]/ul/li[1]/div/div/div/ul/li[6]/a")
    private WebElement sortDescending;

    @FindBy(xpath = "//span[@class='selected-sort-field']")
    private WebElement sortByText;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li(1)")
    private WebElement firstItemOnTheList;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li(2)")
    private WebElement secondItemOnTheList;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li(3)")
    private WebElement thirdItemOnTheList;

    private SeleniumHelper helper;

    private WebDriver driver;

    private Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public HomePage logIn() {
        log.info("Login Process");
        passwordTextBox.sendKeys("eDGziP4L");
        log.info("Password Entered");
        continueButton.click();
        log.info("Logged in");
        return this;
    }

    public HomePage downloadSelectedItems() {
        log.info("Start Downloading Selected Items");
        helper.waitForElementToBeDisplayed(downloadSelectedButton);
        downloadSelectedButton.click();
        return this;
    }

    public HomePage downloadFolder() {
        log.info("Start Downloading Folder");
        helper.waitForElementToBeDisplayed(downloadFolderButton);
        downloadFolderButton.click();
        return this;
    }

    public HomePage selectSortByName() {
        log.info("Select Sort By Name");
        helper.waitForElementToBeDisplayed(sortByToggle);
        sortByToggle.click();
        helper.waitForElementToBeDisplayed(sortByDropdown);
        sortByName.click();
        return this;
    }

    public HomePage selectSortByDate() {
        log.info("Select Sort By Date");
        helper.waitForElementToBeDisplayed(sortByToggle);
        sortByToggle.click();
        helper.waitForElementToBeDisplayed(sortByDate);
        sortByDate.click();
        return this;
    }

    public HomePage selectSortBySize() {
        log.info("Select Sort By Size");
        helper.waitForElementToBeDisplayed(sortByToggle);
        sortByToggle.click();
        helper.waitForElementToBeDisplayed(sortByDropdown);
        sortBySize.click();
        return this;
    }

    public HomePage selectSortAscending() {
        log.info("Select Sort Ascending");
        helper.waitForElementToBeDisplayed(sortByToggle);
        sortByToggle.click();
        helper.waitForElementToBeDisplayed(sortByDropdown);
        sortAscending.click();
        return this;
    }

    public HomePage selectSortDescending() {
        log.info("Select Sort Descending");
        helper.waitForElementToBeDisplayed(sortByToggle);
        sortByToggle.click();
        helper.waitForElementToBeDisplayed(sortByDropdown);
        sortDescending.click();
        return this;
    }

    public String getSortByText() {
        return sortByText.getText();
    }

    public HomePage selectFirstItemOnTheList() {
        log.info("Select First Item On The List");
        firstItemOnTheList.click();
        return this;
    }

    public HomePage selectSecondItemOnTheList() {
        log.info("Select Second Item On The List");
        secondItemOnTheList.click();
        return this;
    }

    public HomePage selectThirdItemOnTheList() {
        log.info("Select Third Item On The List");
        thirdItemOnTheList.click();
        return this;
    }

}
