package year2024.Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day07/input.txt"));
        long result = 0L;

        while (scanner.hasNext()) {
            var parts = scanner.nextLine().split(":");
            long testValue = Long.parseLong(parts[0].trim());
            List<Long> operators = Arrays.stream(parts[1].trim().split("\\s"))
                    .map(Long::parseLong)
                    .toList();
            if (isPossible(testValue, operators))
                result += testValue;
        }
        System.out.printf("Total calibration result: %d\n", result);
    }

    private static boolean isPossible(Long value, List<Long> operators) {
        var list = new ArrayList<Long>();
        list.add(operators.get(0) + operators.get(1));
        list.add(operators.get(0) * operators.get(1));
        String concatenation = Long.toString(operators.get(0)) + operators.get(1);
        list.add(Long.parseLong(concatenation));

        for (int i = 2; i < operators.size(); i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                var number = list.get(j);
                var sum = operators.get(i) + number;
                if (sum <= value)
                    list.add(sum);
                var multiplication = operators.get(i) * number;
                if (multiplication <= value)
                    list.add(multiplication);
                String concatedString = Long.toString(number) + operators.get(i);
                var concated = Long.parseLong(concatedString);
                if (concated <= value)
                    list.add(concated);
                list.remove(j);
            }
        }
        return (list.contains(value));
    }
}