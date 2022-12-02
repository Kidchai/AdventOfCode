package year2021.Day01;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Day01part1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        int number1 = scanner.nextInt();
        int counter = 0;
	while(scanner.hasNextInt()) {
        int number2 = scanner.nextInt();
        if (number2 > number1) {
            counter++;
        }
        number1 = number2;
    }
    System.out.println(counter);
    }
}
