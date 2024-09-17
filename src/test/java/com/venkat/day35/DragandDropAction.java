package com.venkat.day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy =driver.findElement(By.xpath("//div[@id='box106']"));
		WebElement seol = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement koria =driver.findElement(By.xpath("//div[@id='box105']"));
		WebElement wash = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement usa =driver.findElement(By.xpath("//div[@id='box103']"));
		WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
		WebElement norway =driver.findElement(By.xpath("//div[@id='box101']"));
		WebElement copen = driver.findElement(By.xpath("//div[@id='box4']"));
		WebElement den =driver.findElement(By.xpath("//div[@id='box104']"));
		WebElement stock = driver.findElement(By.xpath("//div[@id='box2']"));
		WebElement sweden =driver.findElement(By.xpath("//div[@id='box102']"));

		
		act.dragAndDrop(stock, sweden).perform();
		act.dragAndDrop(copen, den).perform();
		act.dragAndDrop(oslo, norway).perform();
		act.dragAndDrop(rome, italy).perform();
		act.dragAndDrop(wash, usa).perform();
		act.dragAndDrop(seol, koria).perform();
	}
}
