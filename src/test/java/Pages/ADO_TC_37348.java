package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import Locators.ADO_TC_37348_Locators_Repo;
import Locators.Login_Locators_Repo;
import Tests.ADO_TC_37348_Test;

public class ADO_TC_37348 extends ADO_TC_37348_Test {
  @Test
  public void Home_Page() throws Exception {
	  
	  FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
	    WebDriver obj = new FirefoxDriver();
	    test= extent.createTest("Home Page Verification and Validations");
	    test.log(Status.INFO, "ADO_TC_37348 Test Case Started");
	    XSSFCell url= sh.getRow(1).getCell(0);
		obj.get(url.getStringCellValue());
		test.pass("ADO_TC_37348 Test Case Started", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "ADO_TC_37348 Test Case Started")).build());
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
		//store the set of all windows
		  Set<String> allwindows= obj.getWindowHandles();
		  for (String childWindow : allwindows) {
			    if(!childWindow.equals(parentWindow))
			      {
			    	obj.switchTo().window(childWindow);
		WebElement workflow_routings= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.workflow_routings));
		if(workflow_routings.isDisplayed()) {
			test.info("Workflow Routings tab is Displayed");
		}
		else {
			test.info("Workflow Routings tab is not Displayed");
		}
		WebElement dashboard= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.dashboard));
		if(dashboard.isDisplayed()) {
			test.info("Dashboard tab is Displayed");
		}
		else {
			test.info("Dashboard tab is not Displayed");
		}
		WebElement notifications= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.notifications));
		if(notifications.isDisplayed()) {
			test.info("Notifications tab is Displayed");
		}
		else {
			test.info("Notifications tab is not Displayed");
		}
		WebElement my_assignments= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.my_assignments));
		if(my_assignments.isDisplayed()) {
			test.info("My Assignments tab is Displayed");
		}
		else {
			test.info("My Assignments tab is not Displayed");
		}
		String Welcome_header= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.welcome_header)).getText();
		test.info("Welcome Header is Displayed as--"+Welcome_header);
		test.info("Displayed Welcome Header is--"+Welcome_header.equalsIgnoreCase("Welcome "));
		String Welcome_note= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.welcome_note)).getText();
		test.info("Welcome Note is Displayed as--"+Welcome_note);
		test.info("Displayed Welcome Note is--"+Welcome_note.equalsIgnoreCase("R&D Packaging Generic User (rdpackaging.generic)"));
		WebElement backward= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.backward));
		if(backward.isDisplayed()) {
			test.info("Backward button is Displayed");
		}
		else {
			test.info("Backward button is not Displayed");
		}
		WebElement forward= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.forward));
		if(forward.isDisplayed()) {
			test.info("Forward button is Displayed");
		}
		else {
			test.info("Forward button is not Displayed");
		}
		WebElement refresh= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.refresh));
		if(refresh.isDisplayed()) {
			test.info("Refresh button is Displayed");
		}
		else {
			test.info("Refresh button is not Displayed");
		}
		WebElement home= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.home));
		if(home.isDisplayed()) {
			test.info("Home button is Displayed");
		}
		else {
			test.info("Home button is not Displayed");
		}
		WebElement file_progress= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.file_progress));
		if(file_progress.isDisplayed()) {
			test.info("File Progress button is Displayed");
		}
		else {
			test.info("File Progress button is not Displayed");
		}
		WebElement create_new= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.create_new));
		if(create_new.isDisplayed()) {
			test.info("Create New button is Displayed");
		}
		else {
			test.info("Create New button is not Displayed");
		}
		WebElement search_box= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.search_box));
		if(search_box.isDisplayed()) {
			test.info("Search Box is Displayed");
		}
		else {
			test.info("Search is not Displayed");
		}
		String quick_links= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.quick_links)).getText();
		test.info("Quick Link is displayed as--"+quick_links);
		test.info("Displayed Quick link is--"+quick_links.equalsIgnoreCase("Quick Links"));
		WebElement folders= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.Folders));
		if(folders.isDisplayed()) {
			test.info("Folders tab is Displayed");
		}
		else {
			test.info("Folders tab is not Displayed");
		}
		String searches_link= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.searches)).getText();
		test.info("Searches Link is displayed as--"+searches_link);
		test.info("Displayed Searches link is--"+searches_link.equalsIgnoreCase("Searches"));
		String my_bookmarks= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.my_bookmarks)).getText();
		test.info("My Bookmarks Link is displayed as--"+my_bookmarks);
		test.info("Displayed My Bookmarks link is--"+my_bookmarks.equalsIgnoreCase("My Bookmarks"));
		String recently_visited= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.recently_visited)).getText();
		test.info("Recently Visited Link is displayed as--"+recently_visited);
		test.info("Displayed Recently Visited link is--"+recently_visited.equalsIgnoreCase("Recently Visited"));
		WebElement reports= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.Reports));
		if(reports.isDisplayed()) {
			test.info("Reports tab is Displayed");
		}
		else {
			test.info("Reports tab is not Displayed");
		}
		WebElement navigator= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.Navigator));
		if(navigator.isDisplayed()) {
			test.info("Navigator tab is Displayed");
		}
		else {
			test.info("Navigator tab is not Displayed");
		}
		WebElement my_settings= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.my_settings));
		if(my_settings.isDisplayed()) {
			test.info("My Settings button is Displayed");
		}
		else {
			test.info("My Settings button is not Displayed");
		}
		WebElement preferences= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.preferences));
		if(preferences.isDisplayed()) {
			test.info("Preferences button is Displayed");
		}
		else {
			test.info("Preferences button is not Displayed");
		}
		WebElement help= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.help));
		if(help.isDisplayed()) {
			test.info("Help button is Displayed");
		}
		else {
			test.info("Help button is not Displayed");
		}
		WebElement logo= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.logo));
		if(logo.isDisplayed()) {
			test.info("Logo is Displayed");
		}
		else {
			test.info("Logo is not Displayed");
		}
		WebElement collapse= obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.collapse));
		if(collapse.isDisplayed()) {
			test.info("Collapse button is Displayed");
		}
		else {
			test.info("Collapse button is not Displayed");
		}
		test.pass("In Welcome Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"In Welcome Screen")).build());
        obj.findElement(By.xpath(Login_Locators_Repo.logout_button)).click();
		Thread.sleep(500);
		test.pass("Logout Successfull", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"Logout Successfull")).build());
	 }
		  }
		  obj.quit();
  }
  
  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException, Exception
  {
	  return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
     		    }
}
