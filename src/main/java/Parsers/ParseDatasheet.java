package Parsers;

import CourseConflictResolver.CourseRecords;
import Repos.CourseRecordsRepository;
import jakarta.persistence.Entity;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Component
public class ParseDatasheet {

    private static CourseRecordsRepository repo;
    private static Map<Integer, String> columnHeaderMap = new LinkedHashMap<>();
    private static String filePath;
    static List<String> includedColumns = Arrays.asList("FAC", "DEPT", "TERM", "CRN", "SUBJ", "CRSE",
            "CATALOG_TITLE", "STATUS", "LNK_ID", "LNK_CONN", "DAYS",
            "START_TIME", "END_TIME", "BLDG", "ROOM", "START_DATE",
            "END_DATE", "MAX_ENR", "ACT_ENR",
            "ROOM_CAP", "VOICE_AVAIL");
    private static ParseDatasheet parser;

    private static void printHeader() {
        System.out.printf("%-20s%-15s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-30s%n",
                "FAC", "DEPT", "TERM", "CRN", "SUBJ", "CRSE",
                "CATALOG_TITLE", "STATUS", "LNK_ID", "LNK_CONN", "DAYS",
                "START_TIME", "END_TIME", "BLDG", "ROOM", "START_DATE",
                "END_DATE", "MAX_ENR", "ACT_ENR",
                "ROOM_CAP", "VOICE_AVAIL");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void printRow(Row row) {
        for (Cell cell : row) {
            System.out.printf("%-20s", cell.toString());
        }
        System.out.println();
    }

    public static Map<String, String> getDataMap(Row row) throws IOException {
        Map<String, String> dataMap = new LinkedHashMap<>();

        for(Cell cell : row) {

            int cellIndex = cell.getColumnIndex();
            String columnName = columnHeaderMap.get(cellIndex);
            String cellValue;
            switch (cell.getCellType()) {
                case STRING -> {
                    cellValue = cell.getStringCellValue();
                }
                case NUMERIC -> {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.toString();
                        //System.out.println("cellvalue:  " + cellValue);

                    } else {
                        cellValue =
                                String.format("%.0f", cell.getNumericCellValue());
                    }
                }
                case BLANK -> {
                    cellValue = "";
                }

                default -> {
                    throw new AssertionError();
                }
            }
            dataMap.put(columnName, cellValue);
        }

        return dataMap;
    }
    public static void getColumnHeaderMap(Sheet sheet) throws IOException {

        Row firstRow = sheet.getRow(0);

        for (Cell cell : firstRow) {
            String cellValue = cell.getStringCellValue();
            int cellIndex = cell.getColumnIndex();
            if (includedColumns.contains(cellValue)) {
                columnHeaderMap.put(cellIndex, cellValue);
            }
        }
        System.out.println(columnHeaderMap);
    }


    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/data_source.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            StoreIntoDB storeIntoDB = new StoreIntoDB();

            int sheetCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetCount; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                System.out.println("Sheet: " + sheet.getSheetName());
                printHeader();

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        getColumnHeaderMap(sheet);
                        // Skip header row
                        continue;
                    }

                    storeIntoDB.storeIntoDB(row);
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
}

