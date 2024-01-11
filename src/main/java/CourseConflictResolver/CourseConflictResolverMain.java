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

            CourseRecords Ecor4995A = new CourseRecords();
            Ecor4995A.setSUBJ("ECOR4995A");
            Ecor4995A.setSTART_TIME("1800");
            Ecor4995A.setEND_TIME("2100");
            Ecor4995A.setDAYS("W");

            CourseRecords Ecor4995B = new CourseRecords();
            Ecor4995B.setSUBJ("ECOR4995B");
            Ecor4995B.setSTART_TIME("1800");
            Ecor4995B.setEND_TIME("2100");
            Ecor4995B.setDAYS("W");

            CourseRecords comp1805A3 = new CourseRecords();
            comp1805A3.setSUBJ("COMP1805A3");
            comp1805A3.setSTART_TIME("935");
            comp1805A3.setEND_TIME("1025");
            comp1805A3.setDAYS("W");

            CourseRecords Sysc4001A = new CourseRecords();
            Sysc4001A.setSUBJ("SYSC4001A");
            Sysc4001A.setDAYS("M");
            Sysc4001A.setSTART_TIME("835");
            Sysc4001A.setEND_TIME("1000");

            CourseRecords Sysc4001B = new CourseRecords();
            Sysc4001B.setSUBJ("SYSC4001B");
            Sysc4001B.setDAYS("T");
            Sysc4001B.setSTART_TIME("835");
            Sysc4001B.setEND_TIME("1000");

            CourseRecords Sysc4002A = new CourseRecords();
            Sysc4002A.setSUBJ("SYSC4002A");
            Sysc4002A.setDAYS("M");
            Sysc4002A.setSTART_TIME("835");
            Sysc4002A.setEND_TIME("1000");


            CourseRecords Sysc4002B = new CourseRecords();
            Sysc4002B.setSUBJ("SYSC4002B");
            Sysc4002B.setDAYS("W");
            Sysc4002B.setSTART_TIME("835");
            Sysc4002B.setEND_TIME("1000");


            List<CourseRecords> selectedCourses = new ArrayList<>();
            selectedCourses.add(comp1805A);
            selectedCourses.add(Ecor4995A);
            selectedCourses.add(Ecor4995B);
            selectedCourses.add(comp1805A3);
            selectedCourses.add(Sysc4001A);
            selectedCourses.add(Sysc4001B);
            selectedCourses.add(Sysc4002A);
            selectedCourses.add(Sysc4002B);

            AllCombos allCombos = new AllCombos(repo);
            allCombos.setCourses(selectedCourses);
            int numberOfCombinations = allCombos.showAllCombinations();
            int checkConflicts = allCombos.checkForConflicts();
            int viableSchedules = allCombos.conCurrentCourses();
            System.out.println("-----------------------------");
            System.out.println("Number of possible combinations, ignoring conflicts: " + numberOfCombinations);
            System.out.println("-----------------------------");
            System.out.println("Number of conflicting courses: " + checkConflicts);
            System.out.println("-----------------------------");
            System.out.println("Number of viable schedules: " + viableSchedules);
            //System.out.println("Printing Course Combinations...\n");
            //ParseCombinations.main(new String[]{});

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseConflictResolverMain.class, args);
    }
}
