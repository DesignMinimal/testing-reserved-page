package com.zara.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyJacketsPage extends BasePageObject {

	private By chooseSizeLocator = By.xpath("//div[@class = 'size-selected']");
	private By sieze128Locator = By.xpath("//ul[@class='sizes-list']/li/span/span[text()='128 (7-8 years)']");
	private By addToBagButtonLocator = By.xpath("//button[@data-selen='add-to-cart-button']");
	private By goToBagButtonLocator = By.xpath("//a[text()='Go to your bag']");


	public BuyJacketsPage(WebDriver driver) {
		super(driver);
	}

	public void selectSize() {
		waitForVisibilityOf(chooseSizeLocator, Duration.ofSeconds(5));
		find(chooseSizeLocator).click();
		waitForVisibilityOf(sieze128Locator, Duration.ofSeconds(5));
		find(sieze128Locator).click();
	}
	
	public ShoppingCartPage addToBag() {
		find(addToBagButtonLocator).click();		
		waitForVisibilityOf(goToBagButtonLocator, Duration.ofSeconds(5));
		find(goToBagButtonLocator).click();
		return new ShoppingCartPage(driver);
	}
}
