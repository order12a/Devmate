package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Util {
	static Logger log;
	WebDriver driver;

	public Util() {
		log = Logger.getLogger(Util.class.getName());
	}

	public Util(WebDriver driver) {
		log = Logger.getLogger(Util.class.getName());
		this.driver = driver;
	}
	

	/*
	 * This method is used to kill all opened requested browser processes
	 */

	public static void killAllProcesses(String typeOfBrowser)  {
		try {
			if (typeOfBrowser.equalsIgnoreCase("firefox") || typeOfBrowser.equalsIgnoreCase("mozilla firefox")) {
				Process process = Runtime.getRuntime().exec(
						"Taskkill /IM firefox.exe /F");
				process.waitFor();

			}else if(typeOfBrowser.equalsIgnoreCase("chrome") || typeOfBrowser.equalsIgnoreCase("google chrome")){
				Process process = Runtime.getRuntime().exec(
						"Taskkill /IM chrome.exe /F");
				process.waitFor();

			}else if(typeOfBrowser.equalsIgnoreCase("explorer") || typeOfBrowser.equalsIgnoreCase("internet explorer") || typeOfBrowser.equalsIgnoreCase("ie")){
				Process process = Runtime.getRuntime().exec(
						"Taskkill /IM iexplore.exe /F");
				process.waitFor();

			}else if(typeOfBrowser.equalsIgnoreCase("opera")){
				Process process = Runtime.getRuntime().exec(
						"Taskkill /IM opera.exe /F");
				process.waitFor();

			}	
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
	
	/*
	 * This method is used to clear browser cookies
	 */
	
	public void clearCookies() {
		driver.manage().deleteAllCookies();
		log.info("All Cookies are being deleted");
	}
	
	
	/*
	 * This method is used to clear browser cash
	 */
	
	public void clearCash() {
		WebElement bodyElement;
		bodyElement = driver.findElement(By.xpath("html/body"));
		bodyElement.sendKeys(Keys.CONTROL.F5);
		log.info("We cleared cache at the root of the page");
	}
	
	
	/*
	 * Check if the test failed or not and complete the test.
	 */
	
	 public static void testResult(boolean isTestPassed) {
	  if (!isTestPassed) {
	   log.error("TEST FAILED");
	   Assert.fail();
	  }
	  log.info("TEST SUCCESSFULLY COMPLETED");
	 }
}
