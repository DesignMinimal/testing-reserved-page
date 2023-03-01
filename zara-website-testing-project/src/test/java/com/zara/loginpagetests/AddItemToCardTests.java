package com.zara.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zara.base.TestUtilities;
import com.zara.pages.AccoutPage;
import com.zara.pages.BuyJacketsPage;
import com.zara.pages.ShoppingCartPage;
import com.zara.pages.ViewJacketsVestsPage;
import com.zara.pages.WelcomePage;

public class AddItemToCardTests extends TestUtilities {

	public AddItemToCardTests() {
	}

	@Parameters({ "username", "password" })
	@Test
	public void shopGirlsJacket(String username, String password) {

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver);

		// logging in
		AccoutPage accountPage = welcomePage.logIn(welcomePage, username, password);

		// open page with jackets
		ViewJacketsVestsPage viewJacketsVestsPage = accountPage.clickJacketsVestsUnderGirlsSection();

		// select Quilted jacket with hood
		BuyJacketsPage buyJacketsPage = viewJacketsVestsPage.clickJacketWithHood();

		// specify jackets size
		buyJacketsPage.selectSize();

		// add to bag
		ShoppingCartPage shoppingCart = buyJacketsPage.addToBag();

		// empty shopping cart
		shoppingCart.removeAllItems();

		// verify shopping cart is empty
		Assert.assertTrue(shoppingCart.isEmpty());
	}

}
