package com.devmate.pages;

import java.io.IOException;
import libs.CommonUsedWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Devmate {
	public HomePage homePage;
	public SignUpPage signUpPage;
	public FeaturesPage featuresPage;
	public AppManagementPage appManagementPage;
	public CommonUsedWebElements web;
	
	static Logger log = Logger.getLogger(Devmate.class.getName());
	
	public Devmate(WebDriver driver) throws IOException{
		homePage = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
		featuresPage = new FeaturesPage(driver);
		appManagementPage = new AppManagementPage(driver);
		web = new CommonUsedWebElements(driver);
		log.info("Devmate app is initialized");
	}
}
