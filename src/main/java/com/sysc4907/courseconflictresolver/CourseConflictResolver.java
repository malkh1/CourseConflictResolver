package com.sysc4907.courseconflictresolver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Mohammad
 */
@SpringBootApplication
public class CourseConflictResolver {

    @Bean
    public CommandLineRunner demo(CourseRecordsRepository repo) {
        return (args) -> {
            System.out.println("Hello World!");
            Parser parser = new Parser("src/main/resources/data_source.xlsx");

            try {

                var courseMap = parser.getColumnHeaderMap();

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
                    //System.out.println(dataMap);
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
