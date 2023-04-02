package Practice;

import org.testng.annotations.Test;

public class ReadDataFromCommanLine {

	@Test
	public void ReadDataFromCommanLineTestScript()
	{
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		String URL = System.getProperty("url");
		System.out.println(URL);
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
		
		
	}
}
