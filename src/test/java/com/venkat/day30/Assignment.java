package com.venkat.day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		boolean logoStatus = driver
				.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']"))
				.isDisplayed();
		
		System.out.println("Logo of inner frame of Frame5 is Present? "+logoStatus);
	}

}
