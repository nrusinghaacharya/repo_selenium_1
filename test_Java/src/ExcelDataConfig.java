package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.asm.Advice.Return;

public class ExcelDataConfig {
	
	public File src;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sh1;
	
	public  ExcelDataConfig (String filePath) 
	{
		

		       // create File object   (specify path of the file)  //"D:\\SELENIUM\\EXCEL FILES\\read.xlsx"
		        
				try {
					src = new File(filePath);
					fis = new FileInputStream(src);  // Create FIS  object    (  Laod file)\
					wb = new XSSFWorkbook (fis);   //Load Workbook
					
				     } catch (Exception e) 	{
					
					                  System.out.println(e.getMessage()); 
				
				                            }
		
	}
				public String getData (int sheetNo, int row, int column) 
				{
					sh1 = wb.getSheetAt(sheetNo);      //Load Sheet
					if (sh1.getRow(row).getCell(column).getStringCellValue() != null )
					{
						return sh1.getRow(row).getCell(column).getStringCellValue();
					}
					else
					{
						System.out.println("There is no value in the given cell");
						return "no value at this cell";
					}
					
				}
	
				public double getData1 (int sheetNo, int row, int column) 
				{
					sh1 = wb.getSheetAt(sheetNo);      //Load Sheet
					//double d = ;
					
					if (sh1.getRow(row).getCell(column).getNumericCellValue() !=  0 )
					{
						return sh1.getRow(row).getCell(column).getNumericCellValue();
					}
					else
					{
						System.out.println("There is no value in the given cell");
						return  0;
					}
				}

	

}
