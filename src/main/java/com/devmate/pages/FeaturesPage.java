package com.devmate.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.CommonUsedWebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class FeaturesPage {
	private  WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class.getName());;
	CommonUsedWebElements webElements;
	
	
	public FeaturesPage(WebDriver driver) throws IOException {
		this.driver = driver;
		webElements = new CommonUsedWebElements(driver);
		log.info("Features Page constructor created."); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/*
	 * This method is used to check that we at
	 * the url: http://devmate.com/features/frameworks
	 */
	public boolean isFeaturesUrlOpened(String targetUrl) {
		boolean result;
		result = webElements.verifyUrl(targetUrl);
		log.info("Target url: " + targetUrl + " is opened");
		return result;
	}
	
	/*
	 * This method is used to check that 'sparkle-basedUpdatesFrameworkElement' image is displayed
	 */
	public boolean verifySoftwareUpdateIsDisplayed() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		boolean result;
		result = webElements.verifyElementIsPresent("FeaturesPage.sparkle-basedUpdatesFrameworkElement");
		log.info("Software Update image is displayed");
		return result;
	}
	
	/*
	 * This method is used to click on App Management link
	 * and navigate to http://devmate.com/features/appmanagement.
	 */
	public void clickAppManagementLink() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		webElements.clickOnElement("FeaturesPage.app-managementLink");
		log.info("App Management Link is clicked");
	}
}
