package com.venkat.day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenTheLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		Actions act = new Actions(driver);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
		WebElement performance = driver.findElement(By.xpath("//span[normalize-space()='Performance']"));		
		act.keyDown(Keys.CONTROL).click(performance).keyUp(Keys.CONTROL).perform();
		
//		switch to 2nd tab
		Set<String> list =driver.getWindowHandles();
		List<String> arrList = new ArrayList<String>(list);
		driver.switchTo().window(arrList.get(1));
		
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("jethalal");
		
//		switching back to home page
		List<String> ids = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(0));
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Employee");
	}

}
