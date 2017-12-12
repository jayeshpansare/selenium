package testExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	public Exceldata(String excelpath){
		// TODO Auto-generated constructor stub
		try{
		File src = new File(excelpath);
		FileInputStream fis=new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);		
		}catch(Exception e){
			System.out.println("Error is:"+e);
		}
	}

	public String getData(int sheetNo, int noOfRow, int cellNo){
		
		sh1 = wb.getSheetAt(sheetNo);
		Row row = sh1.getRow(noOfRow);
		String data= null;
		if (row == null) {
	         // There is no data in this row, handle as needed
	      } else {
	    	  Cell cell = row.getCell(cellNo);
	    	  if (cell == null) {
	    		  data="";
	            } else {
	            	data = sh1.getRow(noOfRow).getCell(cellNo).getStringCellValue();
	            }
	      }
		
		return data;
	}
	
	public int getTotalRow(int sheetNo){
		sh1 = wb.getSheetAt(sheetNo);
		int data = sh1.getLastRowNum();
		return data;		
	}
	
}
