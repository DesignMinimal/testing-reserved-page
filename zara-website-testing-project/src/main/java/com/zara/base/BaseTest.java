package com.zara.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser) {

// 		create driver

		BrowserDriverFactory factory = new BrowserDriverFactory(browser);

		driver = factory.createDriver(browser);

// 		maximize browser window
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// close browser
		driver.quit();
	}
}
