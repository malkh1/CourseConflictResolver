package CourseConflictResolver;

import CourseConflictResolver.Models.CourseRecords;
import CourseConflictResolver.Parsers.ParseCombinations;
import CourseConflictResolver.Parsers.ParseDatasheet;
import CourseConflictResolver.Services.StoreIntoDB;
import CourseConflictResolver.Repos.CourseRecordsRepository;
import java.io.FileInputStream;
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
            parseDatasheet.parseDataSheet(fileInputStream);
            System.out.println("---------------------------------------------------------\n");
            System.out.println("Printing Course Combinations...\n");
            ParseCombinations.main(new String[]{});

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseConflictResolverMain.class, args);
    }
}
