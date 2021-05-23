package g99IPPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class RequestQuotationPage {
	 WebDriver ldriver;	
	 
	public RequestQuotationPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Request Quotation')]")
	WebElement LnkReqQuote;
	
	public void clickReqQuo() {
		LnkReqQuote.click();	
	}

	@FindBy(id="quotation_breakdowncover")
	WebElement drpdwnBreakdowncover;
	
	public Select getbreakdowncoverOptions() {
	return new Select(drpdwnBreakdowncover);
	}
	
	public void setbreakdowncover(String breakdowncover) {
	getbreakdowncoverOptions().selectByValue(breakdowncover);
	}

	@FindBy(xpath="//input[@name='windscreenrepair' and @value='Yes']")
	WebElement rdYesWindscreenRepair;
	
	@FindBy(xpath="//input[@name='windscreenrepair' and @value='No']")
	WebElement rdNoWindscreenRepair;
	
	public void yesWindscreenRepair() {
	rdYesWindscreenRepair.click();
	}
	public void noWindscreenRepair() {
		rdNoWindscreenRepair.click();
	}
	
	@FindBy(id="quotation_incidents")
	WebElement txtIncidents;
	public void setIncidents(String accidents) {
		txtIncidents.clear();
		txtIncidents.sendKeys(accidents);
	}
	@FindBy(id="quotation_vehicle_attributes_registration")
	WebElement txtregistration;
	public void setregistrationno(String registrationNo) {
		txtregistration.clear();
		txtregistration.sendKeys((registrationNo));
	}
	@FindBy(id="quotation_vehicle_attributes_mileage")
	WebElement txtmileage;
	public void setmileage(String mileage) {
		txtmileage.clear();
		txtmileage.sendKeys((mileage));
	}
	@FindBy(id="quotation_vehicle_attributes_value")
	WebElement txtVehiclevalue;
	public void setVehiclevalue(String estimatedvalue) {
		txtVehiclevalue.clear();
		txtVehiclevalue.sendKeys((estimatedvalue));
	}
	
	@FindBy(name="parkinglocation")
	WebElement drpdwnparkinglocation;
	public Select getparkinglocations() {
		return new Select(drpdwnparkinglocation);
	}
	
	
	@FindBy(name="year")
	WebElement drpdwnyear;
	
	public Select getyear() {
		return new Select(drpdwnyear);
	}
	public void setdrpdwnyear(String year) {
		getyear().selectByValue((year));
	}
	@FindBy(name="month")
	WebElement drpdwnmonth;
	public Select getmonth() {
		return new Select(drpdwnmonth);
	}
	public void setmonth(String month) {
		getmonth().selectByValue((month));
	}
	@FindBy(name="date")
	WebElement drpdwndate;
	public Select getdate() {
		return new Select(drpdwndate);
	}
	public void setdate(String date) {
		getdate().selectByValue((date));
	}
	@FindBy(xpath="//input[@value='Calculate Premium']")
	WebElement btnCalculatePremium;
	public void clickCalculatePremium() {
		btnCalculatePremium.click();
	}

	
	@FindBy(name="submit")
	WebElement btnSaveQuotes;
	
	public void saveQuotations() {
		btnSaveQuotes.click();
	}
	
	@FindBy(css= "#calculatedpremium")
	WebElement txtbxcalculatedpremium;
	
	public String premiumResult() {
		String res= txtbxcalculatedpremium.getText();
	return res;
	}

	public void setdrpdwnparkinglocation(String parkingLocation) {
		getparkinglocations().selectByValue(parkingLocation);
		
	}

	public void setIncidents(int accidents) {
		txtIncidents.clear();
		txtIncidents.sendKeys(String.valueOf(accidents));	
		
	}

	public void setregistrationno(int reg) {
		txtregistration.clear();
		txtregistration.sendKeys(String.valueOf(reg));
		
	}

	public void setmileage(int mileage) {
		txtmileage.clear();
		txtmileage.sendKeys(String.valueOf(mileage));
		
	}

	public void setVehiclevalue(int val) {
		txtVehiclevalue.clear();
		txtVehiclevalue.sendKeys(String.valueOf(val));
	}

	public void setdrpdwnparkinglocation(int loc) {
		
		getparkinglocations().selectByIndex(loc);
	}

	public void setdrpdwnyear(int year) {
		getyear().selectByIndex(year);
		
	}

	public void setmonth(int month) {
		getmonth().selectByIndex((month));
		
	}

	public void setdate(int date) {
		
		getdate().selectByIndex((date));
	}


}
