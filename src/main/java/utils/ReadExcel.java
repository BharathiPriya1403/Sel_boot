package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class ReadExcel 
{
	
	public String[][] readData(String fileName) throws IOException, InvalidFormatException
	{

	//Creating a new workbook
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./Data/"+fileName+".xlsx"));
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int rowNum = sheet.getLastRowNum(); 
			int colNum = sheet.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowNum][colNum];
			
			for (int i = 1; i <= rowNum; i++) 
			{
				XSSFRow curRow = sheet.getRow(i);
				for (int j = 0; j < colNum; j++) 
				{
					data[i-1][j] = curRow.getCell(j).getStringCellValue();
				}
				
			}
			
//			wb.close();
			return data;
	}
}
