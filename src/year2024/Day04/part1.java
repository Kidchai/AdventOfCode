package year2024.Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day04/input.txt"));
        List<ArrayList<String>> map = new ArrayList<>();

        var directions = new int[]{
                1, 0,   //right
                -1, 0,  //left
                0, -1,  //up
                0, 1,   //down
                1, -1,  //right-up
                1, 1,   //right-down
                -1, -1, //left-up
                -1, 1   //left-down
        };

        var result = 0;
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            map.add(new ArrayList<>(Arrays.asList(line.split(""))));
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals("X")) {
                    for (int z = 0; z < directions.length - 1; z += 2) {
                        if (isXmas(map, i, j, directions[z], directions[z + 1]))
                            result++;
                    }
                }
            }
        }
        System.out.printf("XMAS appear %d times", result);
    }
    private static boolean isXmas(List<ArrayList<String>> map, int i, int j, int dx, int dy) {
        var xmas = "XMAS";

        if (isIndexOutOfBound(map.size(), map.get(i).size(), i, j, dx, dy))
            return false;

        for (int z = 0; z < xmas.length() - 1; z++) {
            var letter = String.valueOf(xmas.charAt(z + 1));
            var symbol = map.get(i + dy).get(j + dx);

            if (!letter.equals(symbol))
                return false;

            i += dy;
            j += dx;
        }
        return true;
    }

    private static boolean isIndexOutOfBound(int height, int width, int i, int j, int dx, int dy) {
        return  i + dy * 3 >= height ||
                i + dy * 3 < 0 ||
                j + dx * 3 >= width ||
                j + dx * 3 < 0;
    }
}