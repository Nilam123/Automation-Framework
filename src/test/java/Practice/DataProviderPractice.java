package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider= "phone")

	
	public void addProduct(String phone,int prize)
	{
		System.out.println(phone+"---------"+ prize);
		
	}
	@Test(dataProvider= "laptop")

	public void addProduct(String laptop)
	{
		System.out.println(laptop);
		
	}
	
	@DataProvider(name="phone")
	
	public Object[][] getData()
	{
	                               // row // columon
		Object[][] data= new Object[3][2]; // 3 sets of data each consists of 2 units
		
		data[0][0]="iPhone";
		data[0][1]=55452;
		
		data[1][0]= "Samsaung";
		data[1][1]=25000;
		
		data[2][0]="Oppo";
		data[2][1]=7425;
		return data;
		
	}
	
	@DataProvider(name="laptop")
	
	public Object[][] getlaptopDetails()
	{
		Object[][] laptop=new Object[3][1];
		
		laptop[0][0]="Apple";
		
		laptop[1][0]="Lenova";
		
		laptop[2][0]="Dell";
		
		return laptop;
	}
}
