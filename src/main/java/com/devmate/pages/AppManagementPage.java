package com.devmate.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.CommonUsedWebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AppManagementPage {
	private  WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class.getName());;
	CommonUsedWebElements webElements;
	
	
	public AppManagementPage(WebDriver driver) throws IOException {
		this.driver = driver;
		webElements = new CommonUsedWebElements(driver);
		log.info("App-management Page constructor created."); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/*
	 * This method is used to check that we at
	 * the url: http://devmate.com/features/appmanagement
	 */
	public boolean verifyAppManagementUrlOpened(String targetUrl) {
		boolean result;
		result = webElements.verifyUrl(targetUrl);
		log.info("Target url: " + targetUrl + " is opened");
		return result;
	}
	
	/*
	 * This method is used to check that 'Easy updates' image is displayed
	 */
	public boolean verifyEasyUpdatesIsDisplayed() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		boolean result;
		result = webElements.verifyElementIsPresent("App-managementPage.hostApplicationsImage");
		log.info("Easy Update image is displayed");
		return result;
	}
}
