package Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentClass {
	static Date date = Calendar.getInstance().getTime();  
    static DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm");  
   static String strDate = dateFormat.format(date);  

 
   static ExtentReports extent;
 static ExtentSparkReporter htmlReporter;
  
   ExtentTest test;
	public static ExtentReports getinstance()
	{
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "./Reports/AgilePLM_Application_" + strDate + ".html");
		extent = new ExtentReports();// 2nd line
		extent.attachReporter(htmlReporter);// 3rd line order is must
		extent.setReportUsesManualConfiguration(false);
		// extent = new ExtentReports(htmlReporter, false);
		extent.setSystemInfo("Host Name", "AgilePLM");
		extent.setSystemInfo("Environment", "Automation Script");
		extent.setSystemInfo("User Name", "QA");
		htmlReporter.config().setDocumentTitle("AgilePLM Automation Script Report");
		htmlReporter.config().setReportName("AgilePLM  Test Report");
		htmlReporter.config().setTheme(Theme.DARK);

	return extent;	
	}

}

