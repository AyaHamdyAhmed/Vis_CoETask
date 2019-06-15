package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Read Data from Excel Sheet
 * **/
public class ExcelReader {

	static FileInputStream fis = null;
	/**
	 * this function read file path and then return input stream 
	 * **/
	public static FileInputStream getFileInputStream() {
		String FilePath = System.getProperty("user.dir") + "/src/test/java/data/TestData.xlsx";
		File SrcFile = new File(FilePath);
		try {
			fis = new FileInputStream(SrcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data File not found" + e.getMessage());
			System.exit(0);
		}

		return fis;
	}
	/**
	 * to return data that we read from excel
	 * **/
	public static Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();
		int totalCols =1;

		//System.out.println(totalRows);
		String[][] arrayExcelData = new String[totalRows][totalCols];
		for (int i = 0; i < totalCols; i++) {

			for (int j = 0; j < totalRows; j++) {
				XSSFRow row = sheet.getRow(j);
				arrayExcelData[j][i] = row.getCell(i).toString();
				System.out.println(arrayExcelData[j][i].toString());
			}
		}

		wb.close();
		return arrayExcelData;
	}

	/*public static void main(String[] args) {
		try {
			Object[][] d = getExcelData();
			//System.out.println(d[0][0].toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}


