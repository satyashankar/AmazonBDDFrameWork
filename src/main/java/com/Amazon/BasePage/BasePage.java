package com.Amazon.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {
	public static WebDriver  driver;
	 public static Properties prop;
	
	public BasePage() throws IOException {
		
		try {			
		 prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\SandeepGoud\\eclipse-workspace\\AmazonBDDFrameWork\\src\\main\\java\\com\\Amazon\\Config\\Conifg.Properties");
		
				prop.load(ip);
		
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
	}
		public static void Initialization(){
			
			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SandeepGoud\\Desktop\\ChromeSetup.exe");
				driver = new ChromeDriver();			
			}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SandeepGoud\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("Iexplorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\SandeepGoud\\Downloads\\internetexploerdriver.exe");
			driver = new InternetExplorerDriver();
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
		}
	


}
