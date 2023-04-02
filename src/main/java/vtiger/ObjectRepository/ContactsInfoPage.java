package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement getHeaderText;
	
	
	
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//initialise getters and setters
	
	public WebElement getHeaderText()
	{
		return getHeaderText;
	}
	
	
	public String getContactHeaderText()
	{
		
		return getHeaderText.getText();
	}
	
}
