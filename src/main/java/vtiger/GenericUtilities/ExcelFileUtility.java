package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
/**
 * 
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	
	public String readDataFromEXcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		Cell ce=rw.getCell(cell);
		String value = ce.getStringCellValue();
		return value;
		
	}
	/**
	 * 
	 * @param Sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		int rowCount = sh.getLastRowNum();
		return rowCount;

	}
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public String readDataFromExcelSheet(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row rw=sh.getRow(row);
		Cell cel=rw.getCell(cell);
		String value = cel.getStringCellValue();
		return value;
	}
	
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException
	{
FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row rw=sh.getRow(row);
		Cell ce=rw.getCell(cel);
		String rowValue = ce.getStringCellValue();
		return  rowValue;
		
	}
	
	public Object [][] readMultipleData(String Sheet) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(Sheet);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
}
