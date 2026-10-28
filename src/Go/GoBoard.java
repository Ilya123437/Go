package Go;

import java.util.HashMap;
import java.util.Map;

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

    public void getStone(GoPosition position) {
        this.board.get(position);
    }

    public void resetBoard() {
        this.board.clear();
    }

}
