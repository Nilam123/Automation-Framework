package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_004_CreateOrganization_SelectTypeAndIndutsry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Step 1 : Launch Browser
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://localhost:8888/");

		
		//Step 2:Login to Application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Step 3: Navigate to HOme page NA
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Step 4: click on add look up icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		driver.findElement(By.name("accountname")).sendKeys("CRM P");
		WebElement dropDodwn = driver.findElement(By.name("industry"));
		
		//Step 5: Select industry type energy
		Select s1=new Select(dropDodwn);
		s1.selectByVisibleText("Energy");
		
		//Step 6: Select industry type Type

		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		
		Select s2=new Select(typeDropDown);
		s2.selectByVisibleText("Customer");
		
		//Step 7: Save and Verify
		
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'][1])")).click();

		

		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(headerText.contains("CRM Pune"))
		{
			System.out.println("PAss");
		}
		else
		{
			System.out.println("Fail");
		}
		
//Step 8 : Log OUt
		
		WebElement administrationImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(administrationImage).perform();
		
		//Step : Click on SignOut
				
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	//Step : Close Browser
	driver.close();
	System.out.println("organization created successfully with type and industry selected");
		
	}

}

