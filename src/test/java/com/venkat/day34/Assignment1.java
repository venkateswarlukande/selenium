package com.venkat.day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//ul[@id='checkout-products']//li//label//input[@value='550']")).click();
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Venkateswarlu");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Kande");
		
//		DOB
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
//		Year
		WebElement yr = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select year = new Select(yr);
		year.selectByVisibleText("2000");
		
//		Month
		WebElement mn = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select month = new Select(mn);
		month.selectByVisibleText("Sep");
		
//		Day
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt:allDates) {
			if(dt.getText().equals("10")) {
				dt.click();
				break;
			}
		}
		driver.findElement(By.xpath("//p[@id='reasondummy_field']//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']//li[7]")).click();
		
		
	}

}
