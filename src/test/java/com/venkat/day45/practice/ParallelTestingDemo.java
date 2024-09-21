package com.venkat.day45.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestingDemo {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) {
		
		switch(br) {
		case "chrome": driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default:System.out.println("Invalid Browser..");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	void testLogo() {
		boolean logo = driver.findElement(By.xpath("//img[@title='Your Store']")).isDisplayed();
		Assert.assertEquals(logo, true);
	}
	
	@Test(priority = 2)
	void testTitle() {	
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
	
	@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.opencart.com/");
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
