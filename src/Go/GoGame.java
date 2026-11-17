package Go;

import java.util.Objects;

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

    //public boolean isValidMove() {
        // need to implement this
    //}

    public void placeStone(GoPosition position, GoStone goStone) {
        this.board.addStone(position, goStone);
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
