package codoingRound.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import codoingRound.driver.Driver_Class;
import codoingRound.utilities.CommonFunctions;

public class Base_Test extends Driver_Class{

	@BeforeTest
	public void launch_app(){
		initialization("chrome","https://www.cleartrip.com/");
	}
	
	@AfterTest
	public void exit_app(){
		exitBrowser();
	}

}
