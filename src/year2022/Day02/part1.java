package year2022.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day02/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int a = line[0].charAt(0);
            int b = convert(line[1].charAt(0));
            sum += getRoundScore(a, b);
        }
        System.out.printf("Total score: %d", sum);
    }

    public static int getRoundScore(int a, int b) {
        int outcomeScore = findOutcomeScore(a, b);
        return outcomeScore + b - 64;
    }

    public static int convert(int b) {
        return switch (b) {
            case 88 -> 65;
            case 89 -> 66;
            case 90 -> 67;
            default -> 0;
        };
    }

    public static int findOutcomeScore(int a, int b) {
        return switch (b - a) {
            case 0 -> 3;
            case 1, -2 -> 6;
            default -> 0;
        };
    }
}