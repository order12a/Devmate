package libs;

import static libs.ConfigData.ui;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUsedWebElements {
	WebDriver driver;
	static final Logger log = Logger.getLogger(CommonUsedWebElements.class.getName());

	public CommonUsedWebElements(WebDriver driver) throws IOException {
		this.driver = driver;
		log.info("Constructor is created!");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	
	/*
	 * Open URL in a browser and verify page title
	 */

	public boolean open(String url, String title)
			throws ClassNotFoundException, IOException, InstantiationException,
			IllegalAccessException {
		driver.manage().window().maximize();
		driver.get(url);
//		driver.switchTo().frame(0);// It depends from app, could be commented if doesn't work
		
		String pageTitle = driver.getTitle();
		if (pageTitle.equals(title)) {
			log.info("Page: " + url + " succesfully opened,\npage title: " + driver.getTitle());
			return true;
		} else {
			log.error("ERROR, Couldn't open page: " + url);
			return false;
		}
	}	
	
	
	/*
	 * This method is used to click some element(button, link, tab, etc)
	 */

	public void clickOnElement(String xpathElementLocator) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		WebElement element;
		element = driver.findElement(ui(xpathElementLocator));
		element.click();
	}

	
	/*
	 * This method is used to select or deselect checkbox for input as
	 * parameters this method takes check box state (YES or NO) and xpath
	 */

	public void selectCheckBox(String checkboxState,
			String locatorOfCheckBox) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		WebElement checkbox;
		checkbox = driver.findElement(ui(locatorOfCheckBox));
		if (checkbox.isSelected() && checkboxState.equals("YES")) {
			System.out.println("Checkbox is selected, leaves checkbox state selected");
		} else if (!checkbox.isSelected() && checkboxState.equals("NO")) {
			System.out.println("Checkbox is not selected, leaves checkbox state not selected");
		} else if (checkbox.isSelected() && checkboxState.equals("NO")) {
			checkbox.click();
			log.info("Checkbox is selected, set checkbox state to not selected");
		} else if (!checkbox.isSelected() && checkboxState.equals("YES")) {
			checkbox.click();
			log.info("Checkbox is not selected, set checkbox state to selected");
		}
	}
	
	
	/*
	 * This method is used to check that target element is present at the page
	 */
	
	public boolean verifyElementIsPresent(String elementLocator) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
		boolean result = true;
		WebElement element = driver.findElement(ui(elementLocator));
		
		if(element.isDisplayed()){
			log.info("Element - " + elementLocator + " is present at the page");
			log.info("And element has next placeholder: " + element.getAttribute("placeholder"));
			result = true;
		}else{
			log.info("There is no such element - " + elementLocator + " at this page");
			result = false;
		}
		return result;
	}
	
	
	/*
	 * This method is used to make screenshot
	 * Format of fileLocationAndFormat should be next "devmate/test-output/screenshot.png"
	 * 
	 * I used here method which takes class Name(page accorting PageObject pattern) 
	 * and add time when this screenshot is taken to fileName
	 */
	
	public String makeScreenShot(String fileLocation, String Format) {
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		  Date timeNow = new Date();
		  SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH-mm-ss");
		  String fileLocationNameAndFormat =  fileLocation + format.format(timeNow) + "." + Format;
		  // Now you can do whatever you need to do with it, for example copy somewhere
		  try {
			  FileUtils.copyFile(scrFile, new File(fileLocationNameAndFormat), true);
			  log.info("Screenshot: " + fileLocationNameAndFormat + "  was captured");
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  return "../../" + fileLocationNameAndFormat;
		 }
	
	
	/*
	 * This method is used to verify that we at the target URL
	 */
	public boolean verifyUrl(String targetUrl) {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals(targetUrl)) {
			log.info("We at the target url: " + targetUrl);
			return true;
		} else {
			log.info("This is not target url, current url: " + currentUrl);
			return false;
		}
	}
	
	/*
	 * This mehod is used to wait for some time
	 */
	
	public void waitForSomeTime(long miliseconds) throws InterruptedException {
		Thread.sleep(miliseconds);
	}

	/*
	 * This method is used to quit from test
	 */
	
	public void quit() {
		driver.quit();
	}
}
