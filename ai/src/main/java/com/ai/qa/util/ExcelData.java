package com.ai.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	private final Logger log = LogManager.getLogger(ExcelData.class.getName());
	File source;
	FileInputStream fileinputstream;
	XSSFWorkbook workbook;
	XSSFSheet sheet; 
	int rowcount;
	short columcount;
	
	public ExcelData(String excelpath)
	 {  log.info("Trying to open Excel file to read data");
		source = new File(excelpath);
		try {
			fileinputstream = new FileInputStream(source);
			workbook = new XSSFWorkbook(fileinputstream);
		} catch (FileNotFoundException e) {
			log.error("While opening excel to read data Filenotfound exception thrown");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("While opening excel to read data IOexception thrown");
			e.printStackTrace();
		}
		log.info("Excel file is opened to read data");
		
	}
	public Object[][] getTestData(String sheetname)
	{   log.info("Trying to read sheet with "+sheetname);
		sheet = workbook.getSheet(sheetname);
		rowcount =   sheet.getLastRowNum();
		columcount = sheet.getRow(0).getLastCellNum();
	    
		Object[][] dataobject = new Object[rowcount][1];
		for(int i=0;i<rowcount;i++)
		{
		  Map<Object,Object> datamap = new HashMap<Object,Object>();
		  for(int j=0;j<columcount;j++)
			{
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
			}
	      dataobject[i][0]=datamap;
		}
		log.info("Full data is read from  "+sheetname);
		return dataobject;
     }

}
