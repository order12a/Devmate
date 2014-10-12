package com.devmate.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.CommonUsedWebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	private  WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class.getName());;
	CommonUsedWebElements webElements;
	
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		webElements = new CommonUsedWebElements(driver);
		log.info("Home Page constructor created."); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/*
	 * This method is used to click Sign Up Now button
	 */
	public void clickSignUpButton() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		webElements.clickOnElement("HomePage.signUpNowButton");
		log.info("Sig Up Now button is clicked");
	}
	
	/*
	 * This method is used to click at Features link
	 */
	public void clickFeaturesLink() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		webElements.clickOnElement("HomePage.featuresLink");
		log.info("Features link is clicked");
	}
		
}
