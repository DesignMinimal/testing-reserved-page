package com.zara.loginpagetests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zara.base.BaseTest;
import com.zara.pages.WelcomePage;

public class LogInTests extends BaseTest {

	@Parameters({ "username", "password" })
	@Test
	public void positiveLogInTest(String username, String password) {

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver);

		// log in
		welcomePage.logIn(welcomePage, username, password);


	}
	
	@Parameters({ "username", "password" })
	@Test
	public void negativelogInTest(String username, String password) {

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver);

		// log in
		welcomePage.logIn(welcomePage, username, password);


	}

	
}