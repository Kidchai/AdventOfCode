package year2024.Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day04/input.txt"));
        List<ArrayList<String>> map = new ArrayList<>();
        var diagonal1 = new int[]{
                -1, -1,
                1, 1,
        };
        var diagonal2 = new int[]{
                -1, 1,
                1, -1,
        };

        var result = 0;
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            map.add(new ArrayList<>(Arrays.asList(line.split(""))));
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals("A")) {

                    if (isXmas(map, i, j, diagonal1) && isXmas(map, i, j, diagonal2))
                        result++;

                }
            }
        }
        System.out.printf("XMAS appear %d times", result);
    }
    private static boolean isXmas(List<ArrayList<String>> map, int i, int j, int[] directions) {
        var isS = false;
        var isM = false;

        if (i == 0 || j == 0 || i == map.size() - 1 || j == map.get(i).size() - 1)
            return false;

        for (int z = 0; z < directions.length; z += 2) {
            var dx = directions[z];
            var dy = directions[z + 1];
            var symbol = map.get(i + dy).get(j + dx);

            if (symbol.equals("S"))
                isS = true;
            else if (symbol.equals("M"))
                isM = true;
        }
        return isS && isM;
    }
}