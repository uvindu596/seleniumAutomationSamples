package datadriven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

//	 URL to get the binary - http://poi.apache.org/download.html
//	 Binary Name - poi-bin-3.11-beta2-20140822.zip
//	 Extract the binary
//	 Add all the jars from the location you extracted to the build path
//	 Also add all the jars from lib, do not add the jar file of log4j
//	 Also add all the jars from ooxml-lib
//	 Only works for Excel 2007+
	
	
	public static void main(String[] args) {
		
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		//Location of the Excel file
		String path = "D:\\uvindu dev\\selenium\\course files\\data driven\\ExcelRead.xlsx";
		String sheetName = "Sheet1";
	
		
		try {
			FileInputStream ExcelFile  = new FileInputStream(path);
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			Cell = ExcelWSheet.getRow(2).getCell(1);
			String CellData = Cell.getStringCellValue();
			System.out.println("Cell Data: "+CellData);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
