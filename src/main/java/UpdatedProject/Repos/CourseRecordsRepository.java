package UpdatedProject.Repos;

import UpdatedProject.Models.CourseRecords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Mohammad
 */
@Repository
public interface CourseRecordsRepository extends CrudRepository<CourseRecords, Long>{
    @Query("SELECT c FROM CourseRecords c WHERE c.SUBJ = :subj AND c.CRSE = :crse AND c.TERM = :term")
    List<CourseRecords> findBySubjAndCrseAndTerm(@Param("subj") String subj,
                                                 @Param("crse") String crse,
                                                 @Param("term") String term);


    @Query("SELECT c FROM CourseRecords c WHERE c.SUBJ = :subj AND c.CRSE = :crse AND c.TERM = :term AND (c.SEQ LIKE CONCAT(:seq, '%') OR c.LNK_ID = :seq)")
    List<CourseRecords> findLabsTutorialsForLecture(@Param("subj") String subj,
                                                    @Param("crse") String crse,
                                                    @Param("term") String term,
                                                    @Param("seq") String seq);

    }


