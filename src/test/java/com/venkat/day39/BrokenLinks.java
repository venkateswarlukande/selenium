package com.venkat.day39;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String hrefAttValue = link.getAttribute("href");

			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href Attribute value is null or empty. So not posibble to check..");
				continue;
			}
			try {
				// hit url to the serve
				URL linkURL = new URL(hrefAttValue); // string to url
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // open connection to the server
				conn.connect(); // connect to server sent request to the server

				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue   +": Broken Link");
				} else {
					System.out.println(hrefAttValue   +": Not a Broken Link");
				}
			} catch (Exception e) {

			}

		}
	}

}
