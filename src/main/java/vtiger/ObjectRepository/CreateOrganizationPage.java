package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {

	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(name="website")
	private WebElement websiteName;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	
	//Create Constructor
	
	public CreateOrganizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	//setters AND Getters
	
	public void industryDropDown()
	{
		handelDropDown(industryDropDown, 5);
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public void setIndustryDropDown(WebElement industryDropDown) {
		this.industryDropDown = industryDropDown;
	}


	public WebElement getOrganizationName() {
		return organizationName;
	}


public void getSaveButtonClicked()
{
	saveButton.click();
}

	public void setOrganizationName(WebElement organizationName) {
		this.organizationName = organizationName;
	}

	public WebElement getWebsiteName() {
		return websiteName;
	}
	
	//Business Logics or Libraries
	
	/**
	 * 
	 * @param orgName
	 */
	public void createOrganization(String orgName)
	{
		organizationName.sendKeys(orgName);
		//w.handelDropDown(industryDropDown, 5);
		saveButton.click();
	}
	/**
	 * 
	 * @param orgName
	 * @param industryType
	 */
	public void createOrganization(String orgName,String industryType)//String industryType
	{
		this.organizationName.sendKeys(orgName);
		handelDropDown(industryDropDown, industryType);
		saveButton.click();
	}
	/**
	 * 
	 * @param orgName
	 * @param industryType
	 */
	public void createOrganization(String orgName,String industryType,String Type)//String industryType
	{
		this.organizationName.sendKeys(orgName);
		handelDropDown(industryDropDown, industryType);
		handelDropDown(typeDropDown,Type);
		saveButton.click();
	}
}
