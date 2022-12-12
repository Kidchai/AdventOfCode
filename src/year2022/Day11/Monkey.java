package year2022.Day11;

import java.util.List;

public class Monkey implements Comparable<Object> {
    int inspected = 0;
    final List<Long> items;
    private final String[] operation;
    final int divider;
    final int trueThrow;
    final int falseThrow;

    Monkey(List<Long> items, String operation, int divider, int trueThrow, int falseThrow) {
        this.items = items;
        this.operation = operation.split(" ");
        this.divider = divider;
        this.trueThrow = trueThrow;
        this.falseThrow = falseThrow;
    }

    long increaseWorryLevel() {
        inspected++;
        long item = items.get(0);
        long value = operation[1].equals("old") ? item : Integer.parseInt(operation[1]);
        return switch (operation[0]) {
            case "+" -> item + value;
            case "*" -> item * value;
            default -> 0;
        };
    }

    long decreaseWorryLevel() {
        double result = ((double) items.get(0)) / 3;
        return (long) result;
    }

    boolean isDivisible() {
        return (items.get(0) % divider == 0);
    }

    @Override
    public int compareTo(Object o) {
        Monkey m = (Monkey) o;
        return this.inspected - m.inspected;
    }
}
