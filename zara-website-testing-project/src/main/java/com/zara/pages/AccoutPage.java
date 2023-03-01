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

	// browse View all under Girsl menu buttons
	private By menuGirlsLocator = By.linkText("Girls");
	private By viewAllLocator = By.xpath("//*[text()='View All']");

	// browse Jackets, vests under Girls menu buttons
	private By jacketsVestsLocator = By.xpath("//*[text()='girl 5-13 years']/following-sibling::ul/li/a[text()='Jackets, vests']");

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

	/** Hover over a menu option Girls and click on a sub menu option View all */
	public ViewAllPage clickViewAllUnderGirlsSection() {
		clickOnSubMenuElement(menuGirlsLocator, viewAllLocator);
		return new ViewAllPage(driver);
	}
	
	/** Hover over a menu option Girls and click on a sub menu option Jackets, vests */
	public ViewJacketsVestsPage clickJacketsVestsUnderGirlsSection() {
		clickOnSubMenuElement(menuGirlsLocator, jacketsVestsLocator);
		return new ViewJacketsVestsPage(driver);
	}

	/** Hover over a menu option Girls and click on a sub menu option Jackets, vests under Girls 5-13 with a list search*/
	public ViewJacketsVestsPage clickViewJacetsVestsUnderGirlsSection(int i) {
		
		hoverOverElement(find(menuGirlsLocator));

		List<WebElement> jacketsVests = findAll(jacketsVestsLocator);
		WebElement specifiedJacketsVests = jacketsVests.get(i - 1);
	
		specifiedJacketsVests.click();
		return new ViewJacketsVestsPage(driver);
	}

	

}
