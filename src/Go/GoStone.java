package Go;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoStone {
    public enum StoneColor {
        WHITE,
        BLACK
    }

    private final GoStone.StoneColor color;
    private int liberties;

    public GoStone (GoStone.StoneColor color) {
        this.color = color;
    };

    public int getLiberties(GoBoard board, GoPosition position) {
        return liberties;
    }

    public StoneColor getColor() {
        return color;
    }

    public boolean isInBounds(GoBoard board, GoPosition position) {
        int rows = board.getRows();
        int cols = board.getCols();
        if (position.getRow() < 0 || position.getRow() > rows) {
            return false;
        }
        if (position.getCol() < 0 || position.getCol() > cols) {
            return false;
        }
        return true;
    }

    public int calculateLiberties(GoBoard board, GoPosition position) {
        this.liberties = 0;
        GoPosition north = new GoPosition(position.getRow() + 1, position.getCol());
        GoPosition south = new GoPosition(position.getRow() - 1, position.getCol());
        GoPosition west = new GoPosition(position.getRow(), position.getCol() - 1);
        GoPosition east = new GoPosition(position.getRow(), position.getCol() + 1);
        List<GoPosition> positions = List.of(north, south, east, west);

        for (GoPosition pos : positions) {
            if (isInBounds(board, pos) && board.getStone(pos) == null) {
                this.liberties += 1;
            }
        }
        return this.liberties;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GoStone goStone = (GoStone) o;
        return liberties == goStone.liberties && color == goStone.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, liberties);
    }
}
