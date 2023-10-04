package com.sysc4907.courseconflictresolver;

import java.io.IOException;



/**
 *
 * @author Mohammad
 */
public class CourseConflictResolver {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Parser parser = new Parser("src/main/resources/data_source.xlsx");    
        try {
  
            var courseMap = parser.getCourseMap();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
