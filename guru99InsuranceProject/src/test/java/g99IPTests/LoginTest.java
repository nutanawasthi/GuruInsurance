package g99IPTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import g99IPPageObjects.LoginPage;

public class LoginTest extends BaseClass{

	@Test
	public void logIn() throws IOException {
		driver.get(url);
		LoginPage lp= new LoginPage(driver);
		
		String actualTitle;
		String Expectedtitle="Insurance Broker System";
		
		
		lp.setEmail(email);
		//loggerbase.pass("entered valid email");
		lp.setPassword(password);
		//loggerbase.pass("entering right password");
		//loggerbase.fail("entering wrong password");
		lp.clicksubmit();
		
		actualTitle=driver.getTitle();
		if(actualTitle.equalsIgnoreCase(Expectedtitle)) {
			System.out.println("screenshot not created as page is same as expected");
		}else
		{
			Assert.assertEquals(actualTitle,Expectedtitle);
			getMyScreenShotPath();
			
			}
		
	
		
	}
	
	
	
}
