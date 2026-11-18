package Go;

import Go.exceptions.InvalidMoveException;

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

    public boolean isInBounds(GoPosition position) {
        int rows = this.rows;
        int cols = this.cols;
        if (position.getRow() < 0 || position.getRow() > rows) {
            return false;
        }
        if (position.getCol() < 0 || position.getCol() > cols) {
            return false;
        }
        return true;
    }

    public void addStone(GoPosition position, GoStone goStone) throws InvalidMoveException {
        if (isInBounds(position)) {
            this.board.put(position, goStone);
        } else {
            throw new InvalidMoveException("Move is not within the bounds of the board");
        }
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
