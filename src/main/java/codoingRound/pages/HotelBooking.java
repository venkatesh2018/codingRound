package codoingRound.pages;
import codoingRound.utilities.CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBooking extends CommonFunctions {
//this class is to show data abstraction
   WebDriver driver;
   public HotelBooking(WebDriver driver){
	   this.driver=driver;
   }
    
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

     

    }

	@Override
	public void clearorentertext(WebDriver driver, By by_arg, int wait, String text) {
     driver.findElement(by_arg).sendKeys(text);		
	}

    

}
