package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.IConstantUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class TC_001_CreateOrganizationWithUtilities {

	public static void main(String[] args) throws IOException {
		
		
		//Utilities classes
		JavaUtility j=new JavaUtility();
		PropertyFileUtility p=new PropertyFileUtility();
		WebDriverUtility w=new WebDriverUtility();
		//IConstantUtility c=new IConstantUtility();
		ExcelFileUtility e=new ExcelFileUtility();
		
		//Step 1: Launch the browser
		WebDriver driver=new ChromeDriver();
		w.miniMizeWindow(driver);
		w.waitForPage(driver);
		
		String URL1=p.getPropertydata("url");
		System.out.println(URL1);
		
		driver.get(URL1);
		//Step 2 :Login to Application
		
		
		//Take username and password from properties file
		
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step 3:Navigate to organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		//Step 4:create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		String  orgName=(e.readDataFromExcelSheet("Oraganizations", 1, 2))+w.randomNumber();
		
		//orgName+w.randomNumber();
		System.out.println(orgName);
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		//Step 6: Save oragnization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		
		//Step 7: Save and Verification for organization
				String organizationHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(organizationHeader.contains(orgName))
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("Fail");
				}
				
				
				
		//Step 8:Log out
				
				//Action
		WebElement ele =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
		w.moveToelementAction(driver, ele);	
        driver.findElement(By.linkText("Sign Out")).click();			
		System.out.println("Organization created successfully");
		driver.close();
		
	}

	}
