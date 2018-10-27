package myUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// Create a constructor class with parameter

	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception

	{
		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}
	}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

//To read string value
	public static String getStringCellData(int RowNum, int colNum) throws Exception {
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(colNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {

			return "";

		}

	}

////To read integer value
	public static int getNumericCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int CellData = (int) Cell.getNumericCellValue();
		// (int)strSheet.getRow(i).getCell(2).getNumericCellValue();
			return CellData;

		} catch (Exception e) {

			return 0;

		}

	}

//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try

		{
			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum);

			if (Cell == null)
			{

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} 
			else 
			{

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}
