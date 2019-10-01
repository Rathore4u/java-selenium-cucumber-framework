package com.aescis.page.functions.spark;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.LoginLocators;
import com.aescis.page.locators.spark.ChangeLogLocators;
import com.aescis.page.locators.spark.InvoiceBatchPrintAdministrationLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to CHANGE LOG
 * ADMINISTRATION page
 * 
 * @author Rajpal Singh
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ChangeLogPageObjects extends AbstractBasePage {
	final ChangeLogLocators changeLogPageLocators;

	@Autowired
	public ChangeLogPageObjects(final WebDriver driver) {
		super(driver);
		changeLogPageLocators = PageFactory.initElements(driver, ChangeLogLocators.class);
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("invoiceBatchPrintAdministrationMessage.properties");
	}

	public void verifyPageLoaded() {
		waitForVisible(changeLogPageLocators.getCustomerButton);
		assertElementIsVisible(changeLogPageLocators.pageHeading,
				testProps().getProperty("invoiceBatchPrintAdministrationPage.verification"));
	}

	public void enterCustomerNumber(String number) {
		typeEditBox(changeLogPageLocators.customerNumberTextBox, number);
	}

	public void clickGetCustomerButton() {
		waitUntilElementIsClickable(changeLogPageLocators.getCustomerButton);
		clickElement(changeLogPageLocators.getCustomerButton);
	}
	
	public void verifyCustomerDetails(String text) {
		waitUntilElementIsVisible(changeLogPageLocators.customerInformation);
		waitForElementToContainText(changeLogPageLocators.customerInformation, text);
		String value = changeLogPageLocators.customerInformation.getText();
		boolean contains = false;
		if(value.toLowerCase().contains(text.toLowerCase()))
			contains = true;
		
		assertTrue(text, contains);	
	}
}