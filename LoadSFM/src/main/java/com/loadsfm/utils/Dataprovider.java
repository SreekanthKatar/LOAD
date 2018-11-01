package com.loadsfm.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Dataprovider {
	
	@DataProvider(name = "inputdata")
    public static Object[][] dataProvidermethod() throws BiffException, IOException 
	{
		Object[][] exdata = getExcelData();
		return exdata;
    }
	
	public static Object[][] getExcelData() throws BiffException, IOException
	{
		FileInputStream fi = new FileInputStream("D:\\Projects\\SFM_LOAD\\LoadSFM\\src\\main\\java\\com\\loadsfm\\files\\datasheet.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet sht = wb.getSheet("data");
		String[][] exceldata = new String[sht.getRows()][sht.getColumns()];
		for (int i = 0; i < sht.getRows(); i++) {
			for (int j = 0; j < sht.getColumns(); j++) {
				exceldata[i][j] = sht.getCell(j, i).getContents();
			}
		}
		
		return exceldata;
		
	}

}
