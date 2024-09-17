package com.venkat.day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		List<WebElement> list= driver.findElements(By.xpath("//table[@id='productTable']//tbody//ancestor::tr//child::td//input"));
		System.out.println(list.size());
//		for(WebElement checkboxes:list) {
//			checkboxes.click();
//		}
		
		for(int i=3;i<list.size();i++) {
			list.get(i).click();
		}
		Thread.sleep(3000);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).isSelected()) {
				list.get(i).click();
			}
		}

	}

}
