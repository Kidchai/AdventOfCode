package year2022.Day12;

public class Square {
    private final int id;
    private final int x;
    private final int y;
    private final char squareType;
    private final int elevation;
    boolean discovered;
    Square prev;

    public Square(int id, int y, int x, char squareType) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.squareType = squareType;
        switch (squareType) {
            case 'S' -> this.elevation = 'a';
            case 'E' -> this.elevation = 'z';
            default -> this.elevation = squareType;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSquareType() {
        return squareType;
    }

    public int getElevation() {
        return elevation;
    }

    public int getId() {
        return id;
    }
}
