package com.venkat.day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaptureScreenshots {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		
		//1. full page screenshot 
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File sourcefile =ts.getScreenshotAs(OutputType.FILE);
//		File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
//		sourcefile.renameTo(targetfile);
		//current directory
		System.out.println(System.getProperty("user.dir"));
		
		//2. capture the screenshot of specific section
		WebElement culturebox = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[4]/div[1]/div[1]"));
		File sourcefile =culturebox.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\culture1.png");
		sourcefile.renameTo(targetfile);
	}

}
