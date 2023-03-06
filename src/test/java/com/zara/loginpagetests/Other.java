package com.zara.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zara.base.CsvDataProviders;
import com.zara.base.TestUtilities;
import com.zara.pages.AccoutPage;
import com.zara.pages.LogInPage;
import com.zara.pages.WelcomePage;

public class Other extends TestUtilities {

	@Parameters({ "username", "password" })
	@Test()
	public void positiveLogInPageTest(String username, String password) {


		String expectedUrl = "https://www.zara.com/bg/en/logon";

		LogInPage logInPage = goToLogInPage();

		String expectedName = "TEST";

		Assert.assertTrue(logInPage.getCurrentUrl().equals(expectedUrl),
				"Actual URL is not as expected: " + expectedUrl);

		// enter valid username & password
		//String username = "designminimal@abv.bg";
		//String password = "Supersecretpassword1!";
		AccoutPage accountPage = logInPage.enterValidCredentials(username, password);

		// verifications:
		String actualLoggedInName = accountPage.getLoggedInName();
		Assert.assertTrue(actualLoggedInName.equals(expectedName),
				"Expected name: " + expectedName + " but found " + actualLoggedInName);

	}

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInPageTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// go to Welcome page, open LogIn page
		LogInPage logInPage = goToLogInPage();

//		execute negative login
		logInPage.enterInvalidCredentials(username, password);

//		wait for error message
		logInPage.getAlertText();
		//String actualErrorMessage = logInPage.getErrorMessageText();
	}

	protected LogInPage goToLogInPage() {

		String expectedUrl = "https://www.zara.com/bg/en/logon";

		WelcomePage welcomePage = new WelcomePage(driver);

		LogInPage logInPage = welcomePage.clickLogInButton();

		Assert.assertTrue(logInPage.getCurrentUrl().equals(expectedUrl),
				"Actual URL is not as expected: " + expectedUrl);

		return logInPage;
	}

}
