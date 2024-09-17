package com.venkat.day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1). Scroll down the page by pixel number

//		js.executeScript("window.scrollBy(0,500)", "");
//		System.out.println(js.executeScript("return window.pageYOffset;"));

		// 2). Scroll down the page till the element is visible
		
//		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Drag and Drop']"));
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		System.out.println(js.executeScript("return window.pageYOffset;"));

		
		// 3). Scroll down the page till end

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));

		Thread.sleep(4000);
		// 4). Scroll up to initial position

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));	
		
		
	}

}
