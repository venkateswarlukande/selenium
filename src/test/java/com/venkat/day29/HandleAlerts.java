package com.venkat.day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		// Normal alert with OK button

		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 * 
		 * Thread.sleep(5000);
		 * 
		 * driver.switchTo().alert().accept();
		 * 
		 * Alert myalert = driver.switchTo().alert();
		 * 
		 * System.out.println(myalert.getText());
		 * 
		 * myalert.accept(); }
		 */

		// Confirmation Alert
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Thread.sleep(5000);
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();

		//Prompt Alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Welcome");
		alert.accept();
	}
}
