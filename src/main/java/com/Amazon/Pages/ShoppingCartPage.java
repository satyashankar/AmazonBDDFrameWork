package com.Amazon.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.BasePage.BasePage;

public class ShoppingCartPage extends BasePage {
	
	@FindBy(id="nav-cart")
	WebElement shoppingCart;
	
	@FindBy(xpath="//img[@class='sc-product-image' and @alt='Ty Beanie Babies Erin The Irish St Patricks Teddy Bear, Opens in a new tab']")
	WebElement secondProductInCart;
	
	@FindBy(xpath="//img[@class='sc-product-image' and @alt='Spiral - Toys - TED The Impaler - Teddy Bear, Opens in a new tab']")
	WebElement firstProductInCart;
	
	public ShoppingCartPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void open_shoppingCart_page() {
		shoppingCart.click();
	}
	public Boolean Validating_first_product_inCartPage() {
		return firstProductInCart.isDisplayed();		
		
	}
	
	public Boolean Validating_Second_product_inCartPage() {
		return secondProductInCart.isDisplayed();
	}

}
