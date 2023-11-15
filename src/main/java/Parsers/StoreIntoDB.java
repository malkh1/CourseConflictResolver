package Parsers;

import CourseConflictResolver.CourseRecords;
import Repos.CourseRecordsRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import static Parsers.ParseDatasheet.getDataMap;

@Component
public class StoreIntoDB {

    @Autowired
    private CourseRecordsRepository repo;
    @Bean
    public void storeIntoDB(Row row) throws IOException {
        Map<String, String> dataMap = (LinkedHashMap<String, String>) getDataMap(row);
        CourseRecords record = new CourseRecords();
        try {
            BeanUtils.populate(record, dataMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        repo.save(record);
        //System.out.println(dataMap);
    }

}
