package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

//	WebDriver driver;

	
	//Step 1: create POM class for every web pages
	
	//step 2: identify web elements
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactButton;
	
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationButton;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productButton;
	
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreButton;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutButton;
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement compaignsButton;
	//Step : initialise Constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step : creating Setters And Getters Method
	public WebElement getadministratorImage()
	{
		return administratorImage;
		
	}
	
	public void compaignsButtonClicked()
	{
		compaignsButton.click();
	}
	
	/**
	 * This is used for to click contact button
	 */
	public void contactButtonClicked()
	{
		contactButton.click();
	}
	/**
	 * 
	 */
	
	/**
	 * Product button clicked
	 * Author -Nilam
	 */
	public void productButtonClicked()
	{
		productButton.click();
	}
	public void logoutOfApp(WebDriver driver)
	{
	//	mouseHoverAction(driver,administratorImage);
		moveToelementAction(driver,administratorImage);
		
		signOutButton.click();
	}
	
	public void organizationButtonClicked()
	{
		organizationButton.click();
	}
	//Business Login
	
	//public void signOut(St)
}
