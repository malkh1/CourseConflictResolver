package Repos;

import java.util.List;

import CourseConflictResolver.CourseRecords;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohammad
 */
public interface CourseRecordsRepository extends CrudRepository<CourseRecords, Long>{
    List<CourseRecords> findByBLDG(String BLDG);
    CourseRecords findByCRN(String CRN);
}
