package g99IPTests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import g99IPutilities.Readconfig;
import g99IPutilities.Reporting;

public class BaseClass {
	WebDriver driver;
	Readconfig rf;
	public String url;
	public String url2;
	public String email;
	public String password;

	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Nutan\\eclipse-workspace2\\guru99InsuranceProject\\driver\\chromedriver.exe");
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		rf= new Readconfig();
		email=rf.getemail();
		password= rf.getPassword();	
		url=rf.geturl();
		url2=rf.geturl2();

	}

	public void getMyScreenShotPath() throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String  destfile= System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots"+"\\screenshot.png";
		File dest= new File(destfile);
		
		FileUtils.copyFile(src, dest);
		System.out.println("screenshot taking.....");
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
