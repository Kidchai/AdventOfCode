package year2021.Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day03part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("inputDay03.txt"));
        String oxygenGeneratorRating; // the most common
        String CO2scrubberRating; // the least common
        ArrayList<String> indices = new ArrayList<>();
        while (scanner.hasNext()) {
            indices.add(scanner.nextLine());
        }
        ArrayList<String> indices1 = (ArrayList<String>) indices.clone();
        for (int j = 0; indices.size() != 1; j++) {
            int count0 = 0;
            int count1 = 0;
            for (String index : indices) {
                if (index.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            for (int i = indices.size() - 1; i >= 0; i--) {
                if (count1 > count0 || count0 == count1) {
                    if (indices.get(i).charAt(j) == '0') {
                        indices.remove(i);
                    }
                } else {
                    if (indices.get(i).charAt(j) == '1') {
                        indices.remove(i);
                    }
                }
            }
        }
        oxygenGeneratorRating = indices.get(0);
        int oxygenGeneratorRatingDecimal = Integer.parseInt(oxygenGeneratorRating, 2);
        for (int j = 0; indices1.size() != 1; j++) {
            int count0 = 0;
            int count1 = 0;
            for (String s : indices1) {
                if (s.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            for (int i = indices1.size() - 1; i >= 0; i--) {
                if (count0 > count1) {
                    if (indices1.get(i).charAt(j) == '0') {
                        indices1.remove(i);
                    }
                } else {
                    if (indices1.get(i).charAt(j) == '1') {
                        indices1.remove(i);
                    }
                }
            }
        }
        CO2scrubberRating = indices1.get(0);
        int CO2scrubberRatingDecimal = Integer.parseInt(CO2scrubberRating, 2);
        int lifeSupportRating = oxygenGeneratorRatingDecimal * CO2scrubberRatingDecimal;
        System.out.println(lifeSupportRating);
    }
}
