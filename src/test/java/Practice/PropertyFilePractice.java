package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step1: open the file in java readable formate
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Step 2: Create a object of the properties from java.util.package
		
		Properties pObj=new Properties();
		
		//Step 3:Load the file input stream into Properties
		pObj.load(fis);
		//Step 4: Access the values with keys
		String browser= pObj.getProperty("browser");
		System.out.println(browser);
		
		String username = pObj.getProperty("username");
		System.out.println(username);

		

	}

}
