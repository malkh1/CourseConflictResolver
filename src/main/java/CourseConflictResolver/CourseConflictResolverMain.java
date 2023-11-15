package CourseConflictResolver;

import Parsers.ParseCombinations;
import Parsers.ParseDatasheet;

/**
 *
 * @author Mohammad Alkhaledi
 * @author Waleed Majbour
 */
public class CourseConflictResolverMain {
    public static void main(String[] args) {
        System.out.println("Printing Course Info...\n");
        ParseDatasheet.main(new String[]{});
        System.out.println("---------------------------------------------------------\n");
        System.out.println("Printing Course Combinations...\n");
        ParseCombinations.main(new String[]{});

    }
}
