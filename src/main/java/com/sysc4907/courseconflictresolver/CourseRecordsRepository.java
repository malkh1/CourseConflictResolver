package com.sysc4907.courseconflictresolver;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohammad
 */
public interface CourseRecordsRepository extends CrudRepository<String, String>{
    String findByCRN();
}
