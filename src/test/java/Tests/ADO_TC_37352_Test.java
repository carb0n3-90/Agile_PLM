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

import Pages.ADO_TC_37352;

public class ADO_TC_37352_Test {
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
  public void ADO_TC_37352() throws Exception {
	  test= extent.createTest("Search functionality Verification and Validations");
		test.log(Status.INFO, "ADO_TC_37352 Test Case Started");
		ADO_TC_37352 at= new ADO_TC_37352();
		at.search_functionality();
		test.log(Status.INFO, "ADO_TC_37352 Test Case Completed and Passed");
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
  }
