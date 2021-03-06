package db;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CreateLead {

	public static void main(String[] args) {
		
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TL");
		driver.findElementById("createLeadForm_firstName").sendKeys("Raj");
		driver.findElementById("createLeadForm_lastName").sendKeys("T");
		driver.findElementByName("submitButton").click();
		String leadName = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(leadName);
		
		String leadID = leadName.split("\\(")[1];
		leadID = leadID.split("\\)")[0];
		System.out.println(leadID);
		
		DbMethods db = new DbMethods();
		db.verifyDBResults(leadID);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
