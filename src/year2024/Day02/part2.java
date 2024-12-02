package year2024.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2024/Day02/input.txt"));

        var totalSafeReports = 0;

        while (scanner.hasNext()) {
            var levels = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
            if (isSafe(levels)) {
                totalSafeReports++;
            }
        }
        System.out.printf("Safe reports: %d", totalSafeReports);
    }

    private static boolean isSafe(List<String> levels) {

        if (isValid(levels)) {
            return true;
        }

        for (int i = 0; i < levels.size(); i++) {
            List<String> copyLevels = new ArrayList<>(levels);
            copyLevels.remove(i);
            if (isValid(copyLevels)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(List<String> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = Integer.parseInt(levels.get(i + 1)) - Integer.parseInt(levels.get(i));

            if (Math.abs(diff) > 3) {
                return false;
            }

            if (diff < 0) {
                isIncreasing = false;
            } else if (diff > 0) {
                isDecreasing = false;
            } else {
                return false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}