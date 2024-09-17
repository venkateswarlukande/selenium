package com.venkat.day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		String ttl = driver.getTitle();

		if (ttl.equals("Your Store")) {
			System.out.println("Test Passed..");
		} else {
			System.out.println("Test Failed..");
		}

		driver.quit();
	}

}
