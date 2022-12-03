package year2022.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day03/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] part1 = line.substring(0, line.length() / 2).toCharArray();
            char[] part2 = line.substring(line.length() / 2).toCharArray();
            char commonType = findCommonItemType(part1, part2);
            sum += commonType > 'Z' ? commonType - 96 : commonType - 38;
        }
        System.out.printf("Sum of the priorities: %d", sum);
    }

    public static char findCommonItemType(char[] part1, char[] part2) {
        Arrays.sort(part1);
        Arrays.sort(part2);
        int i = 0;
        int j = 0;
        while (i < part1.length && j < part2.length) {
            if (part1[i] < part2[j]) {
                i++;
            } else if (part1[i] > part2[j]) {
                j++;
            } else {
                return part1[i];
            }
        }
        return 0;
    }
}