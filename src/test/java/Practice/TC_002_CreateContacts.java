package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class TC_002_CreateContacts {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//Step 1: Login to Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://localhost:8888/");
		
		//Step 2 :Login to Application
		
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
		
		
				//Step 3: Navigate to Contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();

				//Click on create Contact Lookup icon image
				
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	        	//Step 4: Create Contacts
				
				driver.findElement(By.name("firstname")).sendKeys("Aviraj");
				driver.findElement(By.name("lastname")).sendKeys("ND");
				
				//Step : Click on Organization look up icon
				Thread.sleep(1000);
				
				//Step : Click on Dropdown look up icon
				WebElement dropDown = driver.findElement(By.name("leadsource"));
				Select ob=new Select(dropDown);
				ob.selectByIndex(5);
				//Step : Enter on Asociates text
				driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[8]")).sendKeys("RD Ascosiates");
				
				//Step : Click on save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				

				//Step : Verify
				
				String organizationHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(organizationHeader.contains("Aviraj "))
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("Fail");
				}
				//Step : Mouseover on Administrator image
				WebElement administerImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				

				Actions act=new Actions(driver);
				act.moveToElement(administerImage).perform();

				//Step : Click on SignOut
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				

				//Step : Close Browser
				driver.close();
				System.out.println("Contact created successfully");
		
	}

}
