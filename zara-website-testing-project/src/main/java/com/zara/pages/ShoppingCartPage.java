package com.zara.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePageObject {

	private By binLocator = By.xpath("//button[@data-selen='product-remove']");
	private By emptyCardValidation = By.xpath("//h1[text()='Your cart is empty']");
	private String emptyCardExpectedMessage = "Your cart is empty";

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void removeAllItems() {
		List<WebElement> items = driver.findElements(binLocator);
		for (WebElement item : items) {
			item.click();
		}
	}
	
	public boolean isEmpty() {
		waitForVisibilityOf(emptyCardValidation, Duration.ofSeconds(5));
		return find(emptyCardValidation).getText().equals(emptyCardExpectedMessage);
	}

}
