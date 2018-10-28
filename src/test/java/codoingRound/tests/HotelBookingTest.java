package codoingRound.tests;

import org.testng.annotations.Test;

import codoingRound.pages.HotelBooking;

public class HotelBookingTest extends Base_Test{
	
	HotelBooking hotel;
	
	@Test
	public void hotel_booking(){
		hotel=new HotelBooking(driver);
		hotel.shouldBeAbleToSearchForHotels();
	}
}
