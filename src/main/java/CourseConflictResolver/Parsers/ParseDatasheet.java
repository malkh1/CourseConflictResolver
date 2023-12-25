package CourseConflictResolver.Parsers;


import CourseConflictResolver.Services.StoreIntoDB;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ParseDatasheet {

    private Map<Integer, String> columnHeaderMap;
    private StoreIntoDB dB;
    private String filePath;
    private static List<String> includedColumns = Arrays.asList("FAC", "DEPT", "TERM", "CRN", "SUBJ", "CRSE",
            "CATALOG_TITLE", "STATUS", "LNK_ID", "LNK_CONN", "DAYS",
            "START_TIME", "END_TIME", "BLDG", "ROOM", "START_DATE",
            "END_DATE", "MAX_ENR", "ACT_ENR",
            "ROOM_CAP", "VOICE_AVAIL");

    private static void printHeader() {
        System.out.printf("%-20s%-15s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-30s%n",
                "FAC", "DEPT", "TERM", "CRN", "SUBJ", "CRSE",
                "CATALOG_TITLE", "STATUS", "LNK_ID", "LNK_CONN", "DAYS",
                "START_TIME", "END_TIME", "BLDG", "ROOM", "START_DATE",
                "END_DATE", "MAX_ENR", "ACT_ENR",
                "ROOM_CAP", "VOICE_AVAIL");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public ParseDatasheet(StoreIntoDB dB) {
        this.dB = dB;
        columnHeaderMap = new LinkedHashMap<>();
    }

    private void printRow(Row row) {
        for (Cell cell : row) {
            System.out.printf("%-20s", cell.toString());
        }
        System.out.println();
    }

    public Map<String, String> getDataMap(Row row) throws IOException {
        Map<String, String> dataMap = new LinkedHashMap<>();
        
        for (Cell cell : row) {

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
                        cellValue
                                = String.format("%.0f", cell.getNumericCellValue());
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

    public void getColumnHeaderMap(Sheet sheet) throws IOException {

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


    public void parseDataSheet(FileInputStream fileInputStream){
        try (Workbook workbook = new XSSFWorkbook(fileInputStream)){
            int i = 0;
            Sheet sheet = workbook.getSheetAt(0);
            getColumnHeaderMap(sheet);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                dB.storeIntoDB(getDataMap(row));
                printRow(row);
                
                //if(i++>=100)
                    //break;
            }
            System.out.println();
            workbook.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
