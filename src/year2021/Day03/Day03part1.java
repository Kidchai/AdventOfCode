package year2021.Day03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Day03part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("inputDay03.txt"));
        ArrayList<ArrayList<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            indices.add(new ArrayList<>());
        }
        StringBuilder gammaRate = new StringBuilder(); //the most common bit in the corresponding position
        StringBuilder epsilonRate = new StringBuilder(); //the least common bit in the corresponding position
        while (scanner.hasNext()) {
            StringBuilder element = new StringBuilder(scanner.nextLine());
            for (int i = 0; i < 12; i++) {
                indices.get(i).add(Character.getNumericValue(element.charAt(i)));
            }
        }
        for (int i = 0; i < 12; i++) {
            int count0 = Collections.frequency(indices.get(i), 0);
            int count1 = Collections.frequency(indices.get(i), 1);
            if (count0 > count1) {
                gammaRate.append("0");
                epsilonRate.append("1");
            } else {
                gammaRate.append("1");
                epsilonRate.append("0");
            }
        }
        int gammaRateDecimal = Integer.parseInt(gammaRate.toString(), 2);
        int epsilonRateDecimal = Integer.parseInt(epsilonRate.toString(), 2);
        int powerConsumption = gammaRateDecimal * epsilonRateDecimal;
        System.out.println(powerConsumption);
    }
}