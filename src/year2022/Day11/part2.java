package year2022.Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class part2 {
    private static final List<Monkey> monkeys = new ArrayList<>();
    private static int lcm = 1;

    public static void main(String[] args) throws FileNotFoundException {
        parseInput();
        for (Monkey monkey : monkeys) {
            lcm *= monkey.divider;
        }
        for (int i = 0; i < 10_000; i++) {
            for (Monkey monkey : monkeys) {
                while (!monkey.items.isEmpty()) {
                    monkey.items.set(0, monkey.increaseWorryLevel() % lcm);
                    long item = monkey.items.get(0);
                    int recipient = monkey.isDivisible() ? monkey.trueThrow : monkey.falseThrow;
                    monkeys.get(recipient).items.add(item);
                    monkey.items.remove(item);
                }
            }
        }
        monkeys.sort(Collections.reverseOrder());
        System.out.printf("Level of monkey business: %d", (long) monkeys.get(0).inspected * monkeys.get(1).inspected);
    }

    private static void parseInput() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day11/input.txt"));
        while (scanner.hasNext()) {
            scanner.nextLine();
            List<Long> items = Arrays.stream(scanner.nextLine().substring(18).split(", "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());

            String operation = scanner.nextLine().substring(23);
            int divider = Integer.parseInt(scanner.nextLine().substring(21));
            int trueThrow = Integer.parseInt(scanner.nextLine().substring(29));
            int falseThrow = Integer.parseInt(scanner.nextLine().substring(30));
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            monkeys.add(new Monkey(items, operation, divider, trueThrow, falseThrow));
        }
    }
}
