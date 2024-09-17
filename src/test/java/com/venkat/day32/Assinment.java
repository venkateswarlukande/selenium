package com.venkat.day32;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assinment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		WebElement dp = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departure = new Select(dp);
		departure.selectByVisibleText("Boston");

		WebElement ds = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destination = new Select(ds);
		destination.selectByVisibleText("Dublin");

		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();	
		
		double[] price = new double[rows-1];
		
		for (int r = 1; r < rows; r++) {
			String allPrices = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]")).getText();
			String prices =allPrices.replace('$',' ').trim();
			price[r-1]=Double.parseDouble(prices);
		}
		Arrays.sort(price);
		String least="$"+String.valueOf(price[0]);
		for (int r = 1; r <rows; r++) {
			if(least.equals(driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]")).getText())) {
				driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[1]//input[@type='submit']")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Venkat");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Balaji Nagar");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Nellore");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Andhra Pradesh");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("524300");
		//cardType
		WebElement card = driver.findElement(By.xpath("//select[@name='cardType']"));
		Select cardType = new Select(card);
		cardType.selectByValue("amex");
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("424556748964");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2029");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Venkat USA");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		String msg =driver.findElement(By.xpath("//div[@class='container']//div//h1")).getText();
		if(msg.equals("Thank you for your purchase todays!")) {
			System.out.println("Tested successfully..!");
		}else {
			System.out.println("Test Failed..!");
		}
		
	
//		driver.quit();
	}

}
