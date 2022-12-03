package year2022.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day03/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            char[] line1 = scanner.nextLine().toCharArray();
            char[] line2 = scanner.nextLine().toCharArray();
            char[] line3 = scanner.nextLine().toCharArray();
            char badgeType = findBadgeItemType(line1, line2, line3);
            sum += badgeType > 'Z' ? badgeType - 96 : badgeType - 38;
        }
        System.out.printf("Sum of the priorities: %d", sum);
    }

    public static char findBadgeItemType(char[] line1, char[] line2, char[] line3) {
        Arrays.sort(line1);
        Arrays.sort(line2);
        Arrays.sort(line3);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < line1.length && j < line2.length && k < line3.length) {
            if (line1[i] < line2[j]) {
                i++;
            } else if (line1[i] > line2[j]) {
                j++;
            } else if (line2[j] < line3[k]) {
                j++;
            } else if (line2[j] > line3[k]) {
                k++;
            } else {
                return line1[i];
            }
        }
        return 0;
    }
}
