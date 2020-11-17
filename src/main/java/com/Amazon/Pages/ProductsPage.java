package com.Amazon.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Amazon.BasePage.BasePage;

public class ProductsPage extends BasePage{
	


	@FindBy(xpath="//img[@class='s-image' and @data-image-index='1']")
	WebElement teddyBear1;
	
	@FindBy(xpath="//img[@class='s-image' and @data-image-index='2']")
	WebElement teddyBear2;	
	
	@FindBy(id="buybox-see-all-buying-choices-announce")
	WebElement buyingOptions;
	
	@FindBy(xpath="//*[@id=\"a-autoid-2\"]/span/input")
	WebElement newBTN;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartBTN;

	public ProductsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void add_products_to_cart() throws InterruptedException {			    
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		//adding first product to cart
		teddyBear1.click();
		WebDriverWait wait = new WebDriverWait(driver,10);		    
       wait.until(ExpectedConditions.elementToBeClickable(addToCartBTN)).click();       
      // wait.until(ExpectedConditions.elementToBeClickable(newBTN)).click();
       Thread.sleep(5000);
    	//adding sencond product to cart   
       driver.navigate().to(currentURL);
       wait.until(ExpectedConditions.elementToBeClickable(teddyBear2)).click();  
       addToCartBTN.click();
       driver.navigate().refresh(); 
    	   
		
        }
		
	}


