package PkReadExcelData;

import myUtility.ExcelDataConfig;

public class NewReadExcelData

{
/*	public  void ReadExcelData() throws Exception
	{
	
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\jkasilingam\\eclipse-workspace\\DataTable\\CaseTable.xlsx");
		
        try {
			//System.out.println(excel.getExcelData("CaseSheet", 1, 1));
			excel.getExcelData("CaseSheet", 1, 1);
		}
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
		}
	}*/

	public void ReadExcelData() 
	{
		// TODO Auto-generated method stub
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\jkasilingam\\eclipse-workspace\\DataTable\\CaseTable.xlsx");
		
        try {
			System.out.println("inside method where datasheet  parameters are passed");
			excel.getExcelData("CaseSheet", 1, 1);
		}
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
		}
	}
        
}
