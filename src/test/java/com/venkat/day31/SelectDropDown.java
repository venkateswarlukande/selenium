package com.venkat.day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select dpdncountry = new Select(country);
		//selectByVisibleText
//		dpdncountry.selectByVisibleText("Japan");
		
		//selectByValue
//		dpdncountry.selectByValue("india");
		
		//selectByIndex
//		dpdncountry.selectByIndex(3);
		
		List<WebElement> options = dpdncountry.getOptions();
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
	}

}
