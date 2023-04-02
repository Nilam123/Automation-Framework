package vtiger.ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateCampaignsPage extends WebDriverUtility {

	@FindBy(name="campaignname")
	private WebElement campaignnameTextfield;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement plusButtonSelectProduct;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="search_txt")
	
	private WebElement searchText;
	
	
	@FindBy(name="search")
	private WebElement searchTextButton;
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchTextButton() {
		return searchTextButton;
	}

	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getsaveButton()
	{
		return saveButton;
	}
	
	public WebElement getplusButtonSelectProduct()
	{
		return plusButtonSelectProduct;
	}
	
	public WebElement getCampaignnameTextfield()
	{
		return campaignnameTextfield;
	}
	//Business Logic
	
	
	/**
	 * 
	 * @param driver
	 * @param campaignName
	 * @param productName
	 * @throws InterruptedException 
	 */
	public void createCampaigns(WebDriver driver,String campaignName,String productName) throws InterruptedException
	{
		Alert alert=driver.switchTo().alert();
		String data = alert.getText();
		System.out.println(data);
		alert.accept();
		System.out.println("in page passed "+campaignName);
		campaignnameTextfield.sendKeys(campaignName);
		
		plusButtonSelectProduct.click();
		
	
		switchToWindow(driver,"Products");
		 
		System.out.println("productName POM value--"+productName);
		searchText.sendKeys(productName);
			//Step : Click on Organization look up ico
       // Thread.sleep(2000);
        searchTextButton.click();
        driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();


		switchToWindow(driver,"Campaigns");

		saveButton.click();
	}
/**
 * 
 * @param campaignName
 */
	public void createCampaignsMethod(WebDriver driver,String campaignName) {
		
		System.out.println("in page passed "+campaignName);
	
		Alert alert=driver.switchTo().alert();
		String data = alert.getText();
		System.out.println(data);
		alert.accept();
		
		
		campaignnameTextfield.sendKeys(campaignName);
	    saveButton.click();
	}

	
}
