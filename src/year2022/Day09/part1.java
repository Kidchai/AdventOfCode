package year2022.Day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class part1 {
    private static final Set<String> set = new HashSet<>();
    private static final int[] head = new int[]{0, 0};
    private static final int[] tail = new int[]{0, 0};

    public static void main(String[] args) throws FileNotFoundException {
        set.add(tail[0] + "" + tail[1]);

        Scanner scanner = new Scanner(new File("src/year2022/Day09/input.txt"));
        while (scanner.hasNext()) {
            moveHead(scanner.next(), scanner.nextInt());
        }
        System.out.printf("%d positions the tail visited at least once.", set.size());
    }

    private static void moveHead(String direction, int value) {
        for (int i = 0; i < value; i++) {
            switch (direction) {
                case "R" -> head[0]++;
                case "L" -> head[0]--;
                case "U" -> head[1]++;
                case "D" -> head[1]--;
            }
            if (!isTaleCloseToHead()) {
                moveTale(direction);
            }
        }
    }

    private static boolean isTaleCloseToHead() {
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

    private static void moveTale(String direction) {
        int x1 = tail[0];
        int y1 = tail[1];
        int x2 = head[0];
        int y2 = head[1];
        if (x1 == x2 || y1 == y2) {
            switch (direction) {
                case "R" -> tail[0]++;
                case "L" -> tail[0]--;
                case "U" -> tail[1]++;
                case "D" -> tail[1]--;
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
        set.add(tail[0] + " " + tail[1]);
    }
}