package com.venkat.day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {
	
//	select month and year
	static void selectMonthAndYear(WebDriver driver,String month,String year) {
		
		while (true) {
			String currentMonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Next
			
//			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Previous
	
		}
	}
	
//	Select Day
	
	static void selectDate(WebDriver driver,String day) {
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[contains(text(),datepicker)]//tbody//tr//td//a"));
		for(WebElement dt:allDates) {
			if(dt.getText().equals(day)) {
				dt.click();
				break;
			}
		}
	}
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

//		Switching to frame
		driver.switchTo().frame(0);
		
//		Method1 : using sendKeys.
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/10/2000");//mm/DD/YYYY
		
//		Method2 : using date picker
		
//		Expected Data
		String year="2026";
		String month="September";
		String day="10";
		
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		selectMonthAndYear(driver, month, year);
		selectDate(driver, day);
		
	}

}
