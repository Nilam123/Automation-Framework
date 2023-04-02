package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductButton;
	
	
	//initialise constructor
	
	public ProductsPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver
				, this);
	}
	
	//getter and setters
	
	
	public WebElement getcreateProductButton()
	{
		return createProductButton;
	}
	/**
	 * This method is used to click the create product button
	 * Author - Nilam
	 */
	public void createProductButtonClicked()
	{
		createProductButton.click();
	}
	
	}
