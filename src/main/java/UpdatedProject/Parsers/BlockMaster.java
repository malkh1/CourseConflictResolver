package UpdatedProject.Parsers;

import UpdatedProject.Parsers.BlockInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

@Component
public class BlockMaster {
    public static LinkedHashMap<String, BlockInfo> readBlockMaster(String filePath) throws IOException {
        LinkedHashMap<String, BlockInfo> blockDetails = new LinkedHashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        for (Row row : sheet) {
            Cell blockCell = row.getCell(0);
            Cell termCell = row.getCell(3);
            Cell countCell = row.getCell(2);

            if (blockCell == null || termCell == null || countCell == null) continue;

            String blockName = formatter.formatCellValue(blockCell).trim();
            String termInfo = formatter.formatCellValue(termCell).trim();
            String studentCount = formatter.formatCellValue(countCell).trim();

            if (blockName.startsWith("SYSC Block")) {
                String blockNumber = blockName.replace("SYSC Block ", "").trim();
                String term = termInfo.length() > 0 ? termInfo.substring(termInfo.length() - 1) : "";
                String key = blockNumber + term;

                BlockInfo blockInfo = blockDetails.getOrDefault(key, new BlockInfo(studentCount));

                for (int i = 4; i <= 9; i++) {
                    Cell courseCell = row.getCell(i);
                    if (courseCell != null) {
                        String course = formatter.formatCellValue(courseCell).trim();
                        if (!course.isEmpty()) {
                            String courseWithoutSection = course.replaceAll("[A-Z]$", "");
                            blockInfo.getCourses().add(courseWithoutSection);
                        }
                    }
                }

                blockDetails.put(key, blockInfo);
            }
        }

        workbook.close();
        fis.close();
        return blockDetails;
    }

}
