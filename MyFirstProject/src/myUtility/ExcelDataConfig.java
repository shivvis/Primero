package myUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	//Create a constructor class with parameter
	
	XSSFWorkbook wb ;
	XSSFSheet strSheet;
	XSSFRow Row;
	XSSFCell  Cell;
	
	public ExcelDataConfig(String ExcelPath) 
	{
		try {
			File srcFile = new File(ExcelPath);
			FileInputStream fis = new FileInputStream(srcFile);
			 wb = new XSSFWorkbook(fis); //Will load the work book
			 
			 
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


public void getExcelData(String sheetName,int row1,int col1) throws Exception
{
	strSheet = wb.getSheet(sheetName);
	//String strData = strSheet.getRow(row).getCell(col).getStringCellValue();
	//String caseData = null;
	int rowCount = strSheet.getLastRowNum();
	int row = 1;
	int col = 0;
	
	Row = strSheet.getRow(row);
	 
	for(int i=row;i<=rowCount;i++)
	{
		/*for(int j=col;j<=Row.getLastCellNum();j++)
		{
		*/	/*String caseData  = strSheet.getRow(row).getCell(col).getStringCellValue();
			System.out.println("data :"+caseData);*/
			//if(strSheet.getRow(i).getCell(j).getStringCellValue().trim().equals("Name"))
			//{
	/*			int colNum =j;
				String childName = String.valueOf(strSheet.getRow(i).getCell(colNum).getStringCellValue());
				System.out.println("data :"+childName);*/
				
/*				String cellName = new CellAddress(i, j).toString();
				System.out.println("CellName :"+cellName);*/
												
			//}
			
			//Cell = Row.getCell(colNum);
			 

		//}
		
		String strName =  String.valueOf(strSheet.getRow(i).getCell(1).getStringCellValue());
		int Age =(int)strSheet.getRow(i).getCell(2).getNumericCellValue();
		String strEstimated =  String.valueOf(strSheet.getRow(i).getCell(3).getStringCellValue());
		String strNationality =  String.valueOf(strSheet.getRow(i).getCell(4).getStringCellValue());
		String strMaritalStatus =  String.valueOf(strSheet.getRow(i).getCell(5).getStringCellValue());
		
		System.out.println("data :"+strName);
		System.out.println("data :"+Age);
		System.out.println("data :"+strEstimated);
		System.out.println("data :"+strNationality);
		System.out.println("data :"+strMaritalStatus);
		
		
		
	}
	
	wb.close();
	//return caseData;
}

}