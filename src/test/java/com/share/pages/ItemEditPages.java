package com.share.pages;

import com.share.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemEditPages {


    @FindBy(xpath = "/html/body/div[1]/div[1]/div/section/div/div/ul/li[3]/div/div/div[4]/span/span[2]")
    private WebElement thirdFileName;

    private SeleniumHelper helper;

    private WebDriver driver;

    private Logger log = Logger.getLogger(HomePage.class);

    public ItemEditPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }


    public String getThirdFileName() {
        return thirdFileName.getText();
    }
}
