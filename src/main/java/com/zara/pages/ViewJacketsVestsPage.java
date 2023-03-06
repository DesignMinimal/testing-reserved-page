package com.zara.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewJacketsVestsPage extends BasePageObject {

	private By jacketWithHoodLocator = By.xpath("//figure[@class='sc-crrszt ffoblr']");
	
	public ViewJacketsVestsPage(WebDriver driver) {
		super(driver);
	}

	public BuyJacketsPage clickJacketWithHood() {
		find(jacketWithHoodLocator).click();
		return new BuyJacketsPage(driver);
	}
	

}
