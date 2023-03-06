package com.zara.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

//	private String pageUrl = "https://www.zara.com/bg/en";
//
//	private By acceptAllCookiesButton = By.id("onetrust-accept-btn-handler");
//	private By logInButton = By.linkText("LOG IN");

	private String pageUrl = "https://www.reserved.com/ie/en/";
	private By acceptAllCookiesButton = By.id("cookiebotDialogOkButton");
	private By logInButton = By
			.xpath("/html//div[@id='headerWrapper']//div[@class='action-btn__HorizontalActionButton-zbpc1m-2 dwExhh']");

	
	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	/** Open WelcomePage with it's url */
	protected void openWelcomePage() {
		openUrl(pageUrl);
	}

	/** Accept all Cookies */
	protected void acceptAllCookies() {
		click(acceptAllCookiesButton);
	}

	/** Click log in button */
	public LogInPage clickLogInButton() {
		openWelcomePage();
		waitForVisibilityOf(acceptAllCookiesButton, Duration.ofSeconds(5));
		acceptAllCookies();
		waitForVisibilityOf(logInButton, Duration.ofSeconds(5));
		click(logInButton);
		return new LogInPage(driver);
	}
	
	public AccoutPage logIn(WelcomePage welcomePage, String username, String password) {

//		open log in page
		LogInPage logInPage = welcomePage.clickLogInButton();

//		open account page
		AccoutPage accountPage = logInPage.enterValidCredentials(username, password);

		accountPage.cancelPopupNewsLetterPrompt();
		return accountPage;

	}
	
	
}
