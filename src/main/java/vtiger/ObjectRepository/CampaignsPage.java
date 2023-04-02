package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	

	
	
	//initialise constructor
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Getter and setters method
	
	
	public WebElement getCreateCampaignButton()
	{
		return createCampaignButton;
	}
	
	
	//Business Logic
	public void createCampaignButtonClicked()
	{
		createCampaignButton.click();
		saveButton.click();
		
	}
}
