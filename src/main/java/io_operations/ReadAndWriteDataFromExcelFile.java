package io_operations;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ReadAndWriteDataFromExcelFile {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        String project_home = System.getProperty("user.dir");
        File excelFile = new File(project_home + File.separator + "marks.xlsx");
        /*if (excelFile.exists()) {
            excelFile.delete();
        }
        excelFile.createNewFile();*/
        Workbook workbook = null;
        FileOutputStream fileOutputStream = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(excelFile.getAbsolutePath()));
            Sheet sheetMe = workbook.createSheet("sheetMe");
            Row row = sheetMe.createRow(1);
            Cell cell = row.createCell(0);
            cell.setCellValue("abc");
            fileOutputStream = new FileOutputStream(excelFile);
            workbook.write(fileOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            fileOutputStream.close();
        }
    }
}
