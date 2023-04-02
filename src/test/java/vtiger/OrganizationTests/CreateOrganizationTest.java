package vtiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	
	@Test(groups="SmokeSuite")
	
	public void CreateOrganizationTestScript() throws EncryptedDocumentException, IOException
	{
		
		//Step 3:Navigate to organization
		
		HomePage home=new HomePage(driver);
		home.organizationButtonClicked();

		//Step 4:create organization
         
		OrganizationPage OrgPage=new OrganizationPage(driver);
		OrgPage.createOrganizationButtonClicked();
		
		//Step 5:create organization

		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
				
     	String orgName=(excelUtility.readDataFromEXcelSheet("Oraganizations", 4, 2))+webdriverUtility.randomNumber();
		System.out.println("orgName -"+orgName);		
		createOrg.createOrganization(orgName);
		
		//Step 7: verify
	
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String orgHeaderText = orgInfoPage.getOrgHeaderText();
						System.out.println("orgHeaderText>>>>>>>>>>>>>>>>"+orgHeaderText); 
		Assert.assertTrue(orgHeaderText.contains(orgName));
		
		
	}

}
