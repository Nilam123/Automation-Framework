package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consistes of basic configuration of TestNG
 * @author Nilam
 *
 */
public class BaseClass {
	//Utilities classes
	public JavaUtility javaUtility=new JavaUtility();
	public PropertyFileUtility propertyUtility=new PropertyFileUtility();
	public WebDriverUtility webdriverUtility=new WebDriverUtility();
	public ExcelFileUtility excelUtility=new ExcelFileUtility();
    public static WebDriver sDriver;// only for listeners

	public WebDriver driver;
    
    
	
	@BeforeSuite (groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("@BeforeSuite-------------Database Connection Successfull---------------------");
	}

	@BeforeClass (groups={"SmokeSuite","RegressionSuite"})
	
	public void bcConfig() throws IOException
	{
		String URL = propertyUtility.getPropertydata("url");
		String BROWSER = propertyUtility.getPropertydata("browser"); 

		// Step 2: Launch the browser - runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",  "C:\\Users\\91840\\.m2\\repository\\webdriver\\chromedriver\\win32\\111.0.5563.64\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
			System.out.println("@BeforeClass----------------"+BROWSER+"launched-----------------");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			//ChromeOptions ops=new ChromeOptions();
			
			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\91840\\.m2\\repository\\webdriver\\geckodriver\\win64\\0.31.0\\geckodriver.exe");

		WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			System.out.println("@BeforeClass----------------"+BROWSER+"launched-----------------");
		}
			else if(BROWSER.equals("opera"))
			{
				WebDriverManager.operadriver().setup();
				
				driver= new OperaDriver();
			}
		 else {
			System.out.println("Invalid Browser name");
		}
		sDriver=driver;
		webdriverUtility.maximiseWindow(driver);
		webdriverUtility.waitForPage(driver);	
		driver.get(URL);

	}
	
	@BeforeMethod (groups={"SmokeSuite","RegressionSuite"})
	
	public void bmConfigu() throws IOException
	{
		String USERNAME = propertyUtility.getPropertydata("username");
		String PASSWORD = propertyUtility.getPropertydata("password");		
		LoginPage login=new LoginPage(driver);
		login.clickOnLoginButton(USERNAME, PASSWORD);
		System.out.println("@BeforeMethod----------------Login Successfull -----------------");

	}
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfigu()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("@AfterMethod----------------Login Out Successfull -----------------");

	}
	
	@AfterClass (groups={"SmokeSuite","RegressionSuite"})
	
	public void acConfig()
	{
		driver.quit();
		System.out.println("@AfterClass----------------Browser Closed SuccessFully-----------------");

	}
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("-@AfterSuite------------Database Connection Closed Successfull---------------------");

	}
}

