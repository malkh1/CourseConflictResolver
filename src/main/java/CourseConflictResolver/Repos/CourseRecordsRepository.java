package CourseConflictResolver.Repos;

import java.util.List;

import CourseConflictResolver.Models.CourseRecords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammad
 */
@Repository
public interface CourseRecordsRepository extends CrudRepository<CourseRecords, Long>{
    List<CourseRecords> findByBLDG(String BLDG);
    CourseRecords findByCRN(String CRN);
}
