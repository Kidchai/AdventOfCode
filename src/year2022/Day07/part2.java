package year2022.Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {
    private static final int SPACE = 70_000_000;
    private static final int UNUSED_SPACE = 30_000_000;

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
        int dirSize = findDir(dirs);
        System.out.printf("Size of directory for deletion: %d", dirSize);
    }

    private static int findDir(HashMap<String, Integer> dirs) {
        int spaceToDelete = UNUSED_SPACE-  (SPACE - dirs.get("/"));
        return findSmallestDir(dirs, spaceToDelete);
    }

    private static int findSmallestDir(HashMap<String, Integer> dirs, int spaceToDelete) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String,Integer> element : dirs.entrySet()) {
            int dirSize = element.getValue();
            int differ = dirSize - spaceToDelete;
            if (differ >= 0 && differ < min - spaceToDelete) {
                min = dirSize;
            }
        }
        return min;
    }
}