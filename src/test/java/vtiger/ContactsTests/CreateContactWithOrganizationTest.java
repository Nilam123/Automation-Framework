package vtiger.ContactsTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;

import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;

import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test(groups="RegressionSuite")
	
	public void CreateContactWithOrganizationTestScript() throws IOException
	{
		
				
				//Step 3:Navigate to organization
				
				HomePage home=new HomePage(driver);
				
				Reporter.log("Navigate to organization");
				home.organizationButtonClicked();
				Reporter.log("Click on organization ");

				
				//Step 4:create organization
                 
				OrganizationPage OrgPage=new OrganizationPage(driver);
				OrgPage.createOrganizationButtonClicked();
				Reporter.log("click on create organization look up image");

				//Step 5:create organization

				CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
						
		     	String orgName=(excelUtility.readDataFromEXcelSheet("Contacts", 4, 2))+webdriverUtility.randomNumber();
				System.out.println("orgName -"+orgName);
					
				createOrg.createOrganization(orgName, "Banking","Customer");
				Reporter.log("create organization successfully");

				
				//Step 7: verify
				
				OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
				String orgHeaderText = orgInfoPage.getOrgHeaderText();		
		Assert.assertTrue(orgHeaderText.contains(orgHeaderText));
						
	           // Step 8:Click on create Contact Lookup icon image
				
				home.contactButtonClicked();
				
				Reporter.log(" Contact Button clicked ");
               //Click on create Contact Lookup icon image
				
				ContactPage contact=new ContactPage(driver);
				contact.createContactButtonClicked();
				
				Reporter.log("Click on create Contact Lookup icon image ");

	        	//Step 4: Create Contacts
				
				String FIRSTNAME = excelUtility.readDataFromEXcelSheet("Contacts", 1, 2);
				String LASTNAME = excelUtility.readDataFromEXcelSheet("Contacts", 1, 3);

				
				CreateContactPage createContact=new CreateContactPage(driver);	
				//createContact.createContact(LASTNAME, FIRSTNAME,5);			
				createContact.createNewContact(driver, orgName, LASTNAME, FIRSTNAME, 5);
				Reporter.log(" Contacts created Successfully");
				
            //Step : validation for Contacts
				
				ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
				String contactHeader = contactInfo.getContactHeaderText();
		     	Assert.assertTrue(contactHeader.contains(LASTNAME));	
				//System.out.println(contactHeader+"create contact -PASS");
				Reporter.log(contactHeader+"create contact -PASS");

			
	}

}

