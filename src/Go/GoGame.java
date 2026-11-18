package Go;

import Go.records.GoShape;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GoGame {
    private GoStone.StoneColor currentTeamTurn;
    private GoBoard board;

    public GoGame(int row, int col){
        this.currentTeamTurn = GoStone.StoneColor.BLACK;
        this.board = new GoBoard(row, col);
    }

    public GoStone.StoneColor getCurrentTeamTurn() {
        return currentTeamTurn;
    }

    public GoBoard getBoard() {
        return board;
    }

    public boolean isValidMove(GoBoard board, GoPosition position) {
        // need to implement this
        // inbound check
        // suicide moves
        // ko moves
        return true;
    }

    public void capture(GoPosition position, GoStone goStone) {
        this.board.addStone(position, goStone);
        GoPosition north = new GoPosition(position.getRow() + 1, position.getCol());
        GoPosition south = new GoPosition(position.getRow() - 1, position.getCol());
        GoPosition east = new GoPosition(position.getRow(), position.getCol() + 1);
        GoPosition west = new GoPosition(position.getRow(), position.getCol() - 1);
        List<GoPosition> positions = List.of(north, south, east, west);
        Set<GoPosition> captured = new HashSet<>();
        for (GoPosition pos : positions) {
            if (goStone.isInBounds(this.board, pos)) {
                if (this.board.getStone(pos) != null) {
                    if (this.board.getStone(pos).getColor() != goStone.getColor()) {
                        GoShape shape = this.board.getStone(pos).findShape(this.board, pos);
                        if (shape.liberties().isEmpty()) {
                            captured.addAll(shape.stones());
                        }
                    }
                }

            }
        }
        // if captured is not empty
            // loop through each position
                // remove the stone at that position
                // update a counter for prisoners of that color
        // else
            // check if the stone at the pos has liberties
            // if it does not
                // remove it
                // throw an invalid move exception
    }

    public void placeStone(GoPosition position, GoStone goStone) {
        if (isValidMove(board, position)) {
            this.board.addStone(position, goStone);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GoGame goGame = (GoGame) o;
        return currentTeamTurn == goGame.currentTeamTurn && Objects.equals(board, goGame.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTeamTurn, board);
    }
}
