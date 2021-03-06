package com.Library.Flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellData {

	public static String readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File("D:\\Git\\FlipKartApp\\Excell\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			wb = new XSSFWorkbook(inputStream);

		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			wb = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet Sheet = wb.getSheet(sheetName);
		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
		System.out.println(rowCount);
		Row row = Sheet.getRow(0);
		String UName = row.getCell(0).getStringCellValue();
		String PWord = row.getCell(1).getStringCellValue();
		return UName + " " + PWord;

	}

}
