package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//Step 1: Open the document in java readable formate
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Organizations.xlsx");
		
		//Step 2:Create a workbook
		
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3:Get control of SHeet
		
		Sheet sh=wb.getSheet("Contacts");
		
		//Step 4:Get control of Row
		
		Row rw=sh.getRow(4);
		
		//Step 5:Create cell in that row
		
		
		Cell ce=rw.createCell(7);

		//Step 6:Set the value to Cell
		ce.setCellValue("Aviraj");
		
		//Step 7:Open the document in write mode
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Organizations.xlsx");
		
		
		//Step 8:Write the data

      wb.write(fos);
      
      System.out.println("DATA ADDED");
		
	}

}
