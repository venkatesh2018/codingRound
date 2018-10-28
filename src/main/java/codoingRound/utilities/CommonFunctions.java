package codoingRound.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonFunctions {
	public static Properties testData;
	public static Properties Locators;
	public static File configfile;
	static FileInputStream fileStream;

	/*
	 * This is a common functions file which is an abstract class where we add all the commonly used
	 * methods and modify them accordingly
	 */
	
	public abstract void clearorentertext(WebDriver driver, By by_arg, int wait, String text);
	
	public static void loadproperties(String datatype) throws IOException {
		if (datatype.equalsIgnoreCase("testdata")) {
			testData = new Properties();
			configfile = new File(System.getProperty("user.dir")
					+ "/src/main/java/codoingRound/locators/testdata.properties");
			fileStream = new FileInputStream(configfile);
			testData.load(fileStream);
		} else if (datatype.equalsIgnoreCase("locators")) {
			Locators = new Properties();
			configfile = new File(System.getProperty("user.dir")
					+ "/src/main/java/codoingRound/locators/locators.properties");
			fileStream = new FileInputStream(configfile);
			Locators.load(fileStream);
		}
	}

 	public static String gettestdataval(String key) throws IOException {
 		loadproperties("testdata");
 		String value = testData.getProperty(key);
 		return value;
 	}
 	
 	public static String getlocval(String key) throws IOException{
 		loadproperties("locators");
 		String value=Locators.getProperty(key);
 		return value;
 	}
 
 	public void custom_click(WebDriver driver, By by_arg, int wait) {
 		explicit_wait(driver, wait, by_arg);
 		driver.findElement(by_arg).click();
 	}
 
 	public void enter_text(WebDriver driver, By by_arg, int wait, String text) {
 		explicit_wait(driver, wait, by_arg);
 		driver.findElement(by_arg).sendKeys(text);
 	}
 
 	public void element_exist_check(WebDriver driver, By by_arg, int wait) {
 		explicit_wait(driver, wait, by_arg);
 	}
 	
 	public boolean isElementPresent(WebDriver driver,By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
 	
 	public void clear_text(WebDriver driver,By by_arg,int wait){
 		explicit_wait(driver, wait, by_arg);
 		driver.findElement(by_arg).clear();
 	}
 	
 	public String getTextMethod(WebDriver driver,int wait, By by){
 		explicit_wait(driver, wait, by);
 		String nameofele=driver.findElement(by).getText();
 		return nameofele;
 	}

	public void explicit_wait(WebDriver driver, int wait, By by) {
		WebDriverWait wait2 = new WebDriverWait(driver, wait);
		wait2.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	


}
