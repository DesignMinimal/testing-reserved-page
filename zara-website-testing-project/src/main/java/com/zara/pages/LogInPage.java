package com.zara.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePageObject {

//	private By usernameLocator = By.xpath("//input[@name='logonId']");
//	private By passwordfield = By.xpath("//input[@name='password']");
//	private By logInButton = By.xpath("//button[@class='zds-button zds-button--primary']");

	private By usernameLocator = By.id("login[username]_id");
	private By passwordfield = By.id("login[password]_id");
	private By logInButton = By.xpath(
			"/html//div[@id='loginRegisterRoot']//form[@action='https://www.reserved.com/ie/en/ajx/customer/login/referer/aHR0cHM6Ly93d3cucmVzZXJ2ZWQuY29tL2llL2VuLw,,/uenc/aHR0cHM6Ly93d3cucmVzZXJ2ZWQuY29tL2llL2VuLw,,/?lpp_new_login']/button[.='Sign in']");
	private By signInButton = By.xpath("//button[@data-selen='login-submit']");

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public AccoutPage enterValidCredentials(String username, String password) {
		type(username, usernameLocator);
		type(password, passwordfield);
		click(signInButton);
		return new AccoutPage(driver);
	}

	public void enterInvalidCredentials(String username, String password) {
		type(username, usernameLocator);
		type(password, passwordfield);
		click(logInButton);
	}

	public void getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		System.out.print(alertText);
	}

	public void acceptAlert() {
		Alert alert = switchToAlert();
		alert.accept();
	}

}
