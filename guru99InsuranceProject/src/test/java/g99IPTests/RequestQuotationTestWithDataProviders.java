package g99IPTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import g99IPPageObjects.RequestQuotationPage;
import g99IPutilities.XLUtils;

public class RequestQuotationTestWithDataProviders extends BaseClass {
	XLUtils xlu;
	RequestQuotationPage rt= new RequestQuotationPage(driver);
	
	@Test(priority=1)
	public void clickpro() {
		driver.get(url2);
		
		rt.clickReqQuo();
	}
	
	@Test(dataProvider="InsuranceData")
	public void ReuestQuotaiontest2( String Breakdowncover,String windshieldrepair,String accidents,String registrationNo, String mileage, String estimatedvalue,String ParkingLocation, String Year, String Month, String Date, String ExpResult) throws IOException {

		clickpro();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		rt.setbreakdowncover(Breakdowncover);
		
		if(windshieldrepair.equalsIgnoreCase("yes")) {
				rt.yesWindscreenRepair();	
			}
			else if(windshieldrepair.equalsIgnoreCase("no")) {
				rt.noWindscreenRepair();	
			}
		
		rt.setIncidents(accidents);

		rt.setregistrationno(registrationNo);

		rt.setmileage(mileage);

		rt.setVehiclevalue(estimatedvalue);
		
		rt.setdrpdwnparkinglocation(ParkingLocation);

		rt.setdrpdwnyear(Year);

		rt.setmonth(Month);

		rt.setdate(Date);
		
		String ExResult= ExpResult;
		
		rt.clickCalculatePremium();
		
		String actualresult=rt.premiumResult();	
		System.out.println(rt.premiumResult());
		System.out.println(ExResult);
		System.out.println("compare: "+ExResult+"to actual:"+actualresult);
	}
	@DataProvider(name="InsuranceData")
	public Object[][] getData() throws IOException{
		
		String path="C:\\Users\\Nutan\\eclipse-workspace2\\guru99InsuranceProject\\src\\test\\java\\g99IPTestdata\\Book1.xlsx";
		
		xlu=new XLUtils(path);
		
//		int rownum=xlu.getRowNum("Sheet1");
//		int colnum=xlu.getcolNum("Sheet1",rownum);
		
		int rownum=11;
		int colnum=11;
		
		
		Object[][] data= new Object[rownum-1][colnum];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colnum;j++) {
				data[i-1][j]=xlu.readDataFromExcel("Sheet1", i, j);
			}
		}
		return data;
	}
	
}
	

