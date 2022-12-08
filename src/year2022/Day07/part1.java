package year2022.Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day07/input.txt"));
        HashMap<String, Integer> dirs = new HashMap<>();
        List<String> curDir = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.startsWith("$ cd ")) {
                String thisDir = line.split(" ")[2];
                if ("..".equals(thisDir)) {
                    curDir.remove(curDir.size() - 1);
                } else {
                    String prevDir = curDir.size() == 0 ? "" : curDir.get(curDir.size() - 1) + "/";
                    thisDir = prevDir + thisDir;
                    curDir.add(thisDir);
                }
            } else if (line.matches("^\\d.*")) {
                int size = Integer.parseInt(line.split(" ")[0]);
                for (String dir : curDir) {
                    dirs.compute(dir, (k, v) -> (v == null) ? size : v + size);
                }
            }
        }
        int sum = findSum(dirs);
        System.out.printf("Sum of the total sizes of those directories: %d", sum);
    }

    private static int findSum(HashMap<String, Integer> dirs) {
        int sum = 0;
        for (Map.Entry<String,Integer> element : dirs.entrySet()) {
            int value = element.getValue();
            sum = value >= 100_000 ? sum : sum + value;
        }
        return sum;
    }
}