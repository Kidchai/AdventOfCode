package year2022.Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {
    private static int maxScenicScore = 0;
    private static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day08/input.txt"));
        map = new ArrayList<>();
        int lineId = -1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lineId++;
            map.add(new ArrayList<>());
            for (int i = 0; i < line.length(); i++) {
                String element = String.valueOf(line.charAt(i));
                map.get(lineId).add(Integer.parseInt(element));
            }
        }
        findMaxScenicScore();
        System.out.printf("Highest scenic score: %d", maxScenicScore);
    }

    private static void findMaxScenicScore() {
        int lines = map.get(0).size();
        int columns = map.size();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                findScore(i, j);
            }
        }
    }

    private static void findScore(int i, int j) {
        int height = map.get(i).get(j);
        int left = checkLeft(height, i, j, 0);
        int right = checkRight(height, i, j, 0);
        int up = checkUp(height, i, j, 0);
        int down = checkDown(height, i, j, 0);
        maxScenicScore = Math.max(maxScenicScore, left * right * up * down);
    }

    private static int checkLeft(int height, int i, int j, int score) {
        if (j > 0) {
            if (map.get(i).get(j - 1) >= height) {
                return ++score;
            }
            return checkLeft(height, i, j - 1, ++score);
        }
        return score;
    }

    private static int checkRight(int height, int i, int j, int score) {
        if (j < map.get(i).size() - 1) {
            if (map.get(i).get(j + 1) >= height) {
                return ++score;
            }
            return checkRight(height, i, j + 1, ++score);
        }
        return score;
    }

    private static int checkUp(int height, int i, int j, int score) {
        if (i > 0) {
            if (map.get(i - 1).get(j) >= height) {
                return ++score;
            }
            return checkUp(height, i - 1, j, ++score);
        }
        return score;
    }

    private static int checkDown(int height, int i, int j, int score) {
        if (i < map.size() - 1) {
            if (map.get(i + 1).get(j) >= height) {
                return ++score;
            }
            return checkDown(height, i + 1, j, ++score);
        }
        return score;
    }
}