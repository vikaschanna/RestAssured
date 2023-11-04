package GenericLibrery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class is used to fetch the data from Excel file
 * @author Vikas S
 *
 */
public class ExcelUtility {
	
	JavaUtility jLib = new JavaUtility();
	
	/**
	 * This method is used to read the data from Excel file
	 * @author Vikas S
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Throwable
	 */
	public String readTheDataFromExcel(String sheetName, int rowNo, int celNo) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to write the data back to Excel file
	 * @author Vikas S
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		wb.getSheet(sheetName).createRow(rowNo).createCell(celNo).setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(IPathContants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method is used to get the row count from Excel file
	 * @author Vikas S
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method is used to get the Cell count from Excel file
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastCellNo(String sheetName) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		int cellCount = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		return cellCount;
	}
	
	/**
	 * This method is used to read multiple data from Excel file using HashMap
	 * @param sheetName
	 * @param keyCelNo
	 * @param valueCelNo
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getMultipleDataFromExcel(String sheetName, int keyCelNo, int valueCelNo) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=rowCount; i++) {
			String key = sh.getRow(i).getCell(keyCelNo).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCelNo).getStringCellValue();
			map.put(key, value);
		}
			
		return map;
	}
	
	public Object[][] getDataFromExcelUsingDataProvider(String SheetName) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathContants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum(); //6
		short cellCount = sh.getRow(0).getLastCellNum();
//		System.out.println(rowCount+"   "+cellCount);
		Object[][] obj = new Object[rowCount][cellCount];
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				obj[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
}
