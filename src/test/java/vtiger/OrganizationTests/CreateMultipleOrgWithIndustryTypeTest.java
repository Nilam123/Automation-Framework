package vtiger.OrganizationTests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrgWithIndustryTypeTest extends BaseClass {

	
	@Test(groups="SmokeSuite")
	//(dataProvider ="getData")
	
	public void createMultipleOrgWithIndustryTypeTestScript() throws EncryptedDocumentException, IOException//(String ORGNAME, String INDUSTRY)
	{
	
		HomePage home=new HomePage(driver);
		home.organizationButtonClicked();
		
		OrganizationPage org=new OrganizationPage(driver);
		org.createOrganizationButtonClicked();
		
		
		CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);	
		
		String orgNames=(excelUtility.readDataFromEXcelSheet("Oraganizations", 4, 2))+webdriverUtility.randomNumber();
		System.out.println("orgName -"+orgNames);		
		//createOrg.createOrganization(orgName, "Banking","-");
		createOrg.createOrganization(orgNames);
		
		//System.out.println("ORGNAME--------"+orgName);

		//System.out.println("INDUSRTRY--------"+INDUSTRY);
		
		//Step 7: verify
		
		
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String orgHeaderText = orgInfoPage.getOrgHeaderText();
						System.out.println("orgHeaderText>>>>>>>>>>>>>>>>"+orgHeaderText); 
		Assert.assertTrue(orgHeaderText.contains(orgNames));
		
		//Assert.assertTrue
	}

//	@DataProvider
//	public Object[][] getData() throws EncryptedDocumentException, IOException
//	{
//		Object[][] data=excelUtility.readMultipleData("Multiple");
//		return data;
//	}
}
