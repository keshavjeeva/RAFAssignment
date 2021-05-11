package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datautils 

{
	/*
	 * public static void main(String[][] args) throws IOException { testdata(); }
	 */
	
	public static Object[][] testdata() throws IOException
	{

		FileInputStream fis = new FileInputStream("C:\\Users\\KesavarajSelvaraj\\Documents\\SeleniumUpskill\\SDET\\TD_RAF.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheetAt(0);
		
		int rowcount = sh.getLastRowNum();
		Row row = sh.getRow(1);
		int columncount = row.getLastCellNum();
		
		Object[][] input = new Object[rowcount+1][columncount];
		
		for(int i=0; i<rowcount+1; i++) 
		{
			for(int j=0; j<columncount; j++) 
			{
				input[i][j] = sh.getRow(i).getCell(j).getStringCellValue();	
				System.out.println(input[i][j]);
			}
		}
		wb.close();
		return input;
		
	}
	
	
}
