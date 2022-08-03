package Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.Login_module;

public class Login_Test {

	protected static ExtentReports extent;
	static ExtentSparkReporter htmlReporter;
	 protected static ExtentTest test;
	 static String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());

		static Date date = Calendar.getInstance().getTime();
		static DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		static String strDate = dateFormat.format(date);
	@BeforeTest
    public void Extent_report() {
    	extent =ExtentClass.getinstance();
    }
  @Test
  public void Login_verification() throws Exception {
	  test= extent.createTest("Login Test Cases");
	    test.log(Status.INFO, "Login Test Case with Valid Credentials Started");
	    //test.log(Status.INFO, "Login Test Case with blank Credentials Started");
	    //test.log(Status.INFO, "Login Test Case with Invalid Crdentials Started");
	    Login_module lm=new Login_module();
	  lm.Login_with_valid_credentials();
	  //lm.Login_with_blank_credentials();
	  //lm.Login_with_Invalid_credentials();
	  test.pass("All Login Test Cases are passed");



  }
  @AfterTest
  public void endReport()
  {
	 extent.flush();
  }
}
