package year2022.Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
    private static final char[][] crt = new char[6][40];
    private static int cycles = 0;
    private static int currentCycleRow = 40;
    private static int register = 1;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day10/input.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.startsWith("addx")) {
                addx(Integer.parseInt(line.split(" ")[1]));
            } else {
                noop();
            }
        }
        printCrt();
    }

    private static void addx(int value) {
        for (int i = 0; i < 2; i++) {
            cycles++;
            drawPixel();
        }
        register += value;
    }

    private static void noop() {
        cycles++;
        drawPixel();
    }

    private static void drawPixel() {
        int currentCycle = cycles - (currentCycleRow - 40) - 1;
        int row = (currentCycleRow / 40) - 1;
        switch (currentCycle - register) {
            case 0, 1, -1 -> crt[row][currentCycle] = '#';
            default -> crt[row][currentCycle] = '.';
        }

        if (currentCycleRow / (row + 1)  == currentCycle + 1) {
            currentCycleRow += 40;
        }
    }

    private static void printCrt() {
        for (char[] line : crt) {
            for (char pixel : line) {
                System.out.print(pixel);
            }
            System.out.print("\n");
        }
    }
}
