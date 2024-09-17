package com.venkat.day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int total_pages =driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
		System.out.println(total_pages);
		
//		Repeating pages
		for(int p=1;p<=total_pages;p++) {
			if(p>1) {
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				active_page.click();
				Thread.sleep(3000);
			}
			
			int noOf_Rows =driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			for(int r=1;r<=noOf_Rows;r++) {
				String productName =driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				String productPrice =driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input")).click();
						
				System.out.println(productName+"\t"+productPrice);
			}
	
		}
	
	}

}
