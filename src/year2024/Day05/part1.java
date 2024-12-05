package year2024.Day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day05/input.txt"));
        var map = getRules(scanner);

        var totalSum = 0;
        while (scanner.hasNext()) {
            var pages = Arrays.asList(scanner.nextLine().split(","));
            var isCorrect = true;
            for (int i = 0; i < pages.size() && isCorrect; i++) {
                if (!map.containsKey(pages.get(i)))
                    continue;
                for (String num : map.get(pages.get(i))) {
                    if (!pages.contains(num) || pages.indexOf(num) >= i)
                        continue;
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                var middleIndex = pages.size() / 2;
                totalSum += Integer.parseInt(pages.get(middleIndex));
            }
        }
        System.out.printf("Middle pages sum from correctly-ordered updates: %d", totalSum);
    }

    private static HashMap<String, ArrayList<String>> getRules(Scanner scanner) {
        var map = new  HashMap<String, ArrayList<String>>();
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            if (line.isEmpty())
                break;
            var numbers = line.split("\\|");
            var key = numbers[0];
            var value = numbers[1];
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        return map;
    }
}