package g99IPutilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter

{ 
public  ExtentSparkReporter reporter;
public  ExtentReports extent;
public ExtentTest logger;

 @Override
	public void onStart(ITestContext testContext) {
	 String timestamp= new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String rname=timestamp+".html";

		reporter= new ExtentSparkReporter("target/extent Report"+rname);

		reporter.config().setDocumentTitle("Test reports from tests");
		reporter.config().setReportName("Report for two tests");
		reporter.config().setTheme(Theme.DARK);
		extent= new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Nutan Awasthi");
		
	}

 @Override
	public void onTestSuccess(ITestResult tr) {
	 logger= extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
 @Override
	public void onTestFailure(ITestResult tr) {
	 
		logger= extent.createTest(tr.getName());
		logger.fail("screenshot is Above: ");
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String sspath=(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\screenshot.png");
		logger.addScreenCaptureFromPath(sspath);
		logger.fail(tr.getThrowable());
	
	}
@Override
	public void onTestSkipped(ITestResult ir) {

	logger= extent.createTest(ir.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(ir.getName(), ExtentColor.YELLOW));
	}

	
@Override
	public void onFinish(ITestContext testContext) {
	extent.flush();
	}






}
