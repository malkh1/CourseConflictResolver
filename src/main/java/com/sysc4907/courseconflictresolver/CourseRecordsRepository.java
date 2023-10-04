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
    List<CourseRecords> findBySTARTTIME(String STARTTIME);
    List<CourseRecords> findByENDTIME(String ENDTIME);
    List<CourseRecords> findBySTARTDATE(String STARTDATE);
    List<CourseRecords> findByENDDATE(String ENDDATE);
}
