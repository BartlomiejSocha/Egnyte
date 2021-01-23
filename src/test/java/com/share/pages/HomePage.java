package com.share.pages;

import com.share.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(className = "primaryBtn")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='folderLink-topbar-select']")
    private WebElement itemNameCheckBox;

    @FindBy(xpath = "//div[@class='folderLink-buttons']//button[3]")
    private WebElement downloadSelectedButton;

    @FindBy(xpath = "//div[@class='folderLink-buttons']//button[4]")
    private WebElement downloadFolderButton;

    @FindBy(xpath = "//div[@class='folderLink-sort']")
    private WebElement sortDropdown;

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

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[1]//div//div")
    private WebElement firstItemOnTheList;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[2]//div//div")
    private WebElement secondItemOnTheList;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[3]//div//div")
    private WebElement thirdItemOnTheList;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[1]//div//div//div[4]//span//span[2]")
    private WebElement firstItemOnTheListText;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[2]//div//div//div[4]//span//span[2]")
    private WebElement secondItemOnTheListText;

    @FindBy(xpath = "//div[@id='folder-items-wrapper']//ul//li[3]//div//div//div[4]//span//span[2]")
    private WebElement thirdItemOnTheListText;

    @FindBy(xpath = "//div[@class='info']")
    private WebElement headerInfoText;

    @FindBy(xpath = "//li[@class='download-wrapper']" )
    private WebElement downloadButton;

    @FindBy(xpath = "//div[@class='header']//i")
    private WebElement goBackButton;

    @FindBy(xpath = "//span[@class='gallery-empty-label']")
    private WebElement emptyGalleryViewText;

    @FindBy(xpath = "//ul[@class='folderLink-topbar-actions']//li[2]//button[2]")
    private WebElement folderViewButton;

    @FindBy(xpath = "//div[@class='folderLink-buttons']//button[2]")
    private WebElement logInButton;

    @FindBy(xpath = "//form[@id='usernameForm']//button")
    private WebElement logInContinueButton;

    @FindBy(xpath = "//div[@class='error-msg-container']//span")
    private WebElement errorMessageContainerText;

    @FindBy(id = "loginUsername")
    public WebElement logInUsernameBox;

    @FindBy(className = "preview-error-component__message")
    private WebElement errorPreviewMessageText;

    @FindBy(xpath = "//div[@class='arrows-inner']//a[1]")
    private WebElement previousArrow;

    @FindBy(xpath = "//div[@class='arrows-inner']//a[2]")
    private WebElement nextArrow;

    private SeleniumHelper helper;
    private WebDriver driver;
    private Actions action;
    private Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public HomePage logIn() {
        log.info("Login Process");
        passwordTextBox.sendKeys("eDGziP4L");
        log.info("Password Entered");
        continueButton.click();
        log.info("Logged in");
        return this;
    }

    public String getDownloadSelectedItems() {
        log.info("Get Selected Files");
        helper.waitForElementToBeDisplayed(downloadSelectedButton);
        return downloadSelectedButton.getText();
    }

    public String getDownloadFolderText() {
        log.info("Get All Files");
        helper.waitForElementToBeDisplayed(downloadFolderButton);
        return downloadFolderButton.getText();
    }

    public HomePage clickDownloadButton() {
        helper.waitForElementToBeDisplayed(downloadButton);
        downloadButton.click();
        log.info("Files Downloaded");
        return this;
    }

    public HomePage clickGoBackButton() {
        helper.waitForElementToBeDisplayed(goBackButton);
        goBackButton.click();
        log.info("Return to Main Page");
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

    public String getSortByTitleText() {
        helper.waitForElementToBeDisplayed(sortByText);
        return sortByText.getText();
    }

    public HomePage selectFirstItemOnTheList() {
        helper.waitForElementToBeDisplayed(firstItemOnTheList);
        log.info("Select First Item On The List");
        firstItemOnTheList.click();
        return this;
    }

    public String getFirstFileName() {
        helper.waitForElementToBeDisplayed(firstItemOnTheListText);
        log.info("First File Name Text");
        return firstItemOnTheListText.getText();
    }

    public String getSecondFileName() {
        helper.waitForElementToBeDisplayed(secondItemOnTheListText);
        log.info("Second File Name Text");
        return secondItemOnTheListText.getText();
    }

    public String getThirdFileName() {
        helper.waitForElementToBeDisplayed(thirdItemOnTheListText);
        log.info("Third File Name Text");
        return thirdItemOnTheListText.getText();
    }

    public String getHeaderInfoText() {
        helper.waitForElementToBeDisplayed(headerInfoText);
        log.info("Get Header Info Text");
        return headerInfoText.getText();
    }

    public HomePage openFirstFile() {
        helper.waitForElementToBeDisplayed(firstItemOnTheList);
        action.doubleClick(firstItemOnTheList).perform();
        log.info("Open First File");
        return this;
    }

    public HomePage openSecondFile() {
        helper.waitForElementToBeDisplayed(secondItemOnTheList);
        action.doubleClick(secondItemOnTheList).perform();
        log.info("Open Second File");
        return this;
    }

    public HomePage openThirdFile() {
        helper.waitForElementToBeDisplayed(thirdItemOnTheList);
        action.doubleClick(thirdItemOnTheList).perform();
        log.info("Open Third File");
        return this;
    }

    public String getEmptyGalleryViewText() {
        helper.waitForElementToBeDisplayed(emptyGalleryViewText);
        log.info("Get Empty Gallery View Text");
        return emptyGalleryViewText.getText();
    }

    public HomePage switchFolderViewButton() {
        helper.waitForElementToBeDisplayed(folderViewButton);
        folderViewButton.click();
        log.info("View Folder View Change");
        return this;
    }

    public HomePage clickLogInButton() {
        helper.waitForElementToBeDisplayed(logInButton);
        logInButton.click();
        log.info("Click Log In Button");
        return this;
    }

    public HomePage clickLogInContinueButton() {
        helper.waitForElementToBeDisplayed(logInContinueButton);
        logInContinueButton.click();
        log.info("Click Continue Button In Log In Page");
        return this;
    }

    public String getErrorMessageContainerText() {
        helper.waitForElementToBeDisplayed(errorMessageContainerText);
        log.info("Error Message Forced");
        return errorMessageContainerText.getText();
    }

    public String getErrorPreviewMessageText() {
        helper.waitForElementToBeDisplayed(errorPreviewMessageText);
        log.info("Error Preview Message Text");
        return errorPreviewMessageText.getText();
    }

    public HomePage clickPreviousArrow() {
        helper.waitForElementToBeDisplayed(previousArrow);
        previousArrow.click();
        log.info("Previous Arrow Clicked");
        return this;
    }

    public HomePage clickNextArrow() {
        helper.waitForElementToBeDisplayed(nextArrow);
        nextArrow.click();
        log.info("Next Arrow Clicked");
        return this;
    }

}
