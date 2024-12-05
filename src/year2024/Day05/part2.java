package year2024.Day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day05/input.txt"));
        var map = getRules(scanner);

        var totalSum = 0;
        while (scanner.hasNext()) {
            var pages = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            var isIncorrectlyOrdered = isOrderIncorrect(pages, map);

            if (isIncorrectlyOrdered) {
                var reorderedPages = reorderPages(pages, map);
                var middleIndex = reorderedPages.size() / 2;
                totalSum += Integer.parseInt(reorderedPages.get(middleIndex));
            }
        }
        System.out.printf("Middle pages sum from correctly-ordered updates: %d", totalSum);
    }

    private static HashMap<String, ArrayList<String>> getRules(Scanner scanner) {
        var map = new HashMap<String, ArrayList<String>>();
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

    private static boolean isOrderIncorrect(ArrayList<String> pages, HashMap<String, ArrayList<String>> map) {
        for (int i = 0; i < pages.size(); i++) {
            if (!map.containsKey(pages.get(i)))
                continue;

            for (String num : map.get(pages.get(i))) {
                if (!pages.contains(num) || pages.indexOf(num) >= i)
                    continue;
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> reorderPages(ArrayList<String> pages, HashMap<String, ArrayList<String>> map) {
        var isReordered = false;
        for (int i = 0; i < pages.size() && !isReordered; i++) {
            if (!map.containsKey(pages.get(i)))
                continue;

            for (String num : map.get(pages.get(i))) {
                if (!pages.contains(num) || pages.indexOf(num) >= i)
                    continue;

                isReordered = true;
                pages.add(i + 1, num);
                pages.remove(num);
                pages = reorderPages(pages, map);
                break;
            }
        }
        return pages;
    }
}