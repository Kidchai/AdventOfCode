package year2021.Day01;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Day01part2 {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/year2021/Day01/numbers.txt"));
        while(scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        int counter = 0;
        int number1 = numbers.get(0) + numbers.get(1) + numbers.get(2);
        for (int i = 0; i + 2 < numbers.size() - 1; i++) {
            int number2 = numbers.get(i + 1) + numbers.get(i + 2) + numbers.get(i + 3);
            if (number2 > number1) {
                counter++;
            }
            number1 = number2;
        }
        System.out.println(counter);
    }
}
