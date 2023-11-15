package Parsers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ParseCombinations {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/BlockMaster.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            int sheetCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetCount; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                System.out.println("Sheet: " + sheet.getSheetName());
                printHeader();

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        // Skip header row
                        continue;
                    }

                    printRow(row);
                }
                System.out.println();
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printHeader() {
        System.out.printf("%-20s%-15s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-30s%n",
                "Program ID", "Student Count", "Term", "Course1", "Course2", "Course3", "Course4",
                "Course5", "Course6", "Action", "Comments", "Cohort & Future Plans");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void printRow(Row row) {
        for (Cell cell : row) {
            System.out.printf("%-20s", cell.toString());
        }
        System.out.println();
    }
}
