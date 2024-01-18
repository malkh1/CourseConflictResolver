package CourseConflictResolver.Services;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private int scheduleNum = 0;

    public int showAllCombinations() {

        int combos = 0;

        for (int i = 0; i < courses.size(); i++) {
            for (int j = i + 1; j < courses.size(); j++) {
                for (int k = j + 1; k < courses.size(); k++){
                    for (int l = k + 1; l < courses.size(); l++){
                        for (int m = l + 1; m < courses.size(); m++){
                            //printCombinationDetails(courses.get(i), courses.get(j), courses.get(k), courses.get(l), courses.get(m));
                            combos++;
                        }
                    }
                }
            }
        }

        return combos;
    }

    public int checkForConflicts(){

        int conflicts = 0;

        for (int i = 0; i < courses.size(); i++){
            for (int j = i + 1; j < courses.size(); j++){

                if(isConflicting(courses.get(i), courses.get(j))){
                    printConflictDetails(courses.get(i), courses.get(j));
                    System.out.println("-----------------------------");
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    private boolean isConflicting(CourseRecords course1, CourseRecords course2){
        if(course1.getDAYS().equals(course2.getDAYS())){
            int start1 = Integer.parseInt(course1.getSTART_TIME());
            int end1 = Integer.parseInt(course1.getEND_TIME());
            int start2 = Integer.parseInt(course2.getSTART_TIME());
            int end2 = Integer.parseInt(course2.getEND_TIME());

            if((start1 >= start2 && start1 < end2) || (end1 > start2 && end1 <= end2) || (start2 >= start1 && start2 < end1)
            || (end2 > start1 && end2 <= end1)){
                return true;
            }
        }
        return false;
    }

    public void checkForLNKID(CourseRecords course, List<CourseRecords> concurrentCourses){
        if(course.getLNK_ID() != null) {
            if (course.getINSTR_TYPE().equals("LEC")) {
                for (CourseRecords course2 : concurrentCourses) {
                    if (course2.getINSTR_TYPE().equals("LAB")) {
                        if (course.getLNK_ID().equals(course2.getLNK_CONN()) && course.getCRSE().equals(course2.getCRSE())) {
                            System.out.println("No further registration is required for " + course.getSUBJ());
                        }else{
                            System.out.println("Registration for a Lab and/or tutorial is required for " + course.getSUBJ());
                        }
                    }
                }
            }
        }

    }


    public int conCurrentCourses() {

        int schedules = 0;
        List<CourseRecords> concurrentCourses = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            for (int j = i + 1; j < courses.size(); j++) {
                for (int k = j + 1; k < courses.size(); k++) {
                    for (int l = k + 1; l < courses.size(); l++) {
                        for (int m = l + 1; m < courses.size(); m++) {
                            concurrentCourses.clear();
                            concurrentCourses.add(courses.get(i));
                            concurrentCourses.add(courses.get(j));
                            concurrentCourses.add(courses.get(k));
                            concurrentCourses.add(courses.get(l));
                            concurrentCourses.add(courses.get(m));

                            if (!scheduleHasConflicts(concurrentCourses)){
                                printConcurrentCourses(concurrentCourses);
                                System.out.println("-----------------------------");
                                schedules++;
                            }

                        }
                    }
                }
            }
        }
        return schedules;
    }

    private boolean scheduleHasConflicts(List<CourseRecords> courses){
        for (int i = 0; i < courses.size(); i++) {
            for (int j = i + 1; j < courses.size(); j++) {
                if (isConflicting(courses.get(i), courses.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }



    /*private void printCombinationDetails(CourseRecords course1, CourseRecords course2, CourseRecords course3,
                                        CourseRecords course4, CourseRecords course5) {
            System.out.println("Combination:");
            System.out.println("Course 1: " + course1.getSUBJ() + " " + course1.getDAYS() + " " + course1.getSTART_TIME() + "-" + course1.getEND_TIME());
            System.out.println("Course 2: " + course2.getSUBJ() + " " + course2.getDAYS() + " " + course2.getSTART_TIME() + "-" + course2.getEND_TIME());
            System.out.println("Course 3: " + course3.getSUBJ() + " " + course3.getDAYS() + " " + course3.getSTART_TIME() + "-" + course3.getEND_TIME());
            System.out.println("Course 4: " + course4.getSUBJ() + " " + course4.getDAYS() + " " + course4.getSTART_TIME() + "-" + course4.getEND_TIME());
            System.out.println("Course 5: " + course5.getSUBJ() + " " + course5.getDAYS() + " " + course5.getSTART_TIME() + "-" + course5.getEND_TIME());
            System.out.println("------------------------------");
    }*/

    private void printConflictDetails(CourseRecords course1, CourseRecords course2){
        System.out.println("Conflict: ");
        System.out.println("Course 1: " + course1.getSUBJ() + " " + course1.getDAYS() + " " + course1.getSTART_TIME() + " " + course1.getEND_TIME());
        System.out.println("Course 2: " + course2.getSUBJ() + " " + course2.getDAYS() + " " + course2.getSTART_TIME() + " " + course2.getEND_TIME());
    }

    private void printConcurrentCourses(List<CourseRecords> concurrentCourses){
        System.out.println("Schedule: " + scheduleNum);
        System.out.println("");

        for (CourseRecords course : concurrentCourses) {
            System.out.println("Course: " + course.getSUBJ());
            checkForLNKID(course, concurrentCourses);
            System.out.println("");

        }
        scheduleNum++;
    }

}
