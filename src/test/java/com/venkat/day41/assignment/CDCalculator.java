package com.venkat.day41.assignment;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CDCalculator {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String filePath = System.getProperty("user.dir") + "//testdata//caldata2.xlsx";

		int rows = ExcelUtility.getRowCount(filePath, "Sheet1");

		/*
		 * STEPS 1. Read data from excel 2. Pass above data into application 3.Validation
		 */

		for (int r = 1; r <= rows; r++) {

			// 1. Read data from excel
			String deposit = ExcelUtility.getCellData(filePath, "Sheet1", r, 0);
			String interest = ExcelUtility.getCellData(filePath, "Sheet1", r, 1);
			String duration = ExcelUtility.getCellData(filePath, "Sheet1", r, 2);
			String comp = ExcelUtility.getCellData(filePath, "Sheet1", r, 3);
			String exp_total = ExcelUtility.getCellData(filePath, "Sheet1", r, 4);

			// 2. Pass above data into application
			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdAmount']")).clear();
			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdAmount']")).sendKeys(deposit);

			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdLength']")).clear();
			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdLength']")).sendKeys(duration);

			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdRate']")).clear();
			driver.findElement(By.xpath("//app-cd-calculator//form//input[@formcontrolname='cdRate']")).sendKeys(interest);

			// dropdownClick
			driver.findElement(By.xpath("//main[@id='content']//div[4]//mat-form-field//mat-select")).click();
			// select valid option

			List<WebElement> optList = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));

			for (int i = 0; i < optList.size(); i++) {
				if (optList.get(i).getText().equals(comp)) {
					optList.get(i).click();
					break;
				}
			}
			//submit
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
			
			//3.Validation
			
			String act_total = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();

			if(exp_total.equals(act_total)) {
				ExcelUtility.setCellData(filePath, "Sheet1", r, 6, "Pass");
				System.out.println("Test Passed");
			}else {
				ExcelUtility.setCellData(filePath, "Sheet1", r, 6, "Fail");
				System.out.println("Test Failed");
			}
			

		}
		
		driver.quit();

	}

}
