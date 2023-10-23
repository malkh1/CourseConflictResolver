package com.sysc4907.courseconflictresolver;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class handles the logic for implementing the Parser object
 * @author Mohammad Al-Khaledi
 * @author Waleed Majbour
 */
public class Parser {

    private Map<Integer, String> columnHeaderMap;
    
    private String filePath;

    List<String> includedColumns = Arrays.asList("FAC", "DEPT", "TERM", "CRN", "SUBJ", "CRSE",
            "CATALOG_TITLE", "STATUS", "LNK_ID", "LNK_CONN", "DAYS",
            "START_TIME", "END_TIME", "BLDG", "ROOM", "START_DATE",
            "END_DATE", "MAX_ENR", "ACT_ENR",
            "ROOM_CAP", "VOICE_AVAIL");
    
    /**
     * Creates a parser object
     * @param filePath must be a file path to an excel sheet
     */
    public Parser(String filePath) {
        this.filePath = filePath;
        columnHeaderMap = new LinkedHashMap<>();
    }
    
    /**
     * helper function for opening the excel document
     * @return the first sheet in the excel document
     * @throws IOException error if the file is already open
     */
    public Sheet openFile() throws IOException {
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        return workbook.getSheetAt(0);
    }
    
    
    /**
     * 
     * Parses the first row of the excel sheet to get all the column names
     * and their indices
     * @return a map containing key-value pairs of columnNames-indices
     * @throws IOException If excel file is currently being used, throw an IOException
     */
    public Map<Integer, String> getColumnHeaderMap(List<String> includedColumns) throws IOException {
        Sheet sheet = openFile();
        Row firstRow = sheet.getRow(0);

        for (Cell cell : firstRow) {
            String cellValue = cell.getStringCellValue();
            int cellIndex = cell.getColumnIndex();
            if (includedColumns.contains(cellValue)) {
                columnHeaderMap.put(cellIndex, cellValue);
            }
        }
        System.out.println(columnHeaderMap);
        return columnHeaderMap;
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public Map<String, String> getDataMap(Row row) throws IOException {
        Map<String, String> dataMap = new HashMap<>();
        
            for(Cell cell : row) {
                int cellIndex = cell.getColumnIndex();
                String columnName = columnHeaderMap.get(cellIndex);
                String cellValue = "";
                switch (cell.getCellType()) {
                    case STRING -> {
                        cellValue = cell.getStringCellValue();
                    }

                    case NUMERIC -> {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            cellValue = (cell.getDateCellValue()).toString();

                        } else {
                            cellValue =
                                    String.valueOf(String.format("%.0f", cell.getNumericCellValue()));
                        }
                    }

                    default -> {
                        throw new AssertionError();
                    }
                }
                dataMap.put(columnName, cellValue);
            }

        return dataMap;
    }
    
}