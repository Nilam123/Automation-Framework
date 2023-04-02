package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {

	
	@FindBy(name="firstname")
	private WebElement firstNameTextfield;
	
	
	@FindBy(name="lastname")
	private WebElement lastNameTextfield;
	
	
	@FindBy(name="leadsource")
	private WebElement leadSouceDropdown;
	
	//@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	//private WebElement plusImageAddOrganizationButton;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement plusImageAddOrganizationButton;

	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	@FindBy(id="search_txt")
	private WebElement searchText;
	
	
	@FindBy(name="search")
	private WebElement searchTextButton;
	
	
	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getLeadSouceDropdown() {
		return leadSouceDropdown;
	}

	public WebElement getPlusImageAddOrganizationButton() {
		return plusImageAddOrganizationButton;
	}

	public WebElement getsearchTextButton()
	{
		return searchTextButton;
	}
	
	public WebElement getSearchText()
	{
		return searchText;
	}
	public void getsaveButton()
	{
		saveButton.click();
	}
	//Initiase constructor
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//BusinessLogic
	
	public void createNewContact(String lastName,String firstName,int leadTypeValue)
	{
		firstNameTextfield.sendKeys(firstName);
		lastNameTextfield.sendKeys(lastName);
		handelDropDown(leadSouceDropdown,leadTypeValue);
		plusImageAddOrganizationButton.click();
		saveButton.click();
		
	}
	
	public void createNewContact(WebDriver driver,String orgName,String lastName,String firstName,int leadTypeValue)
	{
		         
		firstNameTextfield.sendKeys(firstName);
		lastNameTextfield.sendKeys(lastName);
		handelDropDown(leadSouceDropdown,leadTypeValue);
		plusImageAddOrganizationButton.click();
			//Step : Click on Organization look up ico

        switchToWindow(driver, "Accounts");
			//Step : Click on Organization look up ico
        searchText.sendKeys(orgName);
			//Step : Click on Organization look up ico

        searchTextButton.click();
         
         driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
         switchToWindow(driver, "Contacts");

 		saveButton.click();

		
	}

	
}
