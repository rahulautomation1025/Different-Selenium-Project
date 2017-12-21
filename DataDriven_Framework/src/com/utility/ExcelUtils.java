package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	 
	public static void setexcel(String path,String Sheetname) throws IOException {
		
		FileInputStream fis =new FileInputStream(path);
		ExcelWBook=new XSSFWorkbook(fis);
		ExcelWSheet=ExcelWBook.getSheet(Sheetname);
		
			
		}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		 
			try{

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

  			String CellData = Cell.getStringCellValue();

  			return CellData;

  			}catch (Exception e){

				return"";

  			}
}
}