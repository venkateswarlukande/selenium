package com.venkat.day44;

import org.testng.annotations.Test;

//sanity, regression (functional)  each method

public class PaymentTests {

	@Test(priority = 1, groups = { "sanity", "regression","functional" })
	void paymentInRupees() {
		System.out.println("Payment in Rupees");
	}

	@Test(priority = 2, groups = { "sanity", "regression","functional" })
	void paymentInDollers() {
		System.out.println("Payment in Dollers");
	}
}
