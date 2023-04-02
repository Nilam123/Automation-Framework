package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	
	private WebElement headerText;
	
	public ProductInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public String getOrgHeaderText() {
		return  headerText.getText();
	}
	
	//getter And Setter methods
}
