package com.sampletestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestNgScript {
	WebDriver driver = null ;
	
	@BeforeMethod
	public  void setUpChrome() {
		System.out.println("in before method of SecondTestNGScript");
	      driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
  @Test
  public void testHerokuapp() {
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		//System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
  
  @AfterMethod
  public void closeDriver() {
	  System.out.println("in after method of SecondTestNGScript");
	  driver.close();
  }
}
