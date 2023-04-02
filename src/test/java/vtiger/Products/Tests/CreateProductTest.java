package vtiger.Products.Tests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInformationPage;
import vtiger.ObjectRepository.ProductsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateProductTest extends BaseClass{

	
	
	@Test(groups="SmokeSuite")
	
	public void CreateProductTestScript() throws EncryptedDocumentException, IOException
	{
		
				HomePage home=new HomePage(driver);
				Reporter.log("navigate to Home page");
				home.productButtonClicked();
				Reporter.log(" product button cliked");
	
				String	productName=(excelUtility.readDataFromEXcelSheet("Campaigns", 1, 3))+webdriverUtility.randomNumber();

				//Create product first
			
				ProductsPage product=new ProductsPage(driver);	
				product.createProductButtonClicked();
				
				Reporter.log("create product button cliked");

				CreateProductPage createPrdouct=new CreateProductPage(driver);
				createPrdouct.createProductWithProduct(productName);
				
				Reporter.log("Create product with product code");

				
				//verify
				
				ProductInformationPage pageInfo=new ProductInformationPage(driver);	
				
				Reporter.log("ProductInformationPage displayed");

				String productHeader = pageInfo.getOrgHeaderText();
				Assert.assertTrue(productHeader.contains(productHeader));
				System.out.println(productHeader+" Product created successfully---------------");
			
			

	}
	
	/**
	@Test(groups="SmokeSuite")
	public void CreateProductTestWithCode() throws EncryptedDocumentException, IOException
	{
		
		
		
		HomePage home=new HomePage(driver);
		home.productButtonClicked();
		
		
		String	productName=(excelUtility.readDataFromEXcelSheet("Campaigns", 1, 3))+webdriverUtility.randomNumber();

		
		//Create product first
	
		ProductsPage product=new ProductsPage(driver);	
		product.createProductButtonClicked();				
		CreateProductPage createPrdouct=new CreateProductPage(driver);
		
		
		//verify
		
	
		createPrdouct.createProductWithProduct(productName,"PB-1024526");
		ProductInformationPage pageInfo=new ProductInformationPage(driver);	
		String productHeader = pageInfo.getOrgHeaderText();
		Assert.assertTrue(productHeader.contains(productName));
		System.out.println(productHeader+" Product created successfully with Product Code---------------");
	
	}
	
	*/

	@Test
	
	public void practiceTestScript()
	{HomePage home=new HomePage(driver);
	home.productButtonClicked();
	
		System.out.println("CreateProductTestScript>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}
