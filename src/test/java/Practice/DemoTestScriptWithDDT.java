package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.LoginPage;

public class DemoTestScriptWithDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Utilities classes
				JavaUtility j=new JavaUtility();
				PropertyFileUtility p=new PropertyFileUtility();
				WebDriverUtility w=new WebDriverUtility();
				//IConstantUtility c=new IConstantUtility();
				ExcelFileUtility e=new ExcelFileUtility();
				
		//Step 1 : Launch Browser
	//	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		w.maximiseWindow(driver);
		w.waitForPage(driver);

		String URL = p.getPropertydata("url");
		driver.get(URL);

		
		//Step 2:Login to Application
		
		       String USERNAME = p.getPropertydata("username");
		       String PASSWORD = p.getPropertydata("password");

	
		LoginPage login=new LoginPage(driver);
		login.clickOnLoginButton(USERNAME, PASSWORD);
		
		//Step 3: Navigate to Contacts
		
		ContactPage c=new ContactPage(driver);
		c.createContactButtonClicked();
	//	driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//Click on create Contact Lookup icon image
		
	//	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    	//Step 4: Create Contacts
		
	//	driver.findElement(By.name("firstname")).sendKeys("Aviraj");
	//	driver.findElement(By.name("lastname")).sendKeys("ND");
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
