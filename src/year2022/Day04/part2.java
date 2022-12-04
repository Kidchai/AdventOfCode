package year2022.Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day04/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            String[] assignments = scanner.nextLine().split(",");
            int[] elf1 = getIntArray(assignments[0]);
            int[] elf2 = getIntArray(assignments[1]);
            if (isOverlapped(elf1[0], elf1[1], elf2[0], elf2[1])) {
                sum++;
            }
        }
        System.out.printf("Total pairs: %d", sum);
    }

    private static int[] getIntArray(String line) {
        return Arrays.stream(line.split("-"))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static boolean isOverlapped(int x1, int x2, int y1, int y2) {
        return (x2 >= y1 && x2 <= y2) || (y2 >= x1 && y2 <= x2);
    }
}