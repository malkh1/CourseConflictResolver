package CourseConflictResolver;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Parsers.ParseCombinations;
import CourseConflictResolver.Parsers.ParseDatasheet;
import CourseConflictResolver.Services.AllCombos;
import CourseConflictResolver.Services.StoreIntoDB;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Mohammad Alkhaledi
 * @author Waleed Majbour
 */
@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class})
public class CourseConflictResolverMain {

    @Bean
    public CommandLineRunner run(CourseRecordsRepository repo) {
        return (args) -> {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/data_source.xlsx");
            StoreIntoDB dB = new StoreIntoDB(repo);
            ParseDatasheet parseDatasheet = new ParseDatasheet(dB);
            
            System.out.println("Printing Course Info...\n");
            //parseDatasheet.parseDataSheet(fileInputStream);
            System.out.println("---------------------------------------------------------\n");


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
            comp1805A5.setSTART_TIME("935");
            comp1805A5.setEND_TIME("1025");
            comp1805A5.setDAYS("W");

            List<CourseRecords> selectedCourses = new ArrayList<>();
            selectedCourses.add(comp1805A);
            selectedCourses.add(comp1805A1);
            selectedCourses.add(comp1805A2);
            selectedCourses.add(comp1805A3);
            selectedCourses.add(comp1805A5);

            AllCombos allCombos = new AllCombos(repo);
            allCombos.setCourses(selectedCourses);
            int numberOfCombinations = allCombos.showAllCombinations();
            int checkConflicts = allCombos.checkForConflicts();
            System.out.println("Number of all possible combinations: " + numberOfCombinations);
            System.out.println("Conflicting Courses: " + checkConflicts);
            //System.out.println("Printing Course Combinations...\n");
            //ParseCombinations.main(new String[]{});

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseConflictResolverMain.class, args);
    }
}
