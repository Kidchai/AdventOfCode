package year2022.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day01/input.txt"));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int buf = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                maxHeap.add(buf);
                buf = 0;
            } else {
                buf += Integer.parseInt(line);
            }
        }
        maxHeap.add(buf);

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += maxHeap.remove();
        }

        System.out.printf("%d calories", result);
    }
}
