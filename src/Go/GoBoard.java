package Go;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GoBoard {
    Map<GoPosition, GoStone> board;
    private final int rows;
    private final int cols;

    public GoBoard (int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.board = new HashMap<>();
    }

    public void addStone(GoPosition position, GoStone goStone) {
        // Need to add a check to see if the position is within the bounds of the board
        this.board.put(position, goStone);
    }

    public void removeStone(GoPosition position) {
        this.board.remove(position);
    }

    public GoStone getStone(GoPosition position) {
        return this.board.get(position);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void resetBoard() {
        this.board.clear();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GoBoard goBoard = (GoBoard) o;
        return rows == goBoard.rows && cols == goBoard.cols && Objects.equals(board, goBoard.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, rows, cols);
    }
}
