package Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.ADO_TC_37348;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ADO_TC_37348_Test {
	//https://dev.azure.com/ChurchDwight/Validated/_workitems/edit/37348
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
	public void ADO_TC_37348() throws Exception {
		test= extent.createTest("Home Page Verification and Validations");
		test.log(Status.INFO, "ADO_TC_37348 Test Case Started");
		ADO_TC_37348 at= new ADO_TC_37348();
		at.Home_Page();
		test.log(Status.INFO, "ADO_TC_37348 Test Case Completed and Passed");
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
}
