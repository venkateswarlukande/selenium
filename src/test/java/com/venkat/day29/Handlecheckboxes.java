package com.venkat.day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlecheckboxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

////		1. select specific checkbox
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
//
////		2. select multiple checkboxes
		List<WebElement> checkbxs = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		System.out.println("Size of The CheckBoxes: " + checkbxs.size());
//		for (WebElement check : checkbxs) {
//			check.click();
//		}
		
//		3. select last 3 checkboxes
//		for(int i=4;i<checkbxs.size();i++) {
//			checkbxs.get(i).click(); 
//		}
		
////		4. select first 3 checkboxes
//		for(int i=0;i<3;i++) {
//			checkbxs.get(i).click(); 
//		}
		
//		5. unselect the selected checkboxes
		for(int i=0;i<3;i++) {
			checkbxs.get(i).click(); 
		}
		
		Thread.sleep(5000);
		
		for(int i=0;i<checkbxs.size();i++) {
			if(checkbxs.get(i).isSelected()) {
				checkbxs.get(i).click();
			}
		}
		
		
	}

}
