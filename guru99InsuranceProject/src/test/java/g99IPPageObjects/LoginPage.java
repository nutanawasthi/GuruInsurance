package g99IPPageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import g99IPutilities.Readconfig;

public class LoginPage {
	WebDriver ldriver;
	Readconfig rf;
	
	public LoginPage(WebDriver rdriver) throws IOException {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
		
	}
	
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="submit")
	WebElement btnsubmit;
	
	public String setUrl(String url) {
		return url;
	}
	
	
public void setPassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
public void clicksubmit() {
	btnsubmit.click();
}
public void setEmail(String email) {
	txtemail.clear();
	txtemail.sendKeys(email);
	
}
}
