package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public  String getPropertydata(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
		p.load(fis);
		System.out.println("url is ----"+p.getProperty(key));
		return p.getProperty(key);
	}
}
