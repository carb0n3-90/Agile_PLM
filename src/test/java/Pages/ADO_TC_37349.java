package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Locators.ADO_TC_37348_Locators_Repo;
import Locators.ADO_TC_37349_Locators_Repo;
import Locators.Login_Locators_Repo;
import Tests.ADO_TC_37349_Test;

public class ADO_TC_37349 extends ADO_TC_37349_Test {

	@Test
	public void Create_New_Item() throws Exception {
	
		FileInputStream fis=new FileInputStream("C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Excels\\Login_Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\BhamiSa\\eclipse-workspace\\AgilePLM\\Drivers\\geckodriver.exe");
		WebDriver obj = new FirefoxDriver();
		test= extent.createTest("Create New Item Verification and Validations");
		test.log(Status.INFO, "ADO_TC_37349 Test Case Started");
		XSSFCell url= sh.getRow(1).getCell(0);
		obj.get(url.getStringCellValue());
		test.pass("ADO_TC_37349 Test Case Started", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj, "ADO_TC_37349 Test Case Started")).build());
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
		obj.findElement(By.xpath(ADO_TC_37348_Locators_Repo.create_new)).click();
		Thread.sleep(500);
		WebElement items=obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.items));
		items.click();
		WebElement parts=obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.parts));
		JavascriptExecutor js = (JavascriptExecutor) obj;
		js.executeScript("arguments[0].click();", parts);
		Thread.sleep(1000);
		ArrayList<String> popup_windows= new ArrayList<String>(obj.getWindowHandles());
	    Thread.sleep(1000);
		obj.switchTo().window(popup_windows.get(2));
		test.pass("In Create New Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"In Create New Screen")).build());
		String create_new_popup= obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.create_new_popup)).getText();
		test.info("Create New Popup Header is displayed as--"+create_new_popup);
		test.info("Displayed Create New popup Header is--"+create_new_popup.equalsIgnoreCase("Create New"));
		String popup_note= obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.pop_up_note)).getText();
		test.info("Popup note is displayed as--"+popup_note);
		String type_label=obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.type_label)).getText();
		test.info("Label of Type is displayed as--"+type_label);
		test.info("Displayed Type Label is--"+type_label.equalsIgnoreCase("Type:"));
		Select select= new Select(obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.type_dropdown)));
		select.selectByValue("2471703");
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.description)).sendKeys("Test Automation");
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.packaging_comp_category)).click();
		Thread.sleep(500);
		Actions act= new Actions(obj);
		int min=1;
		int max=12;
		int rand= (int)(Math.random()* (max-min+1)+min);
		System.out.println(rand);
		WebElement toggle= obj.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div["+rand+"]/div[1]/div[1]/span[1]"));
	    toggle.click();								 
	    WebElement product= obj.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div["+rand+"]/div[1]"));
	    Thread.sleep(500);							  
	    String product_name_space= product.getText();
	    String product_name= product_name_space.trim();
	    System.out.println(product_name);
	    if(product_name.equalsIgnoreCase("Adhesives")) 
	    {
	    	int a=3,b=4;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	Thread.sleep(1000);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Cans")) {
	    	int a=6,b=7;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	Thread.sleep(1000);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Closures & Fitments")) {
	    	int a=9,b=12;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Corrugated")) {
	    	int a=14,b=26;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Films and Labels")) {
	    	int a=28,b=31;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Other Packaging")) {
	    	int a=57,b=63;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Paperboard")) {
	    	int a=65,b=72;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    	}
	    else if(product_name.equalsIgnoreCase("Plastic Bottle and Container")) {
	    	int a=74,b=81;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Sprayers & Dispensing Systems")) {
	    	int a=83,b=90;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Stainless Steel Container")) {
	    	int a=92,b=93;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Thermoform")) {
	    	int a=95,b=99;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else if(product_name.equalsIgnoreCase("Tube")) {
	    	int a=101,b=102;
	    	int r=(int)(Math.random()* (b-a+1)+a);
	    	System.out.println(r);
	    	WebElement item= obj.findElement(By.xpath("//a[@id='agileTreeNodeLink"+r+"']"));
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	act.doubleClick(item).build().perform();
	    }
	    else {
	    	WebElement item=obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.na));
	    	js.executeScript("arguments[0].scrollIntoView();", item);
	    	Thread.sleep(1000);
	    	act.doubleClick(item).build().perform();
	    }
	    Thread.sleep(1000);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.close_list)).click();
		Thread.sleep(1000);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.brand)).click();
		Thread.sleep(500);
		WebElement baking_soda=obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.baking_soda));
		js.executeScript("arguments[0].scrollIntoView();", baking_soda);
		Thread.sleep(500);
		act.moveToElement(baking_soda).build().perform();
		Thread.sleep(1000);
		((JavascriptExecutor)obj).executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",baking_soda);
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.close_brand)).click();
		Thread.sleep(1000);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.sub_brand)).click();
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.list_of_subBrand)).click();
		Thread.sleep(500);
		WebElement predictor=obj.findElement(By.linkText(ADO_TC_37349_Locators_Repo.predictor));
		js.executeScript("arguments[0].scrollIntoView();", predictor);
		act.doubleClick(predictor).build().perform();
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.close_subBrand)).click();
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.variant)).sendKeys("Test Automation");
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.size)).sendKeys("10");
		Thread.sleep(500);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.add_description)).sendKeys("Test Automation");
		Thread.sleep(500);
		Select material_type= new Select(obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.material_type)));
		material_type.selectByVisibleText("Packaging Material");
		Thread.sleep(800);
		test.pass("All the mandatory fields are filled", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"All the mandatory fields are filled")).build());
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.save)).click();
		Thread.sleep(800);
		obj.switchTo().window(popup_windows.get(1));
		test.pass("ID is generated after saving the Parts section", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(obj,"ID is generated after saving the Parts section")).build());
		Thread.sleep(800);
		obj.findElement(By.xpath(ADO_TC_37349_Locators_Repo.msg_save)).click();
		Thread.sleep(1000);
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
