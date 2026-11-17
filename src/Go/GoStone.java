package Go;

import java.util.*;

public class GoStone {
    public enum StoneColor {
        WHITE,
        BLACK
    }

    private final GoStone.StoneColor color;

    public GoStone (GoStone.StoneColor color) {
        this.color = color;
    };

    public int getLiberties(GoBoard board, GoPosition position) {
        return calculateLiberties(board, position);
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
        Set<GoPosition> visited = new HashSet<>();
        Set<GoPosition> liberties = new HashSet<>();
        StoneColor color = this.color;
        explore(board, position, color, visited, liberties);
        return liberties.size();
    }

    private void explore(GoBoard board, GoPosition current, StoneColor color, Set<GoPosition> visited, Set<GoPosition> liberties) {
        if (!isInBounds(board, current)) {
            return;
        } else if (visited.contains(current)) {
            return;
        }
        visited.add(current);
        GoPosition north = new GoPosition(current.getRow() + 1, current.getCol());
        GoPosition south = new GoPosition(current.getRow() - 1, current.getCol());
        GoPosition west = new GoPosition(current.getRow(), current.getCol() - 1);
        GoPosition east = new GoPosition(current.getRow(), current.getCol() + 1);
        List<GoPosition> positions = List.of(north, south, east, west);
        for (GoPosition pos : positions) {
            if (!isInBounds(board, pos)) {
                continue;
            }
            if (board.getStone(pos) == null) {
                liberties.add(pos);
            } else if (board.getStone(pos).getColor() == color) {
                explore(board, pos, color, visited, liberties);
            } else {
                continue;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GoStone goStone = (GoStone) o;
        return color == goStone.color;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}
