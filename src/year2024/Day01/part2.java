package year2024.Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2024/Day01/input.txt"));

        var list1 = new ArrayList<Integer>();
        var list2 = new HashMap<Integer, Integer>();

        while (scanner.hasNext()) {
            String[] numbers = scanner.nextLine().split("\\s+");
            list1.add(Integer.parseInt(numbers[0]));
            var num = Integer.parseInt(numbers[1]);
            list2.put(num, list2.getOrDefault(num, 0) + 1);
        }

        var totalSimilarity = 0;
        for (Integer num : list1) {
            var amount = list2.get(num);
            if (amount == null) {
                continue;
            }
            var similarity = num * amount;
            totalSimilarity += similarity;
        }
        System.out.printf("Total similarity: %d", totalSimilarity);
    }
}