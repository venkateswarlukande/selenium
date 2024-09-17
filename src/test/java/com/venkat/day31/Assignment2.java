package com.venkat.day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
//		clicking on PIM
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
//		clicking on drop down
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]")).click();

//		select single option
//		driver.findElement(By.xpath("//span[normalize-space()='Full-Time Permanent']")).click();
		
//		capture all options and count no of options
		List<WebElement> allop= driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("No Of Options :"+allop.size());
		for(WebElement op:allop) {
			System.out.println(op.getText());
		}
		
	}

}
