package vtiger.CampaignsTests;


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CampaignsPage;
import vtiger.ObjectRepository.CreateCampaignsPage;
import vtiger.ObjectRepository.CreateProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.ProductInformationPage;
import vtiger.ObjectRepository.ProductsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateCampaignWithProductsTest extends BaseClass{

	@Test(groups="SmokeSuite")
	
	public void CreateCampaignWithProductsTestScript() throws EncryptedDocumentException, IOException
	{
		
		HomePage home=new HomePage(driver);
		home.productButtonClicked();
			
		String	productName=(excelUtility.readDataFromEXcelSheet("Campaigns", 1, 3))+webdriverUtility.randomNumber();

		//Create product first
	
		ProductsPage product=new ProductsPage(driver);
		
	
		product.createProductButtonClicked();
				
		CreateProductPage createPrdouct=new CreateProductPage(driver);
		createPrdouct.createProductWithProduct(productName);
		
		//Verify product is created or not
		ProductInformationPage productInfo=new ProductInformationPage(driver);

	    String productHeader = productInfo.getOrgHeaderText();
		
		Assert.assertTrue(productHeader.contains(productHeader), "Product Created Successfully");
		System.out.println("productName--"+productName);
		
		//Click on more button
		
		createPrdouct.moreButtonClicked();

		home.compaignsButtonClicked();

		
		CampaignsPage campaign=new CampaignsPage(driver);	
		campaign.createCampaignButtonClicked();
		

		//System.out.println("campaignName is "+campaignName);
		CreateCampaignsPage createComs=new CreateCampaignsPage(driver);
		
		
		String campaignName = excelUtility.readDataFromEXcelSheet("Campaigns", 1, 2)+webdriverUtility.randomNumber();
		
		createComs.createCampaignsMethod(driver, campaignName);
		
		
	  //createComs.createCampaigns(driver, campaignName, productName);
        //Step : validation for Contacts
			
		
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String organizationHeader = orgInfoPage.getOrgHeaderText();
			
		Assert.assertTrue(organizationHeader.contains(campaignName), "create Compaign -PASS");
		
	}

}
