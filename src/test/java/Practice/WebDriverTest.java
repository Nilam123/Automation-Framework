package Practice;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WebDriverTest {
@Test

public void WebDriverTestScript() throws InterruptedException
{
	WebDriverManager.firefoxdriver().setup();
	
	
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.instagram.com/");
	//Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys("7385960369");
	driver.findElement(By.name("password")).sendKeys("aviraj@123");
	
	//click on login
	//Thread.sleep(3000);
	//driver.findElement(By.xpath("(//div[contains(@class,'_ab8w')])[4]")).click();
	//driver.findElements(By.tagName(""))
	
	String title=driver.getTitle();
	System.out.println("Title is "+title);
	
    String currentUrl=	driver.getCurrentUrl();
	System.out.println("currentUrl is "+currentUrl);
	
	
	if(title.equals(currentUrl))
	{
		System.out.println("Home page");
	}
	else
	{
		System.out.println("failed to login Check your username & Password ");

	}		

	
	
	
}
}

