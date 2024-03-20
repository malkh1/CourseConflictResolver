package UpdatedProject.Services;

import UpdatedProject.Models.CourseRecords;
import UpdatedProject.Repos.CourseRecordsRepository;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRecordsRepository courseRepository;

    @Transactional
    public List<CourseRecords> importCoursesFromFile(String filePath) {
        FileInputStream fis = null;
        List<CourseRecords> courses = new ArrayList<>();
        try {
            
            fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            for (Row row : sheet) {
                CourseRecords course = new CourseRecords();
                
                String termCode = formatter.formatCellValue(row.getCell(2));
                String term = convertTermCodeToLetter(termCode);
                
                course.setTERM(term);
                course.setCRN(formatter.formatCellValue(row.getCell(3)));
                course.setSUBJ(formatter.formatCellValue(row.getCell(4)));
                course.setCRSE(formatter.formatCellValue(row.getCell(5)));
                course.setSEQ(formatter.formatCellValue(row.getCell(6)));
                course.setINSTR_TYPE(formatter.formatCellValue(row.getCell(17)));
                course.setDAYS(formatter.formatCellValue(row.getCell(18)));
                course.setSTART_TIME(formatter.formatCellValue(row.getCell(19)));
                course.setEND_TIME(formatter.formatCellValue(row.getCell(20)));
                
                courses.add(course);
                courseRepository.save(course);
            }   
            workbook.close();
            fis.close();

        } catch (IOException ex) {}
        return courses;
    }

    private String convertTermCodeToLetter(String termCode){
        return switch (termCode) {
            case "202330" -> "F";
            case "202410" -> "W";
            default -> "Unknown";
        };
    }
}
