package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadData;
import com.utility.ReadExcelData;

public class TestRunner {
public static void main(String[] args)  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		
		String value = ReadData.getData(6, 0);
		
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(value);
		
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		
		
		
	}

}
