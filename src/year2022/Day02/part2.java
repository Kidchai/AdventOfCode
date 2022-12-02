package year2022.Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
    private static final int ROCK = 65;
    private static final int PAPER = 66;
    private static final int SCISSORS = 67;

    private static final int ROCK_SCORE = 1;
    private static final int PAPER_SCORE = 2;
    private static final int SCISSORS_SCORE = 3;

    private static final int WIN = 88;
    private static final int DRAW = 89;
    private static final int LOSE = 90;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day02/input.txt"));
        int sum = 0;
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int a = line[0].charAt(0);
            int b = line[1].charAt(0);
            sum += getRoundScore(a, b);
        }
        System.out.printf("Total score: %d", sum);
    }

    public static int getRoundScore(int a, int b) {
        return switch (b) {
            case WIN -> getLoseScore(a);
            case DRAW -> getDrawScore(a);
            case LOSE -> getWinScore(a);
            default -> throw new IllegalStateException("Unexpected value: " + b);
        };
    }

    public static int getLoseScore(int a) {
        int LOSE_SCORE = 0;
        return LOSE_SCORE + switch (a) {
            case ROCK -> SCISSORS_SCORE;
            case PAPER -> ROCK_SCORE;
            case SCISSORS -> PAPER_SCORE;
            default -> throw new IllegalStateException("Unexpected value: " + a);
        };
    }

    public static int getDrawScore(int a) {
        int DRAW_SCORE = 3;
        return DRAW_SCORE + switch (a) {
            case ROCK -> ROCK_SCORE;
            case PAPER -> PAPER_SCORE;
            case SCISSORS -> SCISSORS_SCORE;
            default -> throw new IllegalStateException("Unexpected value: " + a);
        };
    }

    public static int getWinScore(int a) {
        int WIN_SCORE = 6;
        return WIN_SCORE + switch (a) {
            case ROCK -> PAPER_SCORE;
            case PAPER -> SCISSORS_SCORE;
            case SCISSORS -> ROCK_SCORE;
            default -> throw new IllegalStateException("Unexpected value: " + a);
        };
    }
}