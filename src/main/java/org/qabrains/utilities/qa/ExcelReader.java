package org.qabrains.utilities.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private static final String TEST_DATA_PATH = "src/test/resources/testdata/QABrainsTestData.xlsx";

	public static Object[][] getExcelData(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(new File(TEST_DATA_PATH));

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			workbook.close();
			fis.close();
			throw new RuntimeException("Sheet not found: " + sheetName);
		}

		int rowCount = sheet.getLastRowNum(); // excluding header
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i + 1); // skip header

			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i][j] = cell.toString();
			}
		}

		workbook.close();
		fis.close();

		return data;
	}

}
