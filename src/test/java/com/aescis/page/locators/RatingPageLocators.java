package com.aescis.page.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RatingPageLocators {

    @Autowired
    public RatingPageLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tbRateCode")
    public WebElement ratingCodeSearchBox;

    @FindBy(id = "btnSearch")
    public WebElement ratingPageSearchButton;

    @FindBy(css = ".fas.fa.fa-search")
    public WebElement ratingPageSearchResultArea;

    @FindBys(@FindBy(xpath = "//tr[@class='tblListRow']/td[1]/a"))
    public List<WebElement> ratingPageSearchResultRows;

}
