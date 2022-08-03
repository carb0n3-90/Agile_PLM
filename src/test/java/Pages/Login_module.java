package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Locators.Login_Locators_Repo;
import Tests.Login_Test;

public class Login_module extends Login_Test {
	
	  @Test(priority=1)
	  public void Login_with_valid_credentials() throws Exception {
		 
		  FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Sheet1");

		    System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
		    WebDriver obj = new FirefoxDriver();
		    test= extent.createTest("Login with Valid Credentials");
		    test.log(Status.INFO, "Login Test Case with Valid Credentials Started");
		    XSSFCell url= sh.getRow(1).getCell(0);
			obj.get(url.getStringCellValue());
			test.pass("Login with Valid Credentials", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "Login with Valid Credentials")).build());
			obj.manage().window().maximize();
			obj.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			String Currenturl=obj.getCurrentUrl();
			System.out.println("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
			test.pass("URL Launched Successfully",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "URL Launched Successfully")).build());
			Thread.sleep(500);
	        Reporter.log("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
			Thread.sleep(1000);
			String note= obj.findElement(By.xpath(Login_Locators_Repo.note)).getText();
			test.info("Note is Diplayed as--"+note);
			test.info("URL note displayed --"+note.equalsIgnoreCase("To log in, enter your username and password, then click Login. Passwords are case-sensitive."));
			WebElement clear_button=obj.findElement(By.xpath(Login_Locators_Repo.clear_button));
			if(clear_button.isDisplayed()) {
				clear_button.click();
				test.info("Clear button is Displayed and Clicked");

			}
			else {
				test.info("Clear button is not displayed");
			}
			String request_account_link=obj.findElement(By.xpath(Login_Locators_Repo.request_account_link)).getText();
			test.info("Request Account Text is Diplayed as--"+request_account_link);
			test.info("Request Account text Displayed--"+request_account_link.equalsIgnoreCase("Request Account"));
			String forgot_password_link=obj.findElement(By.xpath(Login_Locators_Repo.forgot_password_link)).getText();
			test.info("Forgot Password text is diplayed as--"+forgot_password_link);
			test.info("Forgot Password text Displayed--"+forgot_password_link.equalsIgnoreCase("Forgot password?"));
			String build_number_text=obj.findElement(By.xpath(Login_Locators_Repo.build_number_text)).getText();
			test.info("Build Number text is displayed as--"+build_number_text);
			test.info("Build Number text Displayed--"+build_number_text.equalsIgnoreCase("Build Number:9.3.6 (Build 47)"));
			XSSFCell username=sh.getRow(1).getCell(1);
			obj.findElement(By.xpath(Login_Locators_Repo.username)).sendKeys(username.getStringCellValue());
			Thread.sleep(500);
			XSSFCell pwd=sh.getRow(1).getCell(2);
			obj.findElement(By.xpath(Login_Locators_Repo.password)).sendKeys(pwd.getStringCellValue());
			Thread.sleep(500);
			obj.findElement(By.xpath(Login_Locators_Repo.login_button)).click();
			Thread.sleep(1000);
			test.pass("Login Successfull", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Login Successfull")).build());
			Thread.sleep(1000);
		    String login_message= obj.findElement(By.xpath(Login_Locators_Repo.login_message)).getText();
			test.info("Message after successful login is displayed as--" +login_message);
		    String parentWindow = obj.getWindowHandle();
			//store the set of all windows
			  Set<String> allwindows= obj.getWindowHandles();

			  for (String childWindow : allwindows) {
			    if(!childWindow.equals(parentWindow))
			      {
			        obj.switchTo().window(childWindow);
			        test.pass("In Welcome Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"In Welcome Screen")).build());
			        obj.findElement(By.xpath(Login_Locators_Repo.logout_button)).click();
					Thread.sleep(500);
					test.pass("Logout Successfull", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Logout Successfull")).build());
			      }
			  }
			obj.quit();
			}
		  @Test(enabled= false)
		public void Login_with_blank_credentials() throws IOException, Exception {
			FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Sheet1");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
			    WebDriver obj = new FirefoxDriver();
			    test= extent.createTest("Login with blank Credentials");
			    test.log(Status.INFO, "Login Test Case with blank credentials Started");
			    XSSFCell url= sh.getRow(2).getCell(0);
				obj.get(url.getStringCellValue());
				test.pass("Navigated to the URL", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "Navigated to the URL")).build());
				obj.manage().window().maximize();
				obj.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				String Currenturl=obj.getCurrentUrl();
				System.out.println("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
				Thread.sleep(1000);
				test.pass("URL Launched Successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "URL Launched Successfully")).build());
				Reporter.log("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
				Thread.sleep(1000);
				obj.findElement(By.xpath(Login_Locators_Repo.login_button)).click();
				Thread.sleep(500);
				String error_message=obj.findElement(By.xpath(Login_Locators_Repo.error_message)).getText();
				test.info("Error message is displayed as--"+error_message);
				test.info("Error Message Displayed--"+error_message.equalsIgnoreCase("Invalid user ID or password."));
				test.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Unable to Login with blank Credentials")).build());
				obj.quit();
				}
		  @Test(enabled=false)
		  public void Login_with_Invalid_credentials() throws Exception {
			  FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				XSSFSheet sh=wb.getSheet("Sheet1");

				for(int i=3;i<=sh.getLastRowNum();i++) {
				    System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
				    WebDriver obj = new FirefoxDriver();
				    test= extent.createTest("Login with Invalid credentials");
				    test.log(Status.INFO, "Login Test Case with Invalid credentials Started");
				    XSSFCell url= sh.getRow(i).getCell(0);
					obj.get(url.getStringCellValue());
					test.pass("Navigated to the URL", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "Navigated to the URL")).build());
					obj.manage().window().maximize();
					//test.addScreenCaptureFromPath(getScreenshot(obj, "Navigated to the URL"));
					obj.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					String Currenturl=obj.getCurrentUrl();
					System.out.println("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
					Thread.sleep(1000);
					test.pass("URL Launched Successfully",MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "URL Launched Successfully")).build());
					Reporter.log("Browser launched --"+Currenturl.equalsIgnoreCase(url.getStringCellValue()));
					Thread.sleep(1000);
					XSSFCell username=sh.getRow(i).getCell(1);
					obj.findElement(By.xpath(Login_Locators_Repo.username)).sendKeys(username.getStringCellValue());
					Thread.sleep(500);
					XSSFCell pwd=sh.getRow(i).getCell(2);
					obj.findElement(By.xpath(Login_Locators_Repo.password)).sendKeys(pwd.getStringCellValue());
					Thread.sleep(500);
					obj.findElement(By.xpath(Login_Locators_Repo.login_button)).click();
					Thread.sleep(500);
					String error_message=obj.findElement(By.xpath(Login_Locators_Repo.error_message)).getText();
					test.info("Error message is displayed as--"+error_message);
					test.info("Error Message Displayed--"+error_message.equalsIgnoreCase("Invalid user ID or password."));
					//test.addScreenCaptureFromBase64String(getScreenshot(obj, "Unable to login with Invalid Credentials"));
					test.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "Unable to login with Invalid Credentials")).build());
					obj.quit();
				}
		  }
		  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException, Exception
		    {
			  return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		       		    }
}
