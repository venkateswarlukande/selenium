package com.venkat.day29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleAuthenticatedPopup {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
