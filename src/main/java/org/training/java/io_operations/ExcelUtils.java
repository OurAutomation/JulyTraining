package org.training.java.io_operations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtils {
    Workbook workbook;

    public ExcelUtils(String filePath) throws IOException {
        workbook = new XSSFWorkbook(filePath);
    }

    public ArrayList<Object> returnTheDataOfGivenRowInTheGivenSheet(String sheetName, int rowNumber) {
        ArrayList<Object> rowValues = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        if(rowNumber>physicalNumberOfRows) {
            System.err.println("The row is not present");
        } else {
            Row row = sheet.getRow(rowNumber);
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int i = 0; i < physicalNumberOfCells; i++) {
                Cell cell = row.getCell(i);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        rowValues.add(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        rowValues.add(cell.getBooleanCellValue());
                        break;
                    case _NONE:
                        rowValues.add(null);
                        break;
                    case BLANK:
                        rowValues.add(null);
                        break;
                    case STRING:
                        rowValues.add(cell.getStringCellValue());
                        break;
                    case ERROR:
                        rowValues.add(cell.getErrorCellValue());
                        break;
                    case FORMULA:
                        rowValues.add(cell.getCellFormula());
                        break;
                }
            }
        }
        return rowValues;
    }
}
