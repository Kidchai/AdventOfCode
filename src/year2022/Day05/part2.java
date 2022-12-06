package year2022.Day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class part2 {
    private static final List<String[]> commands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> stringCrates = parseInput();
        List<Stack<String>> crates = getCrates(stringCrates);
        implementCommands(crates);
        String topCrates = getTopCrates(crates);

        System.out.printf("Crates on top of each stack: %s", topCrates);
    }

    private static List<String> parseInput() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2022/Day05/input.txt"));
        List<String> stringCrates = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            stringCrates.add(line);
            if (line.startsWith(" 1")) {
                scanner.nextLine();
                break;
            }
        }

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            commands.add(line.substring(5).split("\\D+"));
        }
        return stringCrates;
    }

    private static List<Stack<String>> getCrates(List<String> stringCrates) {
        List<Stack<String>> crates = new ArrayList<>();
        String[] last = stringCrates.get(stringCrates.size() - 1).substring(1).split("\s+");
        for (String number : last) {
            crates.add(new Stack<>());
        }

        for (int i = stringCrates.size() - 2; i >= 0; i--) {
            String line = stringCrates.get(i);
            int stack = 0;
            for (int j = 1; j < line.length(); j += 4) {
                String element = String.valueOf(line.charAt(j));
                if (element.matches("[A-Z]")) {
                    crates.get(stack).push(element);
                }
                stack++;
            }
        }
        return crates;
    }

    private static void implementCommands(List<Stack<String>> crates) {
        for (String[] command : commands) {
            int quantity = Integer.parseInt(command[0]);
            int sourceStack = Integer.parseInt(command[1]) - 1;
            int targetStack = Integer.parseInt(command[2]) - 1;
            Stack<String> buf = new Stack<>();
            for (int i = 0; i < quantity; i++) {
                buf.push(crates.get(sourceStack).pop());
            }

            while (!buf.empty()) {
                crates.get(targetStack).push(buf.pop());
            }
        }
    }

    private static String getTopCrates(List<Stack<String>> crates) {
        StringBuilder sb = new StringBuilder();
        for (Stack<String> stack : crates) {
            sb.append(stack.peek());
        }
        return sb.toString();
    }
}