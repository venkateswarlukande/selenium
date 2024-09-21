package com.venkat.day45.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPra {

	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "ys")
	void login(String user, String pwd) throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//		Thread.sleep(2000);
		
		boolean status = driver.findElement(By.xpath("//span[normalize-space()='Admin']")).isDisplayed();
		if(status==true) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
	
	@AfterClass
	void logout() {
		driver.close();
	}
	
	@DataProvider(name = "ys")
	Object[][] data() {
		Object loginDetails[][] = {
				{"John","password123"},
				{"Smith","pass@123"},
				{"Henry","henry@789"},
				{"Venkat","Venk155@"},
				{"Admin","admin123"}
		};
		
		return loginDetails;
	}
	
}
