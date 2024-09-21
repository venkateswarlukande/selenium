package com.venkat.day32;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		Find total no of rows in table
		
//		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("No of rows :"+ rows);
		
//		int rows =driver.findElements(By.tagName("tr")).size();
//		System.out.println("No of rows :"+ rows);
		
//		Find total no of columns
		int columns =driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No of Columns :"+ columns);
		
//		Read data from specific row and column
		String data =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[2]")).getText();
		System.out.println(data);
		
//		Read data from all the rows and columns
//		for(int r =2;r<rows;r++) {
//			for(int c=1;c<columns;c++) {
//				String value =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//				System.out.print(value+"\t");
//			}
//			System.out.println();
//		}
		
//		Print book name whose author is mukesh
		
		for(int r=2;r<=rows;r++) {
			String authorName =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(authorName.equals("Mukesh")) {
				
				String bookName =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName);
			}
			
		}
		
//		Find total price of the all the book
//		int total=0;
//		for(int r=2;r<=rows;r++) {
//			String value =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
//			total=total+Integer.parseInt(value);
//		}
//		System.out.println("Total Price of the books: "+total);
		
		
		
		
		
	}

}
