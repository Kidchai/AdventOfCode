package year2024.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2024/Day02/input.txt"));

        var totalSafeReports = 0;

        while (scanner.hasNext()) {
            String[] levels = scanner.nextLine().split("\\s+");

            var isSafe = true;
            var isIncreasing = false;
            var isDecreasing = false;

            var prev = Integer.parseInt(levels[0]);
            for (int i = 1; i < levels.length; i++) {
                int current = Integer.parseInt(levels[i]);

                if (current > prev) {
                    isDecreasing = true;
                    if (current - prev > 3) {
                        isSafe = false;
                        break;
                    }
                } else if (current < prev) {
                    isIncreasing = true;
                    if (prev - current > 3) {
                        isSafe = false;
                        break;
                    }
                } else {
                    isSafe = false;
                    break;
                }
                if (isDecreasing && isIncreasing) {
                    isSafe = false;
                    break;
                }
                prev = current;
            }
            if (isSafe) {
                totalSafeReports++;
            }
        }

        System.out.printf("Safe reports: %d", totalSafeReports);
    }
}