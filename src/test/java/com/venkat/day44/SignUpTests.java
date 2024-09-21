package com.venkat.day44;

import org.testng.annotations.Test;
//regression each method
public class SignUpTests {

	@Test(priority = 1, groups = {"regression"})
	void signUpByEmail() {
		
		System.out.println("This is signUp by Email..");
	}
	
	@Test(priority = 2,groups = {"regression"})
	void signUpByFacebook() {
		
		System.out.println("This is signUp by Facebook..");
	}
	
	@Test(priority = 3,groups = {"regression"})
	void signUpByTwitter() {
		
		System.out.println("This is signUp by Twitter..");
	}
}
