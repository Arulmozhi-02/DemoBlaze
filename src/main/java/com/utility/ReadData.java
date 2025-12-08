package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData {
	
	public static String getData(int rowNum, int colNum) {
		String data = null;
		try {
			File file = new File("C:\\Users\\pc\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
			DataFormatter dataFormat = new DataFormatter();
			data = dataFormat.formatCellValue(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	

}
