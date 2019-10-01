package com.aescis.page.locators.spark;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MeterLoadPageLocators {
    @Autowired
    public MeterLoadPageLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "td>b")
    public WebElement heading;

    @FindBy(css = "tr[class*=tblListItem]")
    public List<WebElement> rows;
}
