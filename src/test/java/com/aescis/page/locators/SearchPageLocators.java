package com.aescis.page.locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all locators specific to Search page of LLM
 * application
 * 
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class SearchPageLocators {
    @Autowired
    public SearchPageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tbPremiseZip")
    public WebElement premiseZip;

    @FindBy(id = "tbCustomerNo")
    public WebElement accountNo;

    @FindBy(id = "tbLastName")
    public WebElement lastName;

    @FindBy(id = "tbFirstName")
    public WebElement firstName;

    @FindBy(id = "btnSearch")
    public WebElement searchButton;

    @FindBy(id = "upResults")
    public WebElement results;

    @FindBys(@FindBy(xpath = "//table[@id='dgSearchResults']//td"))
    public List<WebElement> resultsData;
}
