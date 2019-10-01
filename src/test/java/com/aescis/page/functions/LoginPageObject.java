package com.aescis.page.functions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.LoginLocators;

/**
 * <!-- ========================================================================================================== -->
 * This Class contains all method's specific to Login page of LLM application
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class LoginPageObject extends AbstractBasePage
{
	final LoginLocators loginPageLocators;

	@Autowired
	public LoginPageObject(final WebDriver driver)
	{
		super(driver);
		loginPageLocators = PageFactory.initElements(driver, LoginLocators.class);
	}

	public Properties testProps()
	{
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void enterUserName(final String username)
	{
		waitForVisible(loginPageLocators.usernameTextBox);
		typeEditBox(loginPageLocators.usernameTextBox, username);
	}

	public void enterPassword(final String password)
	{
		typeEditBox(loginPageLocators.passwordTextBox, password);
	}

	public void clickOnLoginButton()
	{
		clickElement(loginPageLocators.loginButton);
	}

	public void verifyLoginPageDisplayed()
	{
		assertElementIsVisible(loginPageLocators.loginButton, testProps().getProperty("loginPage.verification"));
	}
}