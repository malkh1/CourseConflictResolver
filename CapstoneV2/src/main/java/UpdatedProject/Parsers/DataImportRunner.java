package UpdatedProject.Parsers;

import UpdatedProject.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataImportRunner implements CommandLineRunner {

    @Autowired
    private CourseService courseService;

    @Override
    public void run(String... args) throws Exception {
        String filePath = "src/main/resources/data_source.xlsx";
        courseService.importCoursesFromFile(filePath);
    }
}
