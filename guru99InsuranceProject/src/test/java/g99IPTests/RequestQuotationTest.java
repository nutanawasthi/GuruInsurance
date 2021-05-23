package g99IPTests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import g99IPPageObjects.RequestQuotationPage;

public class RequestQuotationTest extends BaseClass {
	
	
	
	
	@Parameters({"Windscreen","Accidents","reg","mileage","val","loc","year","month","date"})
	@Test(enabled = false)
	public void ReuestQuotaiontest2(boolean Windscreen, int Accidents, int reg, int mileage, int val,int loc, int year, int month, int date) throws IOException {

		
		driver.get(url2);
		RequestQuotationPage rt= new RequestQuotationPage(driver);
		rt.clickReqQuo();


		//rp.extent.createTest("find flight Test");
		    
		//rt.setbreakdowncover("No cover");
//		test2.pass("entered  No cover");
		if(Windscreen== true) {
				rt.yesWindscreenRepair();
				//test2.pass("windscreen selected");
			}
			else if(Windscreen== false){
				rt.noWindscreenRepair();
				//test2.pass("no windscreen selected");
			}
		
		rt.setIncidents(Accidents);
//		test2.pass("Accidents selected: "+Accidents);
		
		rt.setregistrationno(reg);
//		test2.pass("registration No given: "+reg);
		rt.setmileage(mileage);
//		test2.pass("mileage given: "+mileage);
		rt.setVehiclevalue(val);
//		test2.pass("Value of vehicle given: "+val);
//		
		rt.setdrpdwnparkinglocation(loc);
//		test2.pass("Location selected: "+loc);
		rt.setdrpdwnyear(year);
//		test2.pass("year selected: "+year);
		rt.setmonth(month);
//		test2.pass("month selected: "+month);
		rt.setdate(date);
//		test2.pass("date selected: "+date);
		rt.clickCalculatePremium();
//		test2.pass("premium calcualted ");
		
			
	}
	
}
	

