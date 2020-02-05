package com.shika.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;

	static XSSFSheet worksheet;

	static XSSFRow row;

	static XSSFCell cell;

	static DataFormatter formatter;

	static int RowNum;

	static int colNum;

	public static Object[][] getExcelData(String filePath, String sheetName) throws Exception {

		FileInputStream fis;

		fis = new FileInputStream(filePath);

		workbook = new XSSFWorkbook(fis);

		workbook.close();

		worksheet = workbook.getSheet(sheetName);

		row = worksheet.getRow(0);

		RowNum = worksheet.getPhysicalNumberOfRows();

		colNum = row.getLastCellNum();

		Object[][] excelData = new Object[RowNum - 1][colNum];

		for (int i = 0; i < RowNum - 1; i++) {

			row = worksheet.getRow(i + 1);

			for (int j = 0; j < colNum; j++) {

				cell = row.getCell(j);

				formatter = new DataFormatter();

				excelData[i][j] = formatter.formatCellValue(cell);
			}
		}

		return excelData;

	}

	public static void setExcelData(String Result, String filePath, String sheetName, String colName) {

		worksheet = workbook.getSheet(sheetName);

		row = worksheet.getRow(0);

		Iterator<Cell> cellIterator = row.cellIterator();

		while (cellIterator.hasNext()) {

			Cell cell = cellIterator.next();

			if (cell.getStringCellValue().equals(colName)) {

				cell.setCellValue(Result);

			} else {

				cell = row.createCell(colNum + 1);

				cell.setCellValue(Result);
			}
		}

		FileOutputStream fos;

		try {
			fos = new FileOutputStream(filePath);

			workbook.write(fos);

			fos.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
