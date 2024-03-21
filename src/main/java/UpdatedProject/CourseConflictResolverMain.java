package UpdatedProject;

import UpdatedProject.Models.CourseRecords;
import UpdatedProject.Models.BlockInfo;
import UpdatedProject.Repos.BlockInfoRepository;
import UpdatedProject.Repos.CourseRecordsRepository;
import UpdatedProject.Services.BlockCombinationService;
import UpdatedProject.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mohammad Alkhaledi
 * @author Waleed Majbour
 */
@SpringBootApplication
public class CourseConflictResolverMain {

    @Autowired
    private CourseService courseService;

    @Autowired
    private BlockCombinationService blockCombinationService;
    
    @Autowired
    private BlockInfoRepository blockRepo; 

    @Bean
    public CommandLineRunner run(CourseRecordsRepository repo) {
        return (args) -> {
            String dataSource = "src/main/resources/data_source.xlsx";
            List<CourseRecords> courses = courseService.importCoursesFromFile(dataSource);
            
            String blockMasterPath = "src/main/resources/BlockMaster.xlsx";
            LinkedHashMap<String, BlockInfo> blockDetails = blockCombinationService.calculateAllCombinations(blockMasterPath);   
            blockRepo.saveAll(blockDetails.values());
            System.out.println("site ready");
//            blockDetails.forEach((block, info) -> {
//                System.out.print(block + "   " + info.getStudentCount() + "  -  " + info.getCombinations() + "  " + info.getNonConflictingCombinations() + " - ");
//                info.getCourses().forEach(course -> System.out.print(course + " "));
//                System.out.println();
//                info.setBlockId(block);
//                blockRepo.save(info);
//            });
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseConflictResolverMain.class, args);
    }
}
