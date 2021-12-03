package adventofcode.year2021.Day03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Day03part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("inputDay03.txt"));
        ArrayList<Integer> index0 = new ArrayList<>();
        ArrayList<Integer> index1 = new ArrayList<>();
        ArrayList<Integer> index2 = new ArrayList<>();
        ArrayList<Integer> index3 = new ArrayList<>();
        ArrayList<Integer> index4 = new ArrayList<>(); //11
        ArrayList<Integer> index5 = new ArrayList<>();
        ArrayList<Integer> index6 = new ArrayList<>();
        ArrayList<Integer> index7 = new ArrayList<>();
        ArrayList<Integer> index8 = new ArrayList<>();
        ArrayList<Integer> index9 = new ArrayList<>();
        ArrayList<Integer> index10 = new ArrayList<>();
        ArrayList<Integer> index11 = new ArrayList<>();
        int count0;
        int count1;
        String gammaRate = ""; //самый частый элемент
        String epsilonRate = ""; //самый редкий элемент
        while (scanner.hasNext()) {
            StringBuilder element = new StringBuilder(scanner.nextLine());
            index0.add(Character.getNumericValue(element.charAt(0)));
            index1.add(Character.getNumericValue(element.charAt(1)));
            index2.add(Character.getNumericValue(element.charAt(2)));
            index3.add(Character.getNumericValue(element.charAt(3)));
            index4.add(Character.getNumericValue(element.charAt(4)));
            index5.add(Character.getNumericValue(element.charAt(5)));
            index6.add(Character.getNumericValue(element.charAt(6)));
            index7.add(Character.getNumericValue(element.charAt(7)));
            index8.add(Character.getNumericValue(element.charAt(8)));
            index9.add(Character.getNumericValue(element.charAt(9)));
            index10.add(Character.getNumericValue(element.charAt(10)));
            index11.add(Character.getNumericValue(element.charAt(11)));
        }
        count0 = Collections.frequency(index0, 0);
        count1 = Collections.frequency(index0, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index1, 0);
        count1 = Collections.frequency(index1, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index2, 0);
        count1 = Collections.frequency(index2, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index3, 0);
        count1 = Collections.frequency(index3, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index4, 0);
        count1 = Collections.frequency(index4, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index5, 0);
        count1 = Collections.frequency(index5, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index6, 0);
        count1 = Collections.frequency(index6, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index7, 0);
        count1 = Collections.frequency(index7, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index8, 0);
        count1 = Collections.frequency(index8, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index9, 0);
        count1 = Collections.frequency(index9, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index10, 0);
        count1 = Collections.frequency(index10, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        count0 = Collections.frequency(index11, 0);
        count1 = Collections.frequency(index11, 1);

        if (count0 > count1) {
            gammaRate += "0";
            epsilonRate += "1";
        } else {
            gammaRate += "1";
            epsilonRate += "0";
        }

        int gammaRateDecimal = Integer.parseInt(gammaRate, 2);
        int epsilonRateDecimal = Integer.parseInt(epsilonRate, 2);
        int powerConsumption = gammaRateDecimal * epsilonRateDecimal;
        System.out.println(powerConsumption);
    }
}