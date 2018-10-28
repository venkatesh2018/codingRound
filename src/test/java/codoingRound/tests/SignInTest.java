package codoingRound.tests;

import org.testng.annotations.Test;

import codoingRound.pages.SignIn;

public class SignInTest extends Base_Test{
	
	SignIn sign;
	
	@Test
	public void signIn(){
		sign=new SignIn(driver);
		sign.shouldThrowAnErrorIfSignInDetailsAreMissing();
	}

}
