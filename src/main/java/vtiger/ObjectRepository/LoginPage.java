
package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Step 1: Create POM class for every web page
	
	//Rule 2: identify web elements with@FindBy,@FindBys and Findall 
	
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	// Rule 3 :Create a constructor to initialise these web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4:Provide getters to acess these elements
	
	public WebElement getUsernameEdt()
	{
		return usernameTextfield;
	}
	
	public WebElement getPasswordEdit()
	{
		return passwordTextfield;
	}
	
	public WebElement  getLoginButtonEdt()
	{
		return loginButton;
	}
	//Business libraries -generic methods specific to current project
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void clickOnLoginButton(String username,String password)
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}


}

