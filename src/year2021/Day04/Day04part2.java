package year2021.Day04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day04part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/year2021/Day04/inputDay04.txt"));
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

        ArrayList<int[][]> boardSet = new ArrayList<>();
        for (int i = 0; i < allBoards.size() / 5; i++) {
            boardSet.add(new int[5][5]);
        }
        for (int j = boardSet.size() - 1; j >= 0; j--) {
            for (int i = 0; i < 5; i++) {
                String[] stringAllBoards = allBoards.get(i + 5 * j).split(" +", 0);
                for (int k = 0; k < 5; k++) {
                    boardSet.get(j)[i][k] = Integer.parseInt(stringAllBoards[k]);
                }
            }
        }
        for (int x : drawNumbers) {
            for (int i = boardSet.size() - 1;  i >= 0; i--) {
                boolean shouldRemove = false;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (boardSet.get(i)[j][k] == x) {
                            boardSet.get(i)[j][k] = -1;
                            boolean bingo = true;
                            for (int j2 = 0; j2 < 5; j2++) {
                                if (boardSet.get(i)[j2][k] != -1) {
                                    bingo = false;
                                }
                            }
                            if (bingo && boardSet.size() != 1) {
                                shouldRemove = true;
                            }
                            if (bingo && boardSet.size() == 1) {
                                int sum = 0;
                                for (int j2 = 0; j2 < 5; j2++) {
                                    for (int k2 = 0; k2 < 5; k2++) {
                                        if (boardSet.get(0)[j2][k2] != -1) {
                                            sum += boardSet.get(0)[j2][k2];
                                        }
                                    }
                                }
                                sum *= x;
                                printBingoBoards(boardSet);
                                System.out.println(sum);
                                return;
                            }
                            bingo = true;
                            for (int k2 = 0; k2 < 5; k2++) {
                                if (boardSet.get(i)[j][k2] != -1) {
                                    bingo = false;
                                }
                            }
                            if (bingo && boardSet.size() != 1) {
                                shouldRemove = true;
                            }
                            if (bingo && boardSet.size() == 1) {
                                int sum = 0;
                                for (int j2 = 0; j2 < 5; j2++) {
                                    for (int k2 = 0; k2 < 5; k2++) {
                                        if (boardSet.get(0)[j2][k2] != -1) {
                                            sum += boardSet.get(0)[j2][k2];
                                        }
                                    }
                                }
                                sum *= x;
                                printBingoBoards(boardSet);
                                System.out.println(sum);
                                return;
                            }
                        }
                    }
                }
                if (shouldRemove) {
                    boardSet.remove(i);
                }
            }
        }
    }
    static void printBingoBoards (ArrayList<int[][]> boardSet) {
        for (int[][] ints : boardSet) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(ints[j][k] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}