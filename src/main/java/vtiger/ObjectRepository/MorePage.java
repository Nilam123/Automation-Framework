package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {

	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaginButton;
	
	
	public MorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
