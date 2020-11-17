package com.Amazon.stepDefinations;

import java.io.IOException;

import org.junit.Assert;

import com.Amazon.BasePage.BasePage;
import com.Amazon.Pages.ProductsPage;
import com.Amazon.Pages.ShoppingCartPage;
import com.Amazon.Pages.searchPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchPagestep extends BasePage {
	
	BasePage basePage;
	searchPage SearchPage;
	ProductsPage productsPage;
	ShoppingCartPage shoppingCartPage;

	
	public searchPagestep() throws IOException {
		super();
		
	}
	
	@Given("^user is on Amazon homePage$")
	public void user_is_on_Amazon_homePage()  {
		basePage.Initialization();
	   String actualhomePageTitle = driver.getTitle();
	   String expectedHomePageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	   Assert.assertEquals(expectedHomePageTitle, actualhomePageTitle);
	   System.out.println(actualhomePageTitle);
	}

	@When("^user searches for Teddy bear$")
	public void user_searches_for_Teddy_bear() throws InterruptedException, IOException  {
	SearchPage = new searchPage();	
    SearchPage.search_Product("teddy bear");
	}

	@When("^user sorts the products according to customer review$")
	public void user_sorts_the_products_according_to_customer_review() throws InterruptedException, IOException  {		
	    
	    SearchPage.sort_product_By("Avg. Customer Review");
	    
	}

	@When("^user selects Age range between (\\d+) to (\\d+) years old$")
	public void user_selects_Age_range_between_to_years_old(String arg1, String arg2) throws IOException  {
		//SearchPage = new searchPage();	
		SearchPage.product_seletion_By_Age();
	}

	@When("^user adds first two products into his cart$")
	public void user_adds_first_two_products_into_his_cart() throws Throwable {
		 productsPage = new ProductsPage();
		productsPage.add_products_to_cart();
	  
	}

	@Then("^two selected teddy bears should be available in his cart$")
	public void two_selected_teddy_bears_should_be_available_in_his_cart() throws IOException  {
		
		shoppingCartPage = new ShoppingCartPage();		
		shoppingCartPage.open_shoppingCart_page(); //open cart page
		
		String actualShoppingCartPageTitle= driver.getTitle();
		String expectedCartPageTitle = "Amazon.com Shopping Cart";
		//Assert.assertEquals(expectedCartPageTitle, actualShoppingCartPageTitle);
		System.out.println(actualShoppingCartPageTitle);
		
		// validating product1 in cart
		Boolean b = shoppingCartPage.Validating_first_product_inCartPage();
		Assert.assertTrue(b);
		// validaating product2 in cart
		Boolean b1 = shoppingCartPage.Validating_Second_product_inCartPage();
	   Assert.assertTrue(b1);
	   
	   driver.close();
	}





}
