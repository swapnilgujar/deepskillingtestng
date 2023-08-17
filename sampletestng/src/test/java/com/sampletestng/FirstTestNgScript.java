package com.sampletestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTestNgScript {
	 WebDriver driver = null;
	
	//@BeforeMethod
	@BeforeTest
	public void setUpChrome() {
		 System.out.println("in before method of FirstTestNgScript");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
  @Test(priority = 1)
  public void validateTitle() {
	  
		driver.get("https://globalsqa.com/samplepagetest");
//		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//		System.out.println("Validating title.......");
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(driver.getTitle(),"Sample Page Testing Site Online ");
		Assert.assertEquals(driver.getTitle(),"Sample Page Testing Site Online - Global SQA Testing");
//		softAssert.assertAll();
  }
  @Test(alwaysRun= true, dependsOnMethods = "validateTitle")
  public void fillSamplePageTest_Dropdown() {
	  
		driver.get("https://globalsqa.com/samplepagetest");
		driver.findElement(By.id("g2599-name")).sendKeys("Name");
		driver.findElement(By.id("g2599-email")).sendKeys("test123@test.com");
		driver.findElement(By.id("g2599-website")).sendKeys("https://www.test.com");
		
		Select dropDownValue = new Select(driver.findElement(By.id("g2599-experienceinyears")));
		dropDownValue.selectByIndex(1);
		
		driver.findElement((By.xpath("//input[@type='checkbox' and @value='Functional Testing']"))).click();
		driver.findElement((By.xpath("//input[@type='radio' and @value='Graduate']"))).click();
		driver.findElement((By.id("contact-form-comment-g2599-comment"))).sendKeys("test comments");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Clicked");
  }
  
  @Test(enabled = false)
  
  public void fillSamplePageTest1_NoSubmit() {
	  
		driver.get("https://globalsqa.com/samplepagetest");
		driver.findElement(By.id("g2599-name")).sendKeys("Name");
		driver.findElement(By.id("g2599-email")).sendKeys("test123@test.com");
		driver.findElement(By.id("g2599-website")).sendKeys("https://www.test.com");
		
		Select dropDownValue = new Select(driver.findElement(By.id("g2599-experienceinyears")));
		dropDownValue.selectByIndex(1);
		
		driver.findElement((By.xpath("//input[@type='checkbox' and @value='Functional Testing']"))).click();
		driver.findElement((By.xpath("//input[@type='radio' and @value='Graduate']"))).click();
		driver.findElement((By.id("contact-form-comment-g2599-comment"))).sendKeys("test comments");
		
  }
  @Test (enabled = false)
  public void fillSamplePageTest2_NoDropDown() {
	  
		driver.get("https://globalsqa.com/samplepagetest");
		driver.findElement(By.id("g2599-name")).sendKeys("Name");
		driver.findElement(By.id("g2599-email")).sendKeys("test123@test.com");
		driver.findElement(By.id("g2599-website")).sendKeys("https://www.test.com");
		
		driver.findElement((By.xpath("//input[@type='checkbox' and @value='Functional Testing']"))).click();
		driver.findElement((By.xpath("//input[@type='radio' and @value='Graduate']"))).click();
		driver.findElement((By.id("contact-form-comment-g2599-comment"))).sendKeys("test comments");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  //@AfterMethod
  @AfterTest
  public void tearDown() {
	  System.out.println("in after method of FirstTestNgScript");
	  driver.close();
  }
 
}
