package Utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;


public class ExcelReader {

  private static XSSFWorkbook workbook;
  private static XSSFSheet sheet;

  public static Object[][] getTestDataByTCID(String excelPath, String sheetName, String tcid) {
	
	//Passing sheet name & Path & testcase id ,because without tcid it will read all test data in excell for 1 method now can pass row data by id.
  
	Object[][] data = null;

    try {

        FileInputStream excelFile = new FileInputStream(excelPath);

        workbook = new XSSFWorkbook(excelFile);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            System.out.println("Error: Sheet '" + sheetName + "' not found.");
            workbook.close();
            excelFile.close();
            return new Object[0][0];
        }

        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(0).getLastCellNum();

        for (int row = 1; row <= totalRows; row++) {

            Row currentRow = sheet.getRow(row);

            if (currentRow != null) {

                Cell tcidCell = currentRow.getCell(0);

                if (tcidCell != null && tcidCell.toString().equalsIgnoreCase(tcid)) {

                    data = new Object[1][totalCells];

                    for (int cell = 0; cell < totalCells; cell++) {

                        Cell currentCell = currentRow.getCell(cell);

                        if (currentCell != null) {
                            data[0][cell] = currentCell.toString();
                        } else {
                            data[0][cell] = "";
                        }
                    }

//System.out.println("Columns returned = " + data[0].length);
//
//for (Object value : data[0]) {
//    System.out.println(value);
//}
                    System.out.println("Excel Loaded Successfully");
                    System.out.println("Sheet Name      : " + sheet.getSheetName());
                    System.out.println("Executing TCID  : " + tcid);

                    workbook.close();
                    excelFile.close();

                    return data;
                }
            }
        }

        System.out.println("TCID '" + tcid + "' not found in Excel.");

        workbook.close();
        excelFile.close();

    } catch (Exception e) {
        System.out.println("Error reading Excel: " + e.getMessage());
        e.printStackTrace();
    }

    return new Object[0][0];
}
}


//public class ExcelReader {
//
//    private static XSSFWorkbook workbook;
//    private static XSSFSheet sheet;
//    
//    public static Object[][] getTestDataExcel(String excelPath, String sheetName) {  

        //Passing sheet name & Path , its read every test data in excel for 1 method i felt difficult in validation. 

//        Object[][] data = null;
//        
//        try {
//            FileInputStream excelFile = new FileInputStream(excelPath);
//            workbook = new XSSFWorkbook(excelFile);   
//            sheet = workbook.getSheet(sheetName); 
//
//            if (sheet == null) {
//                System.out.println("Error: Sheet with name '" + sheetName + "' was not found!");
//                workbook.close();
//                excelFile.close();
//                return new Object[0][0];
//            }
//            
//            // Total Data Rows (excluding header row index 0)
//            int totalRows = sheet.getLastRowNum();
//            Row headerRow = sheet.getRow(0);
//            int totalCells = (headerRow != null) ? headerRow.getLastCellNum() : 0;
//            
//            data = new Object[totalRows][totalCells];
//            
//            for (int row = 1; row <= totalRows; row++) {
//                Row currentRow = sheet.getRow(row);
//                
//                for (int cell = 0; cell < totalCells; cell++) {
//                    if (currentRow != null) {
//                        Cell currentCell = currentRow.getCell(cell);
//                        
//                        if (currentCell != null) {
//                            data[row - 1][cell] = currentCell.toString();
//                        } else {
//                            data[row - 1][cell] = ""; // Handle empty cells safely
//                        }
//                    } else {
//                        data[row - 1][cell] = ""; // Handle empty rows safely
//                    }
//                }
//            }
//            
//            System.out.println("Excel Loaded Successfully");
//            System.out.println("Sheet Name      : " + sheet.getSheetName());
//            System.out.println("Total Data Rows : " + totalRows);
//            System.out.println("Total Columns   : " + totalCells);
//            
//            workbook.close();
//            excelFile.close();  
//        } catch (Exception e) {
//            System.out.println("Error reading Excel: " + e.getMessage());
//            e.printStackTrace();
//        }
//        
//        return data;
//    }
//}