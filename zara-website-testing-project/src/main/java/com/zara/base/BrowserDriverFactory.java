package com.zara.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	// private String browser;


	public BrowserDriverFactory(String browser) {
		browser = browser.toLowerCase();

	}

	public WebDriver createDriver(String browser) {

		// Create driver
		switch (browser) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
			break;
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
		}
			break;

		default:
			System.out.println("Don't know how to start: " + browser + ". I am starting Chrome browser.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		return driver.get();
	}

}
