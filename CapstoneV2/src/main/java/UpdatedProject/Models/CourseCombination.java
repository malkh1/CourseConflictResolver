package UpdatedProject.Models;

import java.util.List;

public class CourseCombination extends CourseRecords {
    private CourseRecords lecture;
    private List<CourseRecords> labsTutorials;


    public CourseCombination(CourseRecords lecture, List<CourseRecords> labsTutorials) {
        this.lecture = lecture;
        this.labsTutorials = labsTutorials;
    }


    public CourseRecords getLecture() {
        return lecture;
    }

    public void setLecture(CourseRecords lecture) {
        this.lecture = lecture;
    }

    public List<CourseRecords> getLabsTutorials() {
        return labsTutorials;
    }

    public void setLabsTutorials(List<CourseRecords> labsTutorials) {
        this.labsTutorials = labsTutorials;
    }


}