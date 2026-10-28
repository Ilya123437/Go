package Go;

public class GoPosition {
    private final int row;
    private final int col;

    public GoPosition (int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
