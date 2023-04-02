package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactsTest extends BaseClass{

	@Test(groups="SmokeSuite")
	
	public void CreateContactsTestScript() throws IOException
	{
		
		
		HomePage home=new HomePage(driver);
		Reporter.log("Navigate to Home Page Sucessfully");

		home.contactButtonClicked();
		Reporter.log("Navigate to Contacts Page Sucessfully",true);

                //Take data from excelSheet
					
		String LASTNAME = excelUtility.readDataFromEXcelSheet("Contacts", 4, 3);		
		System.out.println(LASTNAME);
		    
		//Step 3: Navigate to Contacts			
		//Click on create Contact Lookup icon image
				
        ContactPage createContact=new ContactPage(driver);
		createContact.createContactButtonClicked();
     
		
		Reporter.log("Click on create Contact Lookup icon image Sucessfully",true);

	        	//Step 4: Create Contacts2`
			
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.createNewContact(LASTNAME, " N ", 7);
			
		Reporter.log("create Contact  Sucessfully");

		//Step : Click on Organization look up icon	

		//Step : Verify
			
		//createContactPage.
				
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String orgHeaderText = orgInfoPage.getOrgHeaderText();
				
		Assert.assertTrue(orgHeaderText.contains(orgHeaderText), "Orgnization Created in assertMethod text message");
								
		Assert.assertTrue(orgHeaderText.contains(LASTNAME), "Contact created successfully");
				
				
			
			
	}

}
