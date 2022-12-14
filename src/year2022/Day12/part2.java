package year2022.Day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {
    private static List<List<Square>> map = new ArrayList<>();
    private static Square startSquare;

    public static void main(String[] args) throws FileNotFoundException {
        map = populateMap();
        Queue<Square> queue = new ArrayDeque<>();
        queue.add(startSquare);
        startSquare.discovered = true;
        boolean isDestinationReached = false;
        int[] steps = new int[10000];
        int targetId = -1;
        while (!queue.isEmpty() && !isDestinationReached) {
            Square square = queue.poll();
            for (Square adjSquare : getAdjacent(square)) {
                if (!adjSquare.discovered) {
                    adjSquare.discovered = true;
                    adjSquare.prev = square;
                    if (adjSquare.getElevation() == 'a') {
                        isDestinationReached = true;
                        targetId = adjSquare.getId();
                    }
                    queue.add(adjSquare);
                    steps[adjSquare.getId()] = steps[square.getId()] + 1;
                }
            }
        }
        System.out.printf("This path reaches the goal in %d steps, the fewest possible.", steps[targetId]);
    }

    private static List<List<Square>> populateMap() throws FileNotFoundException {
        List<List<Square>> map = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/year2022/Day12/input.txt"));
        int rowId = 0;
        int id = 0;
        while (scanner.hasNext()) {
            String row = scanner.nextLine();
            map.add(new ArrayList<>());
            for (int i = 0; i < row.length(); i++) {
                map.get(rowId).add(new Square(id, rowId, i, row.charAt(i)));
                if (row.charAt(i) == 'E') {
                    startSquare = map.get(rowId).get(i);
                }
                id++;
            }
            rowId++;
        }
        return map;
    }

    public static List<Square> getAdjacent(Square square) {
        List<Square> list = new ArrayList<>();
        int x = square.getX();
        int y = square.getY();
        if (y != 0) {
            list.add(map.get(y - 1).get(x)); //up
        }
        if (x != 0) {
            list.add(map.get(y).get(x - 1)); //left
        }
        if (y != map.size() - 1) {
            list.add(map.get(y + 1).get(x)); //down
        }
        if (x != map.get(0).size() - 1) {
            list.add(map.get(y).get(x + 1)); //right
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (square.getElevation() - list.get(i).getElevation() > 1) {
                list.remove(i);
            }
        }
        return list;
    }
}
