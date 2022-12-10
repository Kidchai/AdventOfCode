package year2022.Day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class part2 {
    private static final Set<String> set = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        int[][] knots = new int[10][2];
        Scanner scanner = new Scanner(new File("src/year2022/Day09/input.txt"));
        while (scanner.hasNext()) {
            String direction = scanner.next();
            int value = scanner.nextInt();
            for (int i = 0; i < value; i++) {
                switch (direction) {
                    case "R" -> knots[0][0]++;
                    case "L" -> knots[0][0]--;
                    case "U" -> knots[0][1]++;
                    case "D" -> knots[0][1]--;
                }
                for (int j = 1; j < knots.length; j++) {
                    if (!isTaleCloseToHead(knots[j], knots[j - 1])) {
                        knots[j] = moveTale(knots[j], knots[j - 1]);
                    } else {
                        break;
                    }
                }
                set.add(knots[9][0] + " " + knots[9][1]);
            }
        }
        System.out.printf("%d positions the tail visited at least once.", set.size());
    }

    private static boolean isTaleCloseToHead(int[] tail, int[] head) {
        int x1 = tail[0];
        int y1 = tail[1];
        int x2 = head[0];
        int y2 = head[1];
        if (x1 == x2 && y1 == y2) { //overlapping
            return true;
        } else if ((y1 == y2 + 1 || y1 == y2 - 1) && x1 == x2) { //up-down
            return true;
        } else if ((x1 == x2 + 1 || x1 == x2 - 1) && y1 == y2) { //left-right
            return true;
        } else if ((x1 == x2 + 1 && y1 == y2 + 1) || (x1 == x2 - 1 && y1 == y2 - 1)) {
            return true;
        } else return x1 == x2 - 1 && y1 == y2 + 1 || (x1 == x2 + 1 && y1 == y2 - 1);
    }

    private static int[] moveTale(int[] tail, int[] head) {
        int x1 = tail[0];
        int y1 = tail[1];
        int x2 = head[0];
        int y2 = head[1];
        if (x1 == x2 || y1 == y2) {
            if (y1 == y2 + 2) { //down
                tail[1]--;
            } else if (y1 == y2 - 2) { //up
                tail[1]++;
            } else if (x1 == x2 + 2) { //left
                tail[0]--;
            } else if (x1 == x2 - 2) { //right
                tail[0]++;
            }
        } else if (x1 < x2 && y1 < y2) {
            tail[0]++;
            tail[1]++;
        } else if (x1 > x2 && y1 > y2) {
            tail[0]--;
            tail[1]--;
        } else if (x1 < x2) {
            tail[0]++;
            tail[1]--;
        } else {
            tail[0]--;
            tail[1]++;
        }
        return tail;
    }
}