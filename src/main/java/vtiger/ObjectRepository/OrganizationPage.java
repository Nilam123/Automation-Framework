package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationButton;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	public WebElement getCreateOrganizationButton() {
		return createOrganizationButton;
	}


	public void setCreateOrganizationButton(WebElement createOrganizationButton) {
		this.createOrganizationButton = createOrganizationButton;
	}


	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Setter And Getters Methods
	
	public void createOrganizationButtonClicked()
	{
		createOrganizationButton.click();
	}
	
	//Business logics and Libraries
}
