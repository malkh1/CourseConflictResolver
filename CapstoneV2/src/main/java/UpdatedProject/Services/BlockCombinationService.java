package UpdatedProject.Services;

import UpdatedProject.Models.CourseCombination;
import UpdatedProject.Models.CourseRecords;
import UpdatedProject.Parsers.BlockInfo;
import UpdatedProject.Parsers.BlockMaster;
import UpdatedProject.Repos.CourseRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BlockCombinationService {

    @Autowired
    private static BlockMaster blockMaster;

    @Autowired
    private static CourseRecordsRepository courseRecordsRepository;

    public BlockCombinationService(BlockMaster blockMaster, CourseRecordsRepository courseRecordsRepository){
        this.blockMaster = blockMaster;
        this.courseRecordsRepository = courseRecordsRepository;
    }
    public LinkedHashMap<String, BlockInfo> calculateAllCombinations(String blockMasterPath) throws IOException {
        LinkedHashMap<String, BlockInfo> blockDetails = blockMaster.readBlockMaster(blockMasterPath);

        blockDetails.forEach((block, info) -> {
            String term = extractTermFromBlock(block);
            List<CourseRecords> nonConflictingCourses = new ArrayList<>();

            int totalCombinations = 1;
            for (String courseCode : info.getCourses()) {
                // Assuming courseCode is structured as "SUBJCRSE", e.g., "ECOR2050"
                String subj = courseCode.substring(0, 4); // Extracting SUBJ
                String crse = courseCode.substring(4);    // Extracting CRSE
                List<CourseRecords> sections = courseRecordsRepository.findBySubjAndCrseAndTerm(subj, crse, term);
                sections.forEach(lecture -> {
                    List<CourseRecords> labSections = courseRecordsRepository.findLabsTutorialsForLecture(subj, crse, term, lecture.getSEQ());
                    if(!labSections.isEmpty()){
                        labSections.forEach(lab -> {
                            CourseCombination combination = new CourseCombination(lecture, List.of(lab));
                            combination.setLecture(lecture);
                            combination.setLabsTutorials(List.of(lab));
                            nonConflictingCourses.add(combination);
                        });
                    }else{
                        CourseCombination combination = new CourseCombination(lecture, new ArrayList<>());
                        combination.setLecture(lecture);
                        combination.setLabsTutorials(new ArrayList<>());
                        nonConflictingCourses.add(combination);
                    }


                });
                if(!sections.isEmpty()){
                    totalCombinations *= sections.size();
                }else{
                    totalCombinations = 0;
                    break;
                }
                nonConflictingCourses.addAll(sections);
            }
            int nonConflictingCombinations = countNonConflictingCombinations(nonConflictingCourses);
            info.setNonConflictingCombinations(nonConflictingCombinations);
            info.setCombinations(totalCombinations);
        });
        return blockDetails;
    }

    private String extractTermFromBlock(String block){
        return block.substring(block.length() - 1);
    }

    private static boolean daysOverlap(String days1, String days2) {
        Set<Character> daySet1 = days1.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        Set<Character> daySet2 = days2.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        daySet1.retainAll(daySet2);
        return !daySet1.isEmpty();
    }
    private static boolean hasConflict(CourseRecords section1, CourseRecords section2) {

        if (section1.getTERM() == null || section2.getTERM() == null) {
            return false;
        }


        if (!section1.getTERM().equals(section2.getTERM())) return false;


        if (section1.getDAYS() == null || section2.getDAYS() == null) {
            return false;
        }


        if (!daysOverlap(section1.getDAYS(), section2.getDAYS())) return false;


        String startTime1Str = (section1.getSTART_TIME() != null && section1.getSTART_TIME().length() < 4) ? "0" + section1.getSTART_TIME() : section1.getSTART_TIME();
        String endTime1Str = (section1.getEND_TIME() != null && section1.getEND_TIME().length() < 4) ? "0" + section1.getEND_TIME() : section1.getEND_TIME();
        String startTime2Str = (section2.getSTART_TIME() != null && section2.getSTART_TIME().length() < 4) ? "0" + section2.getSTART_TIME() : section2.getSTART_TIME();
        String endTime2Str = (section2.getEND_TIME() != null && section2.getEND_TIME().length() < 4) ? "0" + section2.getEND_TIME() : section2.getEND_TIME();


        if (startTime1Str == null || endTime1Str == null || startTime2Str == null || endTime2Str == null) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        LocalTime startTime1 = LocalTime.parse(startTime1Str, formatter);
        LocalTime endTime1 = LocalTime.parse(endTime1Str, formatter);
        LocalTime startTime2 = LocalTime.parse(startTime2Str, formatter);
        LocalTime endTime2 = LocalTime.parse(endTime2Str, formatter);


        return !(startTime1.isAfter(endTime2) || endTime1.isBefore(startTime2));
    }


    public static int countNonConflictingCombinations(List<CourseRecords> sections) {
        int nonConflictingCount = 0;


        for (int i = 0; i < sections.size(); i++) {
            for (int j = i + 1; j < sections.size(); j++) {
                if (!hasConflict(sections.get(i), sections.get(j))) {

                    nonConflictingCount++;
                }
            }
        }

        return nonConflictingCount;
    }

}
