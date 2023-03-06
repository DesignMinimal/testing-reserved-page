package com.zara.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zara.base.BaseTest;
import com.zara.base.CsvDataProviders;
import com.zara.pages.AccoutPage;
import com.zara.pages.LogInPage;
import com.zara.pages.WelcomePage;

public class LogInPageTests extends BaseTest {

	@Parameters({ "username", "password", "accountName" })
	@Test
	public void positiveLogInPageTest(String username, String password, String accountName) {

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver);

		// log in
		AccoutPage accoutPage = welcomePage.logIn(username, password);

		Assert.assertTrue(accoutPage.isAccountNameCorrect(accountName),
				"Account name is not " + accountName + ", as expected");

	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInPageTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver);

		// open login page
		LogInPage loginPage = welcomePage.clickLogInButton();

		// enter invalid credentials
		loginPage.enterInvalidCredentials(username, password);

		// verify expected error message is visible
		Assert.assertTrue(loginPage.isErrorMessageVisible(expectedErrorMessage),
				"The message for test N:" + no + description + "is not as expected.");

	}

}