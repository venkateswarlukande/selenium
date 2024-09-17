package com.venkat.day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		WebElement button =driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		System.out.println(box2.getText());
		
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();

		if(box2.getText().equals(box1.getText())) {
			System.out.println("Hey! Venkat Your currect. Verified....");
		}else {
			System.out.println("Not Verified...");
		}
				
	}
}
