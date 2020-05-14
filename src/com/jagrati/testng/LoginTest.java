package com.jagrati.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

WebDriver driver ;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:\\WebDrivers_Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void gmailLogin() throws InterruptedException
	{
	driver.get("https://gmail.com");
	String expectedTitle = "Gmail";
	String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);
    
    Thread.sleep(4000);
    
    WebElement username = driver.findElement(By.id("identifierId"));
    username.clear();
    username.sendKeys("seleniumtesting108");
    
    driver.findElement((By.xpath("//span[contains(@class,'RveJvd snByac')]  [contains(text(),'Next')]"))).click();
   
 
    WebElement password = driver.findElement(By.name("password"));
    
    password.sendKeys("Password@1008");
    
    driver.findElement((By.xpath("//span[contains(@class,'RveJvd snByac')]  [contains(text(),'Next')]"))).click();
 
   }
	 @AfterMethod
	    public void tearDown(){
	    	driver.quit();
	    }
}