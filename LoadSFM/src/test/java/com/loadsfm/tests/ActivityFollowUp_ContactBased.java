package com.loadsfm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class ActivityFollowUp_ContactBased extends TestBase {

	public WebDriver driver;

	@BeforeMethod
	public void init() throws InterruptedException {
		System.setProperty(chromedriver, chromepath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(appurl); // http://192.168.2.191:8080/SFM/
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("Test Completed Successfully", true);
		driver.quit();
	}

	@Test(dataProvider = "inputdata", dataProviderClass = Dataprovider.class)
	public void sfmloadtest(String num) throws InterruptedException {

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

		driver.get(activityentrypageurl);

		Thread.sleep(1000);

		// Call Type
		Select calltypesel = new Select(driver.findElement(By.xpath(calltypepath)));
		calltypesel.selectByVisibleText("Contact Based");
		Thread.sleep(1000);

		// Company Name
		WebElement company = driver.findElement(By.xpath(activity_companynamepath));
		act.moveToElement(company).click().pause(1000).build().perform();

		// Company Selection in Modal Popup
		WebElement popupcompany = driver.findElement(By.xpath(modalpopup_companypath));
		act.moveToElement(popupcompany).click().pause(2000).build().perform();

		// Call Type
		Select contactpersonsel = new Select(driver.findElement(By.xpath(activity_contactpersonpath)));
		contactpersonsel.selectByVisibleText("Test");
		Thread.sleep(1000);

		// Activity Type
		Select activitytypesel = new Select(driver.findElement(By.xpath(activitytypepath)));
		activitytypesel.selectByVisibleText("Email");
		Thread.sleep(1000);

		// Activity Type Purpose
		Select activitytypepurposesel = new Select(driver.findElement(By.xpath(activitytypepurposepath)));
		activitytypepurposesel.selectByVisibleText("Introduction Call");
		Thread.sleep(1000);

		// Notes
		WebElement notes = driver.findElement(By.xpath(notespath));
		act.moveToElement(notes).click().pause(1000).sendKeys("Test Note").pause(1000).build().perform();

		// Followup - Yes
		WebElement fupyes = driver.findElement(By.xpath(followuprequestyespath));
		act.moveToElement(fupyes).click().pause(1000).build().perform();

		// Followup Date
		WebElement fupdefdatef = driver.findElement(By.xpath(followupdatefieldpath));
		act.moveToElement(fupdefdatef).click().pause(1000).build().perform();

		// Task Type
		Select fmonthsel = new Select(driver.findElement(By.xpath(followupdatepickmonthcalpath)));
		fmonthsel.selectByVisibleText("Dec");
		Thread.sleep(1000);

		// Followup Date Picker
		WebElement fupdefdate = driver.findElement(By.linkText(followupdatedelinktextpath));
		act.moveToElement(fupdefdate).click().pause(1000).build().perform();

		// Task Name
		WebElement tasknme = driver.findElement(By.xpath(followup_tasknamepath));
		act.moveToElement(tasknme).click().pause(1000).sendKeys("Test Task").pause(1000).build().perform();

		// Task Type
		Select tasktypesel = new Select(driver.findElement(By.xpath(followup_tasktypepath)));
		tasktypesel.selectByVisibleText("Email");
		Thread.sleep(1000);

		// Assigned To
		Select assignedtosel = new Select(driver.findElement(By.xpath(followup_assignedtopath)));
		assignedtosel.selectByVisibleText("venky");
		Thread.sleep(1000);

		// Followup Notes
		WebElement fupnotes = driver.findElement(By.xpath(followup_notespath));
		act.moveToElement(fupnotes).click().pause(1000).sendKeys("Test Followup Note").pause(1000).build().perform();

		// Priority
		Select prioritysel = new Select(driver.findElement(By.xpath(followup_prioritypath)));
		prioritysel.selectByVisibleText("High");
		Thread.sleep(1000);

		 // Save
		 WebElement save = driver.findElement(By.xpath(activity_savebuttonpath));
		 act.moveToElement(save).click().pause(2000).build().perform();

	}
}
