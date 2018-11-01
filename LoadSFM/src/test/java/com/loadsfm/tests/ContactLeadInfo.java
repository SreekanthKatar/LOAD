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

public class ContactLeadInfo extends TestBase {

	public WebDriver driver;

	@BeforeMethod
	public void init() throws InterruptedException {
		System.setProperty(chromedriver, chromepath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(appurl); // http://192.168.2.130:8080/SFM/
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("Test Completed Successfully", true);
		driver.quit();
	}

	@Test(dataProvider = "inputdata", dataProviderClass = Dataprovider.class)
	public void sfmloadtest(String id) throws InterruptedException {

		Actions act = new Actions(driver);

		// UserName
		WebElement UserName = driver.findElement(By.xpath(usrnamepath));
		act.moveToElement(UserName).click().pause(1000).sendKeys(username).build().perform(); // pavan

		// PassWord
		WebElement PassWord = driver.findElement(By.xpath(passwrdpath));
		act.moveToElement(PassWord).click().pause(1000).sendKeys(password).build().perform(); // 123

		// Login
		WebElement Login = driver.findElement(By.xpath(signinbuttonpath));
		Login.submit();

		Thread.sleep(1000);

		String leadinfopageurl = leadinfourlwithoutid + id;
		driver.get(leadinfopageurl);// http://192.168.2.130:8080/SFM/qualifyContactDetails?contactMasterId='id'
		Thread.sleep(1000);

		// Lead Name
		WebElement LeadName = driver.findElement(By.xpath(leadnamepath));
		act.moveToElement(LeadName).click().pause(1000).sendKeys("Test Lead").pause(1000).build().perform();

		// Source
		Select sourcesel = new Select(driver.findElement(By.xpath(sourcepath)));
		sourcesel.selectByValue("1");
		Thread.sleep(1000);

		// Lead Territory
		Select territorysel = new Select(driver.findElement(By.xpath(leadterritorypath)));
		territorysel.selectByVisibleText("Bangalore");
		Thread.sleep(1000);

		// Product Source
		Select productsourcesel = new Select(driver.findElement(By.xpath(productsourcepath)));
		productsourcesel.selectByVisibleText("Leonia");
		Thread.sleep(1000);

		// Product Family
		Select productfamilysel = new Select(driver.findElement(By.xpath(productfamilypath)));
		productfamilysel.selectByVisibleText("Rooms");
		Thread.sleep(1000);

		// Product Group
		Select productgroupsel = new Select(driver.findElement(By.xpath(productgrouppath)));
		productgroupsel.selectByVisibleText("lagoon bay");
		Thread.sleep(3000);

		// Product Type
		WebElement producttype = driver.findElement(By.xpath(producttypepath));
		producttype.click();
		Thread.sleep(1000);
		WebElement producttypeinput = driver.findElement(By.xpath(producttypeinputpath));
		act.moveToElement(producttypeinput).sendKeys("NON").pause(1000).build().perform();
		producttypeinput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		// Quantity
		WebElement quantity = driver.findElement(By.xpath(quantitypath));
		act.moveToElement(quantity).click().pause(1000).sendKeys("5").pause(1000).build().perform();

		// Rating
		Select ratingsel = new Select(driver.findElement(By.xpath(ratingpath)));
		ratingsel.selectByVisibleText("Cool");
		Thread.sleep(1000);

		// Add Button
		WebElement add = driver.findElement(By.xpath(addbuttonpath));
		add.click();
		Thread.sleep(1000);
		
		// Save Button
		WebElement save = driver.findElement(By.xpath(leadsavebuttonpath));
		save.click();
		Thread.sleep(2000);

	}

}
