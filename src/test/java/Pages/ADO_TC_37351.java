package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Locators.ADO_TC_37351_Locators_Repo;
import Locators.Login_Locators_Repo;
import Tests.ADO_TC_37351_Test;

public class ADO_TC_37351 extends ADO_TC_37351_Test {
  @Test
  public void Update_Item() throws Exception {
	  FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
		WebDriver obj = new FirefoxDriver();
		test= extent.createTest("Update Item Verification and Validations");
		test.log(Status.INFO, "ADO_TC_37351 Test Case Started");
		XSSFCell url= sh.getRow(1).getCell(0);
		obj.get(url.getStringCellValue());
		test.pass("ADO_TC_37351 Test Case Started", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "ADO_TC_37349 Test Case Started")).build());
		obj.manage().window().maximize();
		obj.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		String Currenturl=obj.getCurrentUrl();
		System.out.println("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
		test.pass("URL Launched Successfully",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "URL Launched Successfully")).build());
		Thread.sleep(1000);
		Reporter.log("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
		Thread.sleep(1000);
		XSSFCell username=sh.getRow(1).getCell(1);
		obj.findElement(By.xpath(Login_Locators_Repo.username)).sendKeys(username.getStringCellValue());
		Thread.sleep(500);
		XSSFCell pwd=sh.getRow(1).getCell(2);
		obj.findElement(By.xpath(Login_Locators_Repo.password)).sendKeys(pwd.getStringCellValue());
		Thread.sleep(500);
		obj.findElement(By.xpath(Login_Locators_Repo.login_button)).click();
		Thread.sleep(1000);
		test.pass("Login Successfull", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Login Successfull")).build());
		Thread.sleep(500);
		String parentWindow = obj.getWindowHandle();
		System.out.println(parentWindow);
		ArrayList<String> allwindows= new ArrayList<String>(obj.getWindowHandles());
		obj.switchTo().window(allwindows.get(1));
		test.pass("In Welcome Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"In Welcome Screen")).build());
		Thread.sleep(1000);
		obj.findElement(By.xpath(ADO_TC_37351_Locators_Repo.search_input)).sendKeys("72024545");
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37351_Locators_Repo.search_button)).click();
		Thread.sleep(1000);
		obj.findElement(By.xpath(ADO_TC_37351_Locators_Repo.edit_button)).click();
		Thread.sleep(500);
		test.pass("In Edit Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"In Edit Screen")).build());
		WebElement user=obj.findElement(By.xpath(ADO_TC_37351_Locators_Repo.users_input));
		Thread.sleep(500);
		user.sendKeys("rdpackaging.generic");
		//WebElement user=obj.findElement(By.xpath("//li[contains(text(),'R&D Packaging Generic User (rdpackaging.generic)')]"));
		user.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37351_Locators_Repo.save_button)).click();
		Thread.sleep(1000);
		test.pass("User Updated", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"User Updated")).build());
		Thread.sleep(500);
		obj.findElement(By.xpath(Login_Locators_Repo.logout_button)).click();
		Thread.sleep(500);
		test.pass("Logout Successfull", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Logout Successfull")).build());
		obj.quit();
  }
  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException, Exception
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
