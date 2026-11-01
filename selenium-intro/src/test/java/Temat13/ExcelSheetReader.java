package Temat13;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSheetReader {

    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;

    public void setExcelFileSheet(String excelFileLocation, String sheetName) throws IOException {
        FileInputStream excelFile = new FileInputStream(excelFileLocation);
        excelWBook = new XSSFWorkbook(excelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        if (excelWSheet == null) {
            throw new RuntimeException("Excel Sheet was null! Please check name of the excel sheet!");
        }
    }

    public XSSFSheet getExcelSheet() {
        return excelWSheet;
    }
}
