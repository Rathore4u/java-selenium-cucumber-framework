package com.aescis.page.locators.spark;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangeLogLocators {

	@Autowired
	public ChangeLogLocators(final WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[normalize-space(.)='CUSTOMER CHANGE LOG']")
	public WebElement pageHeading;

	@FindBy(id = "tbCustomerNo")
	public WebElement customerNumberTextBox;

	@FindBy(id = "btnGetCustomer")
	public WebElement getCustomerButton;
	
	@FindBy(id = "lbCustomerInformation")
	public WebElement customerInformation;
}
