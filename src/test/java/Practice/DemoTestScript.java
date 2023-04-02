package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.IConstantUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.LoginPage;

public class DemoTestScript {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//Utilities classes
		JavaUtility j=new JavaUtility();
		PropertyFileUtility p=new PropertyFileUtility();
		WebDriverUtility w=new WebDriverUtility();
		//IConstantUtility c=new IConstantUtility();
		ExcelFileUtility e=new ExcelFileUtility();
		
		//Step 1: Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		w.miniMizeWindow(driver);
		w.waitForPage(driver);
		
		String URL1=p.getPropertydata("url");
		System.out.println(URL1);
		
		driver.get(URL1);
		//Step 2 :Login to Application
				
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(URL);
		
		LoginPage login=new LoginPage(driver);
		login.clickOnLoginButton(USERNAME, PASSWORD);
		
		driver.close();
		

		//Step 3:Navigate to Home Page

		
	}

}
