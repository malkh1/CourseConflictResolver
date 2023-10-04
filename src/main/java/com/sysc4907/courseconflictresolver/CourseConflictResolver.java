package com.sysc4907.courseconflictresolver;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Mohammad
 */
public class CourseConflictResolver {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Parser parser = new Parser("src/main/resources/data_source.xlsx");
        CourseRecords record = new CourseRecords();
        try {

            var courseMap = parser.getColumnHeaderMap();

            Iterator<Row> rowIterator = (parser.openFile()).iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                var dataMap = parser.getDataMap(row);
                
                System.out.println(dataMap);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
