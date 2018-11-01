package com.loadsfm.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.loadsfm.base.TestBase;
import com.loadsfm.utils.Dataprovider;

public class SFMLoad extends TestBase {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void init()
	{
		System.setProperty(chromedriver, chromepath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(appurl); //http://192.168.2.130:8080/SFM/
	}
	
	@AfterMethod
	public void tearDown()
	{
		Reporter.log("Test Completed Successfully", true);
		driver.quit();
	}
	
	@Test(dataProvider = "inputdata", dataProviderClass = Dataprovider.class)	
	public void sfmloadtest(String email,String mobile) throws InterruptedException
	{
		Actions act = new Actions(driver);
		
		//UserName
		WebElement UserName = driver.findElement(By.xpath(usrnamepath));
		act.moveToElement(UserName).click().pause(1000).sendKeys(username).build().perform(); //pavan
		
		//PassWord
		WebElement PassWord = driver.findElement(By.xpath(passwrdpath));
		act.moveToElement(PassWord).click().pause(1000).sendKeys(password).build().perform(); //123
		
		//Login
		WebElement Login = driver.findElement(By.xpath(signinbuttonpath));
		Login.submit();
		
		Thread.sleep(1000);
		
		//Contacts Page URL
		driver.get(contactspageurl);
		
		Thread.sleep(1000);
		
		//Title
		Select titlesel = new Select(driver.findElement(By.xpath(titlepath)));
		titlesel.selectByVisibleText("Mr");
		Thread.sleep(1000);
		
		//Contact Name
		WebElement contactname = driver.findElement(By.xpath(contactnamepath));
		act.moveToElement(contactname).click().pause(1000).sendKeys("Test").build().perform();
		
		//Designation 
		WebElement desig = driver.findElement(By.xpath(designationpath));
		act.moveToElement(desig).click().pause(1000).sendKeys("Test Engineer").build().perform();
		
		//Company Name
		WebElement company = driver.findElement(By.xpath(companypath));
		company.click();
		Thread.sleep(1000);
		WebElement companyinput = driver.findElement(By.xpath(companynameinputpath));
		act.moveToElement(companyinput).sendKeys("Leon").pause(1000).build().perform();
		companyinput.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		//Branch Name
		WebElement branch = driver.findElement(By.xpath(branchnamepath));
		branch.click();
		Thread.sleep(1000);
		WebElement branchinput = driver.findElement(By.xpath(branchnameinputpath));
		act.moveToElement(branchinput).sendKeys("HO").pause(1000).build().perform();
		branchinput.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		//Email
		WebElement mail = driver.findElement(By.xpath(emailpath));
		String emailinput = email+"@gmail.com";
		mail.click();
		act.sendKeys(mail,emailinput).pause(1000).build().perform();//From test1@gmail.com to test2000@gmail.com
		
		//Contact Number
		WebElement contactnumber = driver.findElement(By.xpath(mobilenumber1path));
		contactnumber.click();
		act.sendKeys(contactnumber,mobile).pause(1000).build().perform(); //From 9010801000 to 9010802999
		
		//Save Button
		WebElement save = driver.findElement(By.xpath(savebuttonpath));
		save.click();
		
		Thread.sleep(2000);
	}
	
	
	
	

}
