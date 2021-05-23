package g99IPutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Readconfig {
	
	Properties pro;
	
	
	public Readconfig() throws IOException {
		File f= new File("C:\\Users\\Nutan\\eclipse-workspace2\\guru99InsuranceProject\\src\\test\\java\\g99IPutilities\\config.properties");

		FileInputStream fi= new FileInputStream(f);
		pro= new Properties();
		 pro.load(fi);
		
	}
	
	public String geturl() {
		String proString=pro.getProperty("url");
		return proString;
	}
	public String geturl2() {
		String abc=pro.getProperty("url2");
		return abc;
	}
	public String getemail() {
		String a=pro.getProperty("email");
		return a;
	}
	public String getPassword() {
		String a=pro.getProperty("password");
		return a;
	}
	public String getchromePath() {
		String a=pro.getProperty("chromepath");
		return a;
	}
public String getfirefoxPath() {
	String a=pro.getProperty("firefoxpath");
	return a;
	}
public String getedgePath() {
	String a=pro.getProperty("edgepath");
	return a;
}
}
