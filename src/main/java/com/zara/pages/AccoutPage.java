package com.zara.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccoutPage extends BasePageObject {

	String expectedUrl = "https://www.zara.com/bg/en/";

	private By loggedInName = By.xpath(
			"//a[@class='layout-header-link layout-header-links__desktop-link layout-header-links__user-name link']");

	private By newsLetterLocator = By.xpath("//div[@class='close']");
	private By menuGirlsLocator = By.linkText("Girls");
	private By jacketsVestsLocator = By
			.xpath("//*[text()='girl 5-13 years']/following-sibling::ul/li/a[text()='Jackets, vests']");

	private By actualAccountNameLocator = By
			.xpath("//div[@class='action-btn__HorizontalActionButton-zbpc1m-2 dwExhh']");

	public AccoutPage(WebDriver driver) {
		super(driver);
	}

	/** Get URL of the expected page */
	public String getPageUrl() {
		return expectedUrl;
	}

	/** Get name of the logged in user */
	public String getLoggedInName() {
		waitForVisibilityOf(loggedInName, Duration.ofSeconds(5));
		WebElement element = find(loggedInName);
		String loggedInName = element.getText();
		return loggedInName;
	}

	public void cancelPopupNewsLetterPrompt() {
		waitForVisibilityOf(newsLetterLocator, Duration.ofSeconds(5));
		WebElement element = find(newsLetterLocator);
		element.click();
	}

	/**
	 * Hover over a menu option Girls and click on a sub menu option Jackets, vests
	 */
	public ViewJacketsVestsPage clickJacketsVestsUnderGirlsSection() {
		clickOnSubMenuElement(menuGirlsLocator, jacketsVestsLocator);
		return new ViewJacketsVestsPage(driver);
	}

	/**
	 * Hover over a menu option Girls and click on a sub menu option Jackets, vests
	 * under Girls 5-13 with a list search
	 */
	public ViewJacketsVestsPage clickViewJacetsVestsUnderGirlsSection(int i) {

		hoverOverElement(find(menuGirlsLocator));

		List<WebElement> jacketsVests = findAll(jacketsVestsLocator);
		WebElement specifiedJacketsVests = jacketsVests.get(i - 1);

		specifiedJacketsVests.click();
		return new ViewJacketsVestsPage(driver);
	}

	public boolean isAccountNameCorrect(String expectedAccountName) {
		waitForVisibilityOf(actualAccountNameLocator, Duration.ofSeconds(7));
		String actualAccountName = find(actualAccountNameLocator).getText().toLowerCase();
		System.out.println("Expected name is: " + expectedAccountName + " and actual name is: " + actualAccountName);
		return actualAccountName.equals(expectedAccountName);
	}

}
