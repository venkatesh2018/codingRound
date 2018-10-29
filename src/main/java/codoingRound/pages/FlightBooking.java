package codoingRound.pages;

import com.sun.javafx.PlatformUtil;

import codoingRound.driver.Driver_Class;
import codoingRound.utilities.CommonFunctions;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FlightBooking extends CommonFunctions {
	WebDriver driver;

	public FlightBooking(WebDriver driver) {
		this.driver = driver;
	}

	// This method tests that results appear for one way journey
	public void testThatResultsAppearForAOneWayJourney() throws IOException {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 15);
	        wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			alert.accept();
		} catch(Exception err){
			
		}	
		custom_click(driver, By.id(getlocval("oneway")), 20);
		enter_text(driver,By.cssSelector(getlocval("departdate")), 20, gettestdataval("date"));
	    Select select=new Select(driver.findElement(By.xpath(getlocval("dept_dropdown"))));
        select.selectByValue("6");
		//custom_click(driver, By.id(getlocval("noofpass")), 10);
		enter_text(driver, By.cssSelector(getlocval("frmTag")), 20, gettestdataval("city1"));
		enter_text(driver,By.cssSelector(getlocval("toTag")),20, gettestdataval("city2")); 
		//all fields filled in. Now click on search
		custom_click(driver, By.id(getlocval("searchBtnId")), 20);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(driver, By.id(getlocval("modifySearch"))));
	}

	@Override
	public void clearorentertext(WebDriver driver, By by_arg, int wait, String text) {
      driver.findElement(by_arg).clear();
      driver.findElement(by_arg).sendKeys(text);
	}

}
