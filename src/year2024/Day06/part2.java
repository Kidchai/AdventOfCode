package year2024.Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        var currentPosition = new ArrayList<Integer>();
        var map = getMap(currentPosition);
        var startPosition = new ArrayList<>(Arrays.asList(currentPosition.get(0), currentPosition.get(1)));

        var visitedPositions = new HashSet<ArrayList<Integer>>();
        visitedPositions.add(new ArrayList<>(Arrays.asList(currentPosition.get(1), currentPosition.get(0))));

        var directions = new ArrayList<List<Integer>>();
        directions.add(Arrays.asList(-1, 0));
        directions.add(Arrays.asList(0, 1));
        directions.add(Arrays.asList(1, 0));
        directions.add(Arrays.asList(0, -1));

        getVisitedPositions(visitedPositions, currentPosition, directions, map);

        var totalObstructions = 0;
        for (var position : visitedPositions) {
            if (position.equals(startPosition)) {
                continue;
            }
            var x = position.get(1);
            var y = position.get(0);

            map.get(y).set(x, "#");

            if (isLooped(visitedPositions, startPosition, directions, map))
                totalObstructions++;
            map.get(y).set(x, ".");
        }
        System.out.printf("Positions for this obstruction: %d\n", totalObstructions);
    }

    private static ArrayList<ArrayList<String>> getMap(ArrayList<Integer> startPosition) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day06/input.txt"));

        var map = new  ArrayList<ArrayList<String>>();
        while (scanner.hasNext()) {
            var line = new ArrayList<>(Arrays.asList(scanner.nextLine().split("")));
            if (line.contains("^")) {
                startPosition.add(map.size());
                startPosition.add(line.indexOf("^"));
            }
            map.add(line);
        }
        return map;
    }

    private static boolean isEndOfMap(int x, int y, ArrayList<ArrayList<String>> map) {
        return  (x < 0 || y < 0 || x >= map.get(0).size() || y >= map.size());
    }

    private static void getVisitedPositions(HashSet<ArrayList<Integer>> visitedPositions, ArrayList<Integer> position, ArrayList<List<Integer>> directions, ArrayList<ArrayList<String>> map) {
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
                if (!map.get(nextX).get(nextY).equals("^"))
                    map.get(nextY).set(nextX, "X");

                visitedPositions.add(new ArrayList<>(Arrays.asList(position.get(0), position.get(1))));
            }
        }
    }

    private static boolean isLooped(HashSet<ArrayList<Integer>> visitedPositions, ArrayList<Integer> position, ArrayList<List<Integer>> directions, ArrayList<ArrayList<String>> map) {
        var direction  = 0;
        var iterations = 0;

        var y = position.get(0);
        var x = position.get(1);

        while (true) {
            var dy = directions.get(direction).get(0);
            var dx = directions.get(direction).get(1);
            var nextY = y + dy;
            var nextX = x + dx;

            if (isEndOfMap(nextX, nextY, map)) {
                return false;
            }
            if (map.get(nextY).get(nextX).equals("#")) {
                direction = (direction + 1) % directions.size();
            } else {
                y = nextY;
                x = nextX;
            }

            iterations++;
            if (iterations > visitedPositions.size() * 2) {
                return true;
            }
        }
    }
}