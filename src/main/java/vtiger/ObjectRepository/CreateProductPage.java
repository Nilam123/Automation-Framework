package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	@FindBy (xpath="//a[text()='More']")
	private WebElement moreButton;
	
	@FindBy (name="productcode")
	private WebElement partCode;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getpartCode()
	{
		return partCode;
	}
	public WebElement getproductName()
	{
		return productName;
	}
	public WebElement getsaveButton()
	{
		return saveButton;
	}
	
	public WebElement getmoreButton()
	{
		return moreButton;
	}
	//Business Logic
	
	public void moreButtonClicked()
	{
		moreButton.click();
	}
	public void createProductWithProduct(String prodcutName)
	{
		productName.sendKeys(prodcutName);
		saveButton.click();
	}
	
	
	public void createProductWithProduct(String proName,String partNumber)
	{
		productName.sendKeys(proName);
		partCode.sendKeys(partNumber);
		saveButton.click();
	}

}
