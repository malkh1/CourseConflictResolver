package com.sysc4907.courseconflictresolver;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class handles the logic for implementing the Parser object
 * @author Mohammad and Waleed
 */
public class Parser {

    private Map<String, Integer> courseMap;
    
    private String filePath;
    
    /**
     * Creates a parser object
     * @param filePath must be a file path to an excel sheet
     */
    public Parser(String filePath) {
        this.filePath = filePath;
        courseMap = new LinkedHashMap<>();
    }
    
    /**
     * 
     * Parses the first row of the excel sheet to get all the column names
     * and their indices
     * @return a map containing key-value pairs of columnNames-indices
     * @throws IOException If excel file is currently being used, throw an IOException
     */
    public Map<String, Integer> getCourseMap() throws IOException {
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet =  workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        
        for(Cell cell : firstRow) {
            String cellValue = cell.getStringCellValue();
            int cellIndex = cell.getColumnIndex();
            courseMap.put(cellValue, cellIndex);
        }
        
        System.out.println(courseMap);
        return courseMap;
    }
    
}