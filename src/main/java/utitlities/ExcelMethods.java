package utitlities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelMethods {
	public FileInputStream fis;
	public Workbook wbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	
	public ExcelMethods()
	{
		try
		{
			fis=new FileInputStream("D:\\Vinaykumar\\demoproject3\\src\\main\\java\\testData\\TestDataDemo.xlsx");
			try {
				wbook=WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				
				e.printStackTrace();
			} catch (InvalidFormatException e1) {
				
				e1.printStackTrace();
			}
			
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
	}
	
	
	//methods for row count
	
	public int rowcount(String sheetname,int row)
	{
		int rowcountno=wbook.getSheet(sheetname).getLastRowNum();
		return rowcountno;
	}
	
	//cell no methods
	
	public int cellcount(String sheetname,int row,int cell)
	{
		int cellcountno=wbook.getSheet(sheetname).getRow(0).getLastCellNum();
		return cellcountno;
	}
	
	//read data
	
	public String getData(String sheetname,int row,int cell)
	{
		String data="";
		
		if(wbook.getSheet(sheetname).getRow(row).getCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int) wbook.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else
		{
			data=wbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		}
		return data;
	}

}
