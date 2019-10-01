package com.aescis.page.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!-- ========================================================================================================== -->
 * This Class contains all locators specific to Login page of LLM application
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class LoginLocators
{
	@Autowired
	public LoginLocators(final WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "tbUserName")
	public WebElement	usernameTextBox;

	@FindBy(id = "tbUserPassword")
	public WebElement	passwordTextBox;

	@FindBy(id = "btnLogin")
	public WebElement	loginButton;
}