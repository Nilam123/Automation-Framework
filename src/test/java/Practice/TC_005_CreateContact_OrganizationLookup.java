package Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_005_CreateContact_OrganizationLookup {

	public static void main(String[] args) throws InterruptedException {
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
				
				//Step 3: Navigate to Contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();

				//Click on create Contact Lookup icon image
				
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	        	//Step 4: Create Contacts
				
				driver.findElement(By.name("firstname")).sendKeys("Aviraj");
				driver.findElement(By.name("lastname")).sendKeys("ND");
				
				//Step 5:select Organization
				
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
				
			//	String singleWindow = driver.getWindowHandle();
				//System.out.println("PArent window handles"+singleWindow);
				///driver.findElement(By.name("search_text")).sendKeys("avi");
				//Step 6:Select organization name from organization name
				
				
				String parentWindow = driver.getWindowHandle();
				System.out.println("parentWindow browser"+parentWindow);

				//to get address of parent and child browswer
				Set<String> allWindowHandels = driver.getWindowHandles();
				System.out.println("allWindowHandels browser"+allWindowHandels);
				
				for(String currentWindow:allWindowHandels)
				{
					System.out.println("Current Window handle"+currentWindow);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//tr[@class='lvtColData']/../tr[1]//td[1]//a[text()='Pizza814']")).click();
					if(currentWindow.equalsIgnoreCase(parentWindow))
					{
						driver.switchTo().window(currentWindow);
						Thread.sleep(3000);
						driver.findElement(By.xpath("//tr[@class='lvtColData']/../tr[1]//td[1]//a[text()='Pizza814']"));
					///	String selectedOrganization = driver.findElement(By.xpath("//a[text()='Pizza814']")).getText();
						//System.out.println(selectedOrganization);
						//driver.switchTo().window(parentWindow);

						//driver.close();
					}
					
				}
				
				//a[text()='Pizza814']
			driver.close();
				//to get parent browser
			//	driver.switchTo().newWindow(WindowType.TAB);
				
			//	driver.navigate().to("http://localhost:8888/");
			//	driver.quit();
				
//				WebElement orgnizationName = driver.findElement(By.name("search_field"));
//				
//				Select s1=new Select(orgnizationName);
//				//s1.selectByVisibleText("Phone");
//				s1.selectByIndex(3);
//				s1.selectByValue("Phone");
				//String selectedOrganizationName = driver.findElement(By.xpath("//a[text()='Pizza814']")).getText();
				
				//System.out.println(selectedOrganizationName);
				//driver.switchTo().defaultContent();

			//	Set<String> child=driver.getWindowHandles();
			//	Iterator<String> i1 = child.iterator();
				
//				while(i1.hasNext())
//				{
//					String childWindow=i1.next();
//					driver.switchTo().window(childWindow);
//
//				}
//				for(String b:child)
//				{
//					driver.switchTo().window(b);
//					System.out.println("Window changed");
//				}

	}

}
