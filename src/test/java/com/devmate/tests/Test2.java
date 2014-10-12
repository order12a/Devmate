package com.devmate.tests;

import static libs.Util.testResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.devmate.pages.Devmate;

public class Test2 {
	private WebDriver driver;
	boolean isTestPassed = true;
	Util util;
	Devmate devmate;
	private TestData testData;
	static Logger log;
	
	@BeforeTest
	public void setUp() throws IOException {
		log = Logger.getLogger(Test1.class.getName());
		Util.killAllProcesses("firefox");
		driver = new FirefoxDriver();
		devmate = new Devmate(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		testData = new TestData();
		util = new Util(driver);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.info("Set Up finished");
	}
	
	@Test
	public void test2()throws Exception{
		log.info("test2 is started");
		devmate.web.open(testData.getAppUrl(), testData.getHomePageTitle());
		util.clearCookies();
		util.clearCash();
		devmate.homePage.clickFeaturesLink();
		isTestPassed = isTestPassed & devmate.featuresPage.isFeaturesUrlOpened(testData.getFrameworksUrl());
		isTestPassed = isTestPassed & devmate.featuresPage.verifySoftwareUpdateIsDisplayed();
		Reporter.log("<hr>");
		Reporter.log("<p>Software Update image</p>");
		Reporter.log("<p></p>");
		Reporter.log("<img src=\"" + devmate.web.makeScreenShot("devmate/scrshots/", "jpg") + "\" alt=\"Screenshot Frameworks\" height=\"auto\" width=\"auto\"></img>");
		
		devmate.featuresPage.clickAppManagementLink();
		isTestPassed = isTestPassed & devmate.appManagementPage.verifyAppManagementUrlOpened(testData.getAppmanagementUrl());
		devmate.web.waitForSomeTime(2000);
		
		Reporter.log("<hr>");
		Reporter.log("<p>App Management image</p>");
		Reporter.log("<p></p>");
		Reporter.log("<img src=\"" + devmate.web.makeScreenShot("devmate/scrshots/", "jpg") + "\" alt=\"Screenshot Frameworks\" height=\"auto\" width=\"auto\"></img>");
		
		testResult(isTestPassed);	
		log.info("test2 is finished");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		log.info("Quit the driver");
		devmate.web.quit();
	}
}
