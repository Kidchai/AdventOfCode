package year2024.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day03/input.txt"));

        var result = 0;
        while (scanner.hasNext()) {
            var line = scanner.nextLine();
            var patternString = "mul\\(\\d{1,3},\\d{1,3}\\)";

            var sequencePattern = Pattern.compile(patternString);
            var sequenceMatcher = sequencePattern.matcher(line);

            while (sequenceMatcher.find()) {
                var string = sequenceMatcher.group();
                var numberPattern = Pattern.compile("\\d{1,3}");
                var numberMatcher = numberPattern.matcher(string);

                var num1 = 0;
                var num2 = 0;

                if (numberMatcher.find())
                    num1 = Integer.parseInt(numberMatcher.group());

                if (numberMatcher.find())
                    num2 = Integer.parseInt(numberMatcher.group());

                result += num1 * num2;
            }
        }
        System.out.printf("Results of the multiplications: %d", result);
    }
}