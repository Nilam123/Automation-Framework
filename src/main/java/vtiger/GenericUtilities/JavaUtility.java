package vtiger.GenericUtilities;

import java.util.Date;

public class JavaUtility {

	/**
	 * This is used to get SystemDate
	 * @return
	 */
	public  String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	
	
	/**
	 * THis is used to get formated date
	 * @return
	 */
	public String getSystemDateInFormate()
	{
		Date d=new Date();
		String data[]=d.toString().split(" ");
		String month=data[1];
		String date=data[2];
		String time=data[3].replace(":", "-");
		String year=data[5];
		String finalDate=date+" "+month+" "+year+" "+time;
		
		return finalDate;
	}
}

