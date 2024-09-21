package com.venkat.day43.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Class2 {

	@Test
	void xyz() {
		System.out.println("this is abc from C2...");
	}
	
	@AfterTest
	void at() {
		System.out.println("this is AfterTest method...");
	}
}
