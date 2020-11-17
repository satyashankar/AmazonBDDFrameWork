package com.Amazon.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Amazon.BasePage.BasePage;


public class searchPage extends BasePage {
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	
	WebElement textField;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	WebElement searchBtn;
	
	@FindBy(id="a-autoid-0-announce")
	WebElement dropDown;
	
	@FindBy(id="s-result-sort-select_3")
	WebElement productSortBy;
	
	@FindBy(xpath="//span[text()='5 to 7 Years']")
	WebElement ageRangeOption;
	
	
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartBTN;
	
	
	public searchPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public  void search_Product(String enterProductName) throws InterruptedException {	
		textField.sendKeys(enterProductName);
		searchBtn.click();
	}
	
	public void sort_product_By(String text) throws InterruptedException {
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		dropDown.click();
		
		productSortBy.click();	
		
	}
	
	public void product_seletion_By_Age() {
		ageRangeOption.click();
		
	}
	
		 
	 
	

}
