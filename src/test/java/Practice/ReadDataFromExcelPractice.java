package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelPractice {

	public static void main(String[] args) throws IOException   {
		// TODO Auto-generated method stub

		
		//Step 1: Open the document in java readable formate
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Organizations.xlsx");
		
		//Step 2: Create a workbook
		
		Workbook wb=WorkbookFactory.create(fis);
		//Step 3: Get Control of sheet
		
		Sheet sh=wb.getSheet("Contacts");
		
		//Step 4: Get Control of Row
		Row rw=sh.getRow(4);
		//Step 5: Get Control of Cell
		
		Cell ce=rw.getCell(2);
				
		
		//Step 6: Read the data inside the cell..	
		
		String value=ce.getStringCellValue();	
		System.out.println(value);

		
	}

}
