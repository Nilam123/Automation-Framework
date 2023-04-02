package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_003_CreateOrganization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Step 1: Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		//Step 2 :Login to Application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		//Step 3:Navigate to organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		//Step 4:create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Testyantra Manglor");
		
		//driver.findElement(By.name("industry")).click();
		
		//Step : Click on Dropdown look up icon
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select ob=new Select(dropDown);
	//	ob.selectByIndex(5);
		ob.selectByVisibleText("Chemicals");
		
		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		
		Select ob2=new Select(typeDropDown);
		//ob2.selectByValue("Customer");
		ob2.selectByIndex(3);
		//Step 6: Save oragnization  
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Step 7: verify
		
		String headarText = driver.findElement(By.xpath("(//span[@class='dvHeaderText'][1])")).getText();
		
		if(headarText.contains("Testyantra"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step : Mouseover on Administrator image
		WebElement administerImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		

		Actions act=new Actions(driver);
		act.moveToElement(administerImage).perform();

		//Step : Click on SignOut
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

		//Step : Close Browser
		driver.close();
		System.out.println("organization created successfully with type and industry selected");
	}

}
