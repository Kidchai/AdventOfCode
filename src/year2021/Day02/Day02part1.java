package year2021.Day02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("inputDay02.txt"));
        int horizontalPosition = 0;
        int depth = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            int value = Integer.parseInt(strings[1]);
            String command = strings[0];
            switch(command){
                case "forward" :
                    horizontalPosition += value;
                    break;
                case "up" :
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
            }
        }
        System.out.println(horizontalPosition * depth);
    }
}