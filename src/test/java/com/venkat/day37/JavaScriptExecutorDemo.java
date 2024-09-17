package com.venkat.day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John");
		
//		SENDKEYS()
		
//		JavascriptExecutor
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Smith')", inputbox);
		
//		CKICK()
		
		WebElement male_radio = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", male_radio);
		
	}

}
