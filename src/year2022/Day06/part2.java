package year2022.Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day06/input.txt"));
        String line = scanner.nextLine();

        int left = 0;
        int right = 14;
        while (right <= line.length()) {
            if (areCharactersUnique(line.substring(left, right))) {
                System.out.printf("Need to process %d characters", right);
                break;
            }
            left++;
            right++;
        }
    }

    private static boolean areCharactersUnique(String s) {
        return s.chars()
                .filter(e -> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1)
                .count() <= 1;
    }
}