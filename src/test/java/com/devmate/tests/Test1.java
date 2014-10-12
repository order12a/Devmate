package com.devmate.tests;

import static libs.Util.testResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import libs.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.devmate.pages.Devmate;

public class Test1{ 
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
		log.info("Set Up finished");
	}
	
	@Test
	public void test1()throws Exception{
		log.info("test1 is started");
		devmate.web.open(testData.getAppUrl(), testData.getHomePageTitle());
		util.clearCookies();
		util.clearCash();
		devmate.homePage.clickSignUpButton();
		devmate.signUpPage.setCheckboxSellingOutsideEnabled(testData.getSellingOutsideCheckboxState());
		isTestPassed  = isTestPassed & devmate.signUpPage.checkSolutionFormDisplayed();
		testResult(isTestPassed);
		log.info("test1 is finished");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		log.info("Quit the driver");
		devmate.web.quit();
	}
}
