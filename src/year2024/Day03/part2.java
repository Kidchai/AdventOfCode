package year2024.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        var scanner = new Scanner(new File("src/year2024/Day03/input.txt"));

        var result = 0;
        var isInstructionEnabled = true;
        while (scanner.hasNext()) {
            var line = scanner.nextLine();

            var sequencePatternString = "mul\\(\\d{1,3},\\d{1,3}\\)";
            var instructionPatternString = "do\\(\\)|don't\\(\\)";

            var combinedPatternString = instructionPatternString + "|" + sequencePatternString;
            var combinedPattern = Pattern.compile(combinedPatternString);
            var combinedMatcher = combinedPattern.matcher(line);

            while (combinedMatcher.find()) {
                var matched = combinedMatcher.group();

                if (matched.equals("do()"))
                    isInstructionEnabled = true;
                else if (matched.equals("don't()"))
                    isInstructionEnabled = false;
                else if (isInstructionEnabled && matched.startsWith("mul")) {
                    var string = combinedMatcher.group();
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
        }
        System.out.printf("Results of the multiplications: %d", result);
    }
}