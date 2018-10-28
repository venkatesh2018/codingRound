package codoingRound.pages;

import com.sun.javafx.PlatformUtil;

import codoingRound.driver.Driver_Class;
import codoingRound.utilities.CommonFunctions;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
		try {
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		custom_click(driver, By.id(getlocval("oneway")), 20);
		enter_text(driver, By.xpath(getlocval("frmTag")), 20, gettestdataval("city1"));
		// wait for the auto complete options to appear for the origin
		List<WebElement> originOptions = driver.findElements(By.xpath("//a[@class='Bangalore, IN - Kempegowda International Airport (BLR)']"));
		System.out.println("this is origin option" + originOptions);
		originOptions.get(0).click();
		driver.findElement(By.id("toTag")).sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();

		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(driver, By.className("searchSummary")));

	}

	@Override
	public void clearorentertext(WebDriver driver, By by_arg, int wait, String text) {
      driver.findElement(by_arg).clear();
      driver.findElement(by_arg).sendKeys(text);
	}

}
