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
            comp1805A.setCRSE("1805");
            comp1805A.setINSTR_TYPE("LEC");
            comp1805A.setSTART_TIME("1605");
            comp1805A.setEND_TIME("1725");
            comp1805A.setDAYS("TR");

            CourseRecords Ecor4995A = new CourseRecords();
            Ecor4995A.setSUBJ("ECOR4995A");
            Ecor4995A.setCRSE("4995");
            Ecor4995A.setINSTR_TYPE("LEC");
            Ecor4995A.setSTART_TIME("1800");
            Ecor4995A.setEND_TIME("2100");
            Ecor4995A.setDAYS("W");

            CourseRecords Ecor4995B = new CourseRecords();
            Ecor4995B.setSUBJ("ECOR4995B");
            Ecor4995B.setCRSE("4995");
            Ecor4995B.setINSTR_TYPE("LEC");
            Ecor4995B.setSTART_TIME("1800");
            Ecor4995B.setEND_TIME("2100");
            Ecor4995B.setDAYS("W");

            CourseRecords Sysc4504 = new CourseRecords();
            Sysc4504.setSUBJ("COMP1805A3");
            Sysc4504.setCRSE("4504");
            Sysc4504.setSTART_TIME("935");
            Sysc4504.setINSTR_TYPE("LEC");
            Sysc4504.setEND_TIME("1025");
            Sysc4504.setDAYS("W");

            CourseRecords Sysc4001A = new CourseRecords();
            Sysc4001A.setSUBJ("SYSC4001A");
            Sysc4001A.setCRSE("4001");
            Sysc4001A.setDAYS("M");
            Sysc4001A.setINSTR_TYPE("LEC");
            Sysc4001A.setSTART_TIME("835");
            Sysc4001A.setEND_TIME("1000");

            CourseRecords Sysc4001B = new CourseRecords();
            Sysc4001B.setSUBJ("SYSC4001B");
            Sysc4001B.setCRSE("4001");
            Sysc4001B.setDAYS("T");
            Sysc4001B.setINSTR_TYPE("LEC");
            Sysc4001B.setSTART_TIME("835");
            Sysc4001B.setEND_TIME("1000");


            CourseRecords Sysc4002A = new CourseRecords();
            Sysc4002A.setSUBJ("SYSC4002A");
            Sysc4002A.setCRSE("4002");
            Sysc4002A.setINSTR_TYPE("LEC");
            Sysc4002A.setDAYS("M");
            Sysc4002A.setSTART_TIME("835");
            Sysc4002A.setEND_TIME("1000");

            CourseRecords Sysc4002B = new CourseRecords();
            Sysc4002B.setSUBJ("SYSC4002B");
            Sysc4002B.setCRSE("4002");
            Sysc4002B.setINSTR_TYPE("LEC");
            Sysc4002B.setDAYS("W");
            Sysc4002B.setSTART_TIME("835");
            Sysc4002B.setEND_TIME("1000");
            Sysc4002B.setLNK_ID("AA");
            Sysc4002B.setLNK_CONN("LA");


            CourseRecords Sysc4002B1 = new CourseRecords();
            Sysc4002B1.setSUBJ("SYSC4002B1");
            Sysc4002B1.setCRSE("4002");
            Sysc4002B1.setINSTR_TYPE("LAB");
            Sysc4002B1.setDAYS("F");
            Sysc4002B1.setSTART_TIME("835");
            Sysc4002B1.setEND_TIME("1000");
            Sysc4002B1.setLNK_ID("LA");
            Sysc4002B1.setLNK_CONN("AA");


            List<CourseRecords> selectedCourses = new ArrayList<>();
            selectedCourses.add(comp1805A);
            selectedCourses.add(Ecor4995A);
            selectedCourses.add(Ecor4995B);
            selectedCourses.add(Sysc4504);
            selectedCourses.add(Sysc4001A);
            selectedCourses.add(Sysc4001B);
            selectedCourses.add(Sysc4002A);
            selectedCourses.add(Sysc4002B);
            selectedCourses.add(Sysc4002B1);

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
