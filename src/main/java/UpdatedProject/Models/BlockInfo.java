package UpdatedProject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlockInfo {

    @Id
    @GeneratedValue
    private Long Id;
    private String blockId;
    private String studentCount;
    public List<String> courses;
    private int combinations;
    private int nonConflictingCombinations;
    private int earliestClass;
    private int latestClass;

    public BlockInfo() {
        super();
    }

    public BlockInfo(String studentCount) {
        this.studentCount = studentCount;
        this.courses = new ArrayList<>();
    }

    
    public String getStudentCount() {
        return studentCount;
    }

    public List<String> getCourses() {
        return courses;
    }

    public int getCombinations() {
        return combinations;
    }

    public void setCombinations(int combinations) {
        this.combinations = combinations;
    }

    public int getNonConflictingCombinations() {
        return nonConflictingCombinations;
    }

    public void setNonConflictingCombinations(int nonConflictingCombinations) {
        this.nonConflictingCombinations = nonConflictingCombinations;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getEarliestClass() {
        return earliestClass;
    }

    public void setEarliestClass(int earliestClass) {
        this.earliestClass = earliestClass;
    }

    public int getLatestClass() {
        return latestClass;
    }

    public void setLatestClass(int latestClass) {
        this.latestClass = latestClass;
    }
}
