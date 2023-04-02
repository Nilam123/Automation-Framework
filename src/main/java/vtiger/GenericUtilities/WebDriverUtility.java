package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**
	 * 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void miniMizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void waitForPage(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This method will handel dropdwon based with index
	 * @param element
	 * @param index
	 */
	public void handelDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handel dropdwon based on value
	 * @param element
	 * @param value
	 */
	public void handelDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);

		
	}
	/**
	 * This method will handel dropdwon based on visibleText
	 * @param text
	 * @param element
	 */
	
	
	public void handelDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void moveToelementAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver)	;
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method will moushover based on rightClick
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver)	;
		act.contextClick().perform();
	}
	/**
	 * This method will doubleClick  on element
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver)	;
		act.doubleClick().perform();
	}
	/**
	 * This method will double click on perticular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver)	;
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method dragAndDropAction with source element to destination element
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement dstElement)
	{
		Actions act=new Actions(driver)	;
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	/**
	 * This method handel accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method handel dismiss alert
	 * @param driver
	 */
	public void dismisstAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method get alertText
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method handelFrame with index
	 * @param driver
	 * @param index
	 */
	public void handelFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(0);
	}
	/**
	 * This method handelFrame with name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void handelFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method handelFrame based on  web element
	 * @param driver
	 * @param nameOrId
	 */
	public void handelFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is switching window parent to frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is switching window default frame
	 * @param driver
	 */
	
	public void switchTodefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Step 1:Capture all the window Ids
		Set<String> winIDs = driver.getWindowHandles();
		
		//Step 2:Navigate to each window
		
		for(String windowC:winIDs)
		{
		//	Step 3: switch to window and capture the title
			
			String winTitle=driver.switchTo().window(windowC).getTitle();
			
			//Step 4:compare the title with required partial title()
					
			if(winTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}

	
	/**
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		
	}
	
	
	public int randomNumber()
	{
	Random ranNumber=new Random();
	int r=ranNumber.nextInt();
	return r;	
	}
	/**
	 * This method will take screen shot and save it in folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	
{
	System.out.println("takeScreenShot called>>>>>>>>>>>>>>>>. ");
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\ScreenShots\\"+screenShotName+".png");
	FileUtils.copyFile(src,dst);
	System.out.println("getAbsolutePath---------"+dst.getAbsolutePath());
	
	return dst.getAbsolutePath();

	
	}
}

