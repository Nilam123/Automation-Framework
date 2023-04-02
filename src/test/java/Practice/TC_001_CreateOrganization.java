package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_001_CreateOrganization {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub

		//Step 1: Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		//Step 2 :Login to Application
		
		
		//Take username and password from properties file
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
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
		driver.findElement(By.name("accountname")).sendKeys("Qspider P");
		//Step 6: Save oragnization
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		
		//Step 7:Log out
			
			//Action
		WebElement ele =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		
		//Step 6: Save and Verification for organization
				//span[@class='dvHeaderText']
				String organizationHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(organizationHeader.contains("Qspider P"))
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("Fail");
				}
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		System.out.println("Organization created successfully");
		
	}

}
