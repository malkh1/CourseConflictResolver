package CourseConflictResolver.Services;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class StoreIntoDB {

    @Autowired
    private final CourseRecordsRepository repo;
    
    public StoreIntoDB(CourseRecordsRepository repo) {
        this.repo = repo;
    }
    
    public void storeIntoDB(Map<String, String> dataMap) throws IOException, IllegalAccessException, InvocationTargetException {
        Map<String, String> rowMap = dataMap;
        CourseRecords record = new CourseRecords();
        BeanUtils.populate(record, rowMap); 
        repo.save(record);
        //System.out.println(dataMap);
    }

}
