package com.venkat.day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		String filePath = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";

		int rows = ExcelUtls.getRowCount(filePath, "Sheet1");
		
		for(int r=1;r<=rows;r++) {
			/* STEPS
			 * 1. Read data from excel
			 * 2. Pass above data into application
			 * 3. Validation */
			
			//1. Read data from excel
			String principle = ExcelUtls.getCellData(filePath, "Sheet1", r, 0);
			String rateOfInterest = ExcelUtls.getCellData(filePath, "Sheet1", r, 1);
			String period1 = ExcelUtls.getCellData(filePath, "Sheet1", r, 2);
			String period2 = ExcelUtls.getCellData(filePath, "Sheet1", r, 3);
			String fre = ExcelUtls.getCellData(filePath, "Sheet1", r, 4);
			String exp_mvalue = ExcelUtls.getCellData(filePath, "Sheet1", r, 5);
			
			
			//2. Pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			WebElement tenure = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select perdrp = new Select(tenure);
			perdrp.selectByVisibleText(period2);
			
			WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select fredrp = new Select(frequency);
			fredrp.selectByVisibleText(fre);
					
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

			//3. Validation
			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)) {
				System.out.println("Test Passed");
				ExcelUtls.setCellData(filePath, "Sheet1", r, 7, "Passed");
				ExcelUtls.fillGreenColor(filePath, "Sheet1", r, 7);
			}else {
				System.out.println("Test Failed");
				ExcelUtls.setCellData(filePath, "Sheet1", r, 7, "Failed");
				ExcelUtls.fillRedColor(filePath, "Sheet1", r, 7);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		
		}
		
		driver.quit();

	}

}
