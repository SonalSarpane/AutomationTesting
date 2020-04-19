package com.way2automation.util;

public class TestUtil {

	public TestUtil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static long PAGE_LOAD_TIME=20;
	public static long IMPLICITE_WAIT=10;
	public static String TESTDATA_SHEET_PATH = "D:\\Sonal\\Projects\\Demo.HybridFramework\\TestData\\ResourceTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
