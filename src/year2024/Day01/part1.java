package year2024.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2024/Day01/input.txt"));

        var pQueue1 = new PriorityQueue<Integer>();
        var pQueue2 = new PriorityQueue<Integer>();

        while (scanner.hasNext()) {
            String[] numbers = scanner.nextLine().split("\\s+");
            pQueue1.add(Integer.parseInt(numbers[0]));
            pQueue2.add(Integer.parseInt(numbers[1]));
        }

        var totalDiff = 0;

        while (!pQueue1.isEmpty()) {
            var diff = pQueue1.poll() - pQueue2.poll();
            diff = (diff < 0) ? diff * -1 : diff;
            totalDiff += diff;
        }
        System.out.printf("Total distance: %d", totalDiff);
    }
}