package com.venkat.selenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReqHandlerAssign {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Physics");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> xpaths = driver
				.findElements(By.xpath("//div[@class='wikipedia-search-results']//div//child::a"));

		for (WebElement xpath : xpaths) {
			xpath.click();
		}
		Set<String> winIds = driver.getWindowHandles();
		System.out.println(winIds.size());

		for (String ids : winIds) {
			System.out.println(ids);
			WebDriver webDriver = driver.switchTo().window(ids);
			if (webDriver.getTitle().equals("Biology and sexual orientation - Wikipedia")) {
				driver.close();
			}
		}
		Set<String> winId = driver.getWindowHandles();
		System.out.println(winId.size());

	}

}
