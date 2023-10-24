package com.sysc4907.courseconflictresolver;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohammad
 */
public interface CourseRecordsRepository
        extends CrudRepository<CourseRecords, Long>{
    List<CourseRecords> findByBLDG(String BLDG);
    CourseRecords findByCRN(String CRN);
}
