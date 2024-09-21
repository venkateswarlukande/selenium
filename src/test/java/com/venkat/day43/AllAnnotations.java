package com.venkat.day43;

import org.testng.annotations.*;

public class AllAnnotations {

	@AfterSuite
	void as() {
		System.out.println("this is AfterSuite method...");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println("this is BeforeSuite method...");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("this is BeforeTest method...");
	}
	
	@AfterTest
	void at() {
		System.out.println("this is AfterTest method...");
	}
	
	@BeforeMethod
	void bm() {
		System.out.println("This is bm");
	}
	
	@AfterMethod
	void am() {
		System.out.println("This is am");
	}
	
	@BeforeClass
	void bc() {
		System.out.println("This is bc");
	}
	
	@AfterClass
	void af() {
		System.out.println("This is ac");
	}
	
	@Test(priority = 1)
	void tm1() {
		System.out.println("This is tm1");
	}
	
	@Test(priority = 2)
	void tm2() {
		System.out.println("This is tm2");
	}
}
