package com.devmate.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.CommonUsedWebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	private  WebDriver driver;
	static Logger log = Logger.getLogger(HomePage.class.getName());;
	CommonUsedWebElements webElements;
	
	
	public SignUpPage(WebDriver driver) throws IOException {
		this.driver = driver;
		webElements = new CommonUsedWebElements(driver);
		log.info("Sign Up Page constructor created."); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	
	/*
	 * This method is used to set "I'm selling or considering
	 * selling outside the Mac App Store" checkbox checked
	 */
	public void setCheckboxSellingOutsideEnabled(String checkBoxState) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		webElements.selectCheckBox(checkBoxState, "SignUpPage.sellingOutsideMacAppSrtoreCheckbox");
		log.info("Checkbox \'I\'m selling or considering selling outside the Mac App Store\' is checked");
	}
	
	/*
	 * This method is used to check that 'solution' form is displayed
	 */
	public boolean checkSolutionFormDisplayed() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		boolean result = webElements.verifyElementIsPresent("SignUpPage.solutionField");
		log.info("\'Solution\' form is displayed");
		return result;
	}
}
