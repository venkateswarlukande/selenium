package com.venkat.day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewDatePicker1 {

	// user defined method for converting month from string ----> Month
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid Month...");
		}

		return vmonth;
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		String requiredYear = "2000";
		String requiredMonth = "June";
		String requiredDate = "15";

		driver.switchTo().frame("frame-one796456169");
		// click on calendar icon
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		
		// click on year drop down
		WebElement yeardb = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select = new Select(yeardb);
		select.selectByVisibleText(requiredYear);

		// select month

		while (true) {
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			// convert required and display months into Month Objects
			Month expectedMonth = convertMonth(requiredMonth);
			Month currentMonth = convertMonth(displayMonth);

			// compare Months
			int result = expectedMonth.compareTo(currentMonth);

			// 0 months are equal
			// >0 future month
			// <0 past month

			if (result < 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else if (result > 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else {
				break;
			}

		}

		// date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(requiredDate)) {
				dt.click();
				break;
			}
		}

	}

}
