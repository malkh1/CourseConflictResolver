/**package CourseConflictResolver.Services;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllCombos {

    @Autowired
    private final CourseRecordsRepository courseRepo;
    private List<CourseRecords> courses = new ArrayList<>();

    public AllCombos(CourseRecordsRepository courseRepo){
        this.courseRepo = courseRepo;
    }


    public int showAllCombinations(){

        CourseRecords comp1805A = new CourseRecords();
        comp1805A.setSUBJ("COMP1805A");
        comp1805A.setSTART_TIME("1605");
        comp1805A.setEND_TIME("1725");
        comp1805A.setDAYS("TR");

        CourseRecords comp1805A1 = new CourseRecords();
        comp1805A1.setSUBJ("COMP1805A1");
        comp1805A1.setSTART_TIME("835");
        comp1805A1.setEND_TIME("925");
        comp1805A1.setDAYS("W");

        CourseRecords comp1805A2 = new CourseRecords();
        comp1805A2.setSUBJ("COMP1805A2");
        comp1805A2.setSTART_TIME("1035");
        comp1805A2.setEND_TIME("1125");
        comp1805A2.setDAYS("W");

        CourseRecords comp1805A3 = new CourseRecords();
        comp1805A3.setSUBJ("COMP1805A3");
        comp1805A3.setSTART_TIME("935");
        comp1805A3.setEND_TIME("1025");
        comp1805A3.setDAYS("W");

        CourseRecords comp1805A5 = new CourseRecords();
        comp1805A5.setSUBJ("COMP1805A5");
        comp1805A5.setSTART_TIME("1335");
        comp1805A5.setEND_TIME("1425");
        comp1805A5.setDAYS("W");


        int combos;
        combos = 0;

        for(int i = 0; i < courses.size(); i++){
            for(int j = 0; j < courses.size(); j++){
                if(courses.get(i).getSTART_TIME() == courses.get(j).getSTART_TIME()
                || courses.get(i).getEND_TIME() == courses.get(j).getEND_TIME()
                || courses.get(i).getDAYS() == courses.get(j).getDAYS()
                ){
                    combos++;
                }
            }
        }

        return combos;

    }

}
 */

package CourseConflictResolver.Services;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllCombos {

    @Autowired
    private final CourseRecordsRepository courseRepo;
    private List<CourseRecords> courses = new ArrayList<>();

    public AllCombos(CourseRecordsRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void setCourses(List<CourseRecords> courses) {
        this.courses = courses;
    }

    public int showAllCombinations() {
        int combos = 0;

        for (int i = 0; i < courses.size(); i++) {
            for (int j = i + 1; j < courses.size(); j++) {
                printCombinationDetails(courses.get(i), courses.get(j));
                combos++;
            }
        }

        return combos;
    }

    private void printCombinationDetails(CourseRecords course1, CourseRecords course2) {
        System.out.println("Combination:");
        System.out.println("Course 1: " + course1.getSUBJ() + " " + course1.getDAYS() + " " + course1.getSTART_TIME() + "-" + course1.getEND_TIME());
        System.out.println("Course 2: " + course2.getSUBJ() + " " + course2.getDAYS() + " " + course2.getSTART_TIME() + "-" + course2.getEND_TIME());
        System.out.println("------------------------------");
    }
}
