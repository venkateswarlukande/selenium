package com.venkat.day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement country= driver.findElement(By.xpath("//select[@id='country-list']"));
		
		Select options = new Select(country);
		
//		options.selectByVisibleText("India");
//		options.selectByValue("3");
//		options.selectByIndex(5);
		
		List<WebElement> allOpts = options.getOptions();
		System.out.println("No of Options :"+allOpts.size());
		
		for(WebElement op:allOpts) {
			System.out.println(op.getText());
		}
	}

}
