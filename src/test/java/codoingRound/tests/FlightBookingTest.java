package codoingRound.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import codoingRound.pages.FlightBooking;

public class FlightBookingTest extends Base_Test{
	FlightBooking flight;
	
	@Test
	public void oneWayJourney() throws IOException{
		flight=new FlightBooking(driver);	
		flight.testThatResultsAppearForAOneWayJourney();
	}

}
