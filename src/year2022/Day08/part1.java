package year2022.Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    private static ArrayList<ArrayList<Tree>> map;

    private static class Tree {
        private final int height;
        private boolean isVisible;

        public Tree(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public void setIsVisible(boolean isVisible) {
            this.isVisible = isVisible;
        }
    }

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
                map.get(lineId).add(new Tree(Integer.parseInt(element)));
            }
        }
        setVisibilityToEdges();
        setVisibility(map.get(0).size() - 1, map.size() - 1);
        int visibleTrees = countTrees();
        System.out.printf("Visible trees: %d", visibleTrees);
    }

    private static void setVisibilityToEdges() {
        int lineSize = map.get(0).size();
        int columnSize = map.size();

        for (int i = 0; i < lineSize; i++) {
            map.get(0).get(i).setIsVisible(true);
        }
        for (int i = 0; i < lineSize; i++) {
            map.get(columnSize - 1).get(i).setIsVisible(true);
        }
        for (int i = 0; i < lineSize; i++) {
            map.get(i).get(0).setIsVisible(true);
        }
        for (int i = 0; i < lineSize; i++) {
            map.get(i).get(lineSize - 1).setIsVisible(true);
        }
    }

    private static void setVisibility(int lineSize, int columnSize) {
        int i = 1;
        while (i < columnSize) {
            for (int j = 1; j < lineSize; j++) {
                checkVisibility(i, j);
            }
            i++;
        }
    }

    private static void checkVisibility(int i, int j) {
        int height = map.get(i).get(j).getHeight();

        if (j == map.get(0).size() - 1) {
            if (height > map.get(i).get(j + 1).getHeight()) {
                map.get(i).get(j).setIsVisible(true);
                return;
            }
        }
        if (checkLeft(height, i, j) || checkRight(height, i, j) ||
                checkUp(height, i, j) || checkDown(height, i, j)) {
            map.get(i).get(j).setIsVisible(true);
        }
    }

    private static boolean checkLeft(int height, int i, int j) {
        if (j > 0) {
            if (map.get(i).get(j - 1).height >= height) {
                return false;
            }
            return checkLeft(height, i, j - 1);
        }
        return true;
    }

    private static boolean checkRight(int height, int i, int j) {
        if (j < map.get(i).size() - 1) {
            if (map.get(i).get(j + 1).height >= height) {
                return false;
            }
            return checkRight(height, i, j + 1);
        }
        return true;
    }

    private static boolean checkUp(int height, int i, int j) {
        if (i > 0) {
            if (map.get(i - 1).get(j).height >= height) {
                return false;
            }
            return checkUp(height, i - 1, j);
        }
        return true;
    }

    private static boolean checkDown(int height, int i, int j) {
        if (i < map.size() - 1) {
            if (map.get(i + 1).get(j).height >= height) {
                return false;
            }
            return checkDown(height, i + 1, j);
        }
        return true;
    }

    private static int countTrees() {
        int visibleTrees = 0;
        for (int i = 0; i < map.get(0).size(); i++) {
            for (int j = 0; j < map.size(); j++) {
                if (map.get(i).get(j).isVisible) {
                    visibleTrees++;
                }
            }
        }
        return visibleTrees;
    }
}