package com.venkat.day29;




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		
//		Alerts Normal
		
		driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
		Thread.sleep(3500);
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(2000);
//	   Alerts Confirmation
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']")).click();
		Thread.sleep(3500);
		Alert alert2= driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		

	}

}
