package com.devmate.tests;

import org.apache.log4j.Logger;

public class TestData {
	private String appUrl = "http://devmate.com";
	private String sellingOutsideCheckboxState = "YES";
	private String frameworksUrl = "http://devmate.com/features/frameworks";
	private String appmanagementUrl = "http://devmate.com/features/app-management";
	private String homePageTitle = "DevMate Is the Ultimate Tool to Deploy, Manage and Monitor | DevMate";
	
	public String getHomePageTitle() {
		return homePageTitle;
	}
	static Logger log = Logger.getLogger(TestData.class.getName());
	
	public TestData() {
		log.info("Test Data initialized");
	}
	
	public String getAppUrl() {
		return appUrl;
	}
	public String getSellingOutsideCheckboxState() {
		return sellingOutsideCheckboxState;
	}
	public String getFrameworksUrl() {
		return frameworksUrl;
	}
	public String getAppmanagementUrl() {
		return appmanagementUrl;
	}
	
}
