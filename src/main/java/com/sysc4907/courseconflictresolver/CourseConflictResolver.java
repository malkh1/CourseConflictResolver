package com.sysc4907.courseconflictresolver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Mohammad Al-Khaledi
 * @author Waleed Majbour
 */
@SpringBootApplication
public class CourseConflictResolver {

    @Bean
    public CommandLineRunner demo(CourseRecordsRepository repo) {
        return (args) -> {
            System.out.println("Parsing File...");
            Parser parser = new Parser("src/main/resources/data_source.xlsx");

            try {

                List<String> includedColumns = parser.includedColumns;
                var courseMap = parser.getColumnHeaderMap(includedColumns);

                Iterator<Row> rowIterator = (parser.openFile()).iterator();

                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    var dataMap = parser.getDataMap(row);
                    CourseRecords record = new CourseRecords();
                    BeanUtils.populate(record, dataMap);
                    repo.save(record);
                    System.out.println(dataMap);
                }
                CourseRecords record = repo.findByCRN("35871");
                System.out.println(record.getCRN());

            } catch (IOException | IllegalAccessException
                    | InvocationTargetException ex) {
                ex.printStackTrace();
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseConflictResolver.class, args);

    }
}
