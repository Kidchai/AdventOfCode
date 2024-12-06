package year2024.Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        var position = new ArrayList<Integer>();
        var map = getMap(position);

        var visitedPositions = new HashSet<String>();
        visitedPositions.add(position.get(1) + "," + position.get(0));

        var directions = new ArrayList<List<Integer>>();
        directions.add(Arrays.asList(-1, 0));
        directions.add(Arrays.asList(0, 1));
        directions.add(Arrays.asList(1, 0));
        directions.add(Arrays.asList(0, -1));

        var direction = 0;

        while (true) {
            var nextX = position.get(1) + directions.get(direction).get(1);
            var nextY = position.get(0) + directions.get(direction).get(0);

            if (isEndOfMap(nextX, nextY, map))
                break;

            if (map.get(nextY).get(nextX).equals("#")) {
                direction = (direction == directions.size() - 1) ? 0 : ++direction;
            } else {
                position.set(1, nextX);
                position.set(0, nextY);
                map.get(nextY).set(nextX, "X");
                visitedPositions.add(position.get(1) + "," + position.get(0));
            }
        }

        System.out.printf("Distinct visited positions: %d\n", visitedPositions.size());
        map.forEach(System.out::println);
    }

    private static ArrayList<ArrayList<String>> getMap(ArrayList<Integer> startPosition) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day06/input.txt"));

        var map = new  ArrayList<ArrayList<String>>();
        while (scanner.hasNext()) {
            var line = new ArrayList<>(Arrays.asList(scanner.nextLine().split("")));
            if (line.contains("^")) {
                startPosition.add(map.size());
                startPosition.add(line.indexOf("^"));
                line.set(line.indexOf("^"), "X");
            }
            map.add(line);
        }
        return map;
    }

    private static boolean isEndOfMap(int x, int y, ArrayList<ArrayList<String>> map) {
        return  (x < 0 || y < 0 || x >= map.get(0).size() || y >= map.size());
    }
}