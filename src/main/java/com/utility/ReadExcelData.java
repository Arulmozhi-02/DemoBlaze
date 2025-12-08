package com.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class ReadExcelData {
	public static void readParticularData() {
		//String data = null;
		try {
			File file = new File("C:\\Users\\pc\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();
			System.out.println(lastRowNum);
			
			short lastCellNum = sheet.getRow(0).getLastCellNum();
			System.out.println(lastCellNum);
			
		for (int i = 1; i < lastRowNum; i++) {
				Row row = sheet.getRow(i);
				
				for(int j=0;j<lastCellNum;j++) {
					Cell cell = row.getCell(j);
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);
					System.out.println(data);
			} 
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void writeData() {
		try {
			File file = new File("C:\\Users\\pc\\Downloads\\DataDriven_IPT.xlsx");
			FileInputStream fileInput = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		readParticularData();
	}

}
