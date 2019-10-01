package com.aescis.page.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageLocators {

    @Autowired
    public HomePageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ucHeader_btnLogout")
    public WebElement logoutButton;
    
    @FindBy(xpath = "//nobr[text()='Customer Search']")
    public WebElement customerSearch;

    @FindBy(id = "tbQuickSearch")
    public WebElement searchTextbox;

    @FindBy(css = "select[id*=ddQuickSearch]")
    public WebElement searchDropdown;
}
