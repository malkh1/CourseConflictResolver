package UpdatedProject.Parsers;

import java.util.ArrayList;
import java.util.List;

public class BlockInfo {
    public String studentCount;
    public List<String> courses;
    private int combinations;



    private int nonConflictingCombinations;

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

    public int getCombinations(){
        return combinations;
    }
    public void setCombinations(int combinations){
        this.combinations = combinations;
    }    public int getNonConflictingCombinations() {
        return nonConflictingCombinations;
    }

    public void setNonConflictingCombinations(int nonConflictingCombinations) {
        this.nonConflictingCombinations = nonConflictingCombinations;
    }
}