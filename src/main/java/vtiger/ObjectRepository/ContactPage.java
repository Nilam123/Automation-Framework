package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactButton;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement createContact;
	
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	
	
	public WebElement getCreateContact() 
	{
		return createContact;
	}
	
	public void createContactButtonClicked()
	{
		createContactButton.click();
	}
}
