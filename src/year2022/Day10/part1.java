package year2022.Day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    private static int cycles = 0;
    private static int targetCycle = 20;
    private static int register = 1;
    private static int signalsStrengthSum = 0;

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
        System.out.printf("The sum of these signal strengths is %d", signalsStrengthSum);
    }

    private static void addx(int value) {
        for (int i = 0; i < 2; i++) {
            cycles++;
            calculateSignalStrengthSum();
        }
        register += value;
    }

    private static void noop() {
        cycles++;
        calculateSignalStrengthSum();
    }

    private static void calculateSignalStrengthSum() {
        if (cycles != targetCycle) {
            return;
        }
        signalsStrengthSum += targetCycle * register;
        targetCycle += 40;
    }
}