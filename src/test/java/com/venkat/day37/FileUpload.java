package com.venkat.day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {

	WebDriver driver = new ChromeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file
//		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\venkyselenium\\test1.txt");
//		
//		String fileName = driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText();
//		if(fileName.equals("text1.txt")) {
//			System.out.println("File Name Matched :"+fileName);
//		}else {
//			System.out.println("Not Matched Try Again...");
//		}
		//Multiple 
		
		String file1 = "C:\\venkyselenium\\test1.txt";
		String file2 = "C:\\venkyselenium\\test2.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		System.out.println(driver.findElements(By.xpath("//ul[@id='fileList']//li")).size());
	}

}
