package year2022.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day01/input.txt"));

        int max = 0;
        int buf = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                max = Math.max(max, buf);
                buf = 0;
            } else {
                buf += Integer.parseInt(line);
            }
        }
        max = Math.max(max, buf);
        System.out.printf("%d calories", max);
    }
}