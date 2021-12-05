package adventofcode.year2021.Day04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day04part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner (new File("testinputDay04.txt"));
        String stringDrawNumbers = scanner.nextLine();
        String[] stringArrayDrawNumbers = stringDrawNumbers.split(",", 0);
        int[] drawNumbers = new int[stringArrayDrawNumbers.length];
        for (int i = 0; i < stringArrayDrawNumbers.length; i++) {
            drawNumbers[i] = Integer.parseInt(stringArrayDrawNumbers[i]);
        }

        ArrayList<String> allBoards = new ArrayList<>();
        while (scanner.hasNext()) {
            allBoards.add(scanner.nextLine().strip());
        }

        for (int i = allBoards.size() - 1; i >= 0; i--) {
            if (allBoards.get(i).isEmpty()) {
                allBoards.remove(i);
            }
        }

        int[][][] boardSet = new int[allBoards.size() / 5][5][5];
        for (int i = 0; i < 5; i++) {
            String[] stringAllBoards = allBoards.get(i).split(" +", 0);
            for (int k = 0; k < 5; k++) {
                boardSet[0][i][k] = Integer.parseInt(stringAllBoards[k]);
            }

        }



    }
}
/*
принять в качестве ввода числа, которые будут называться
записать их в коллекцию
принимать в цикле do while

доски это коллекция двумерных массивов, где размер коллекции - число досок
размер массива - 5 на 5
 */