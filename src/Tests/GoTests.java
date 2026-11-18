package Tests;
import Go.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GoTests {

    private static GoBoard board;

    @BeforeAll
    public static void init() {
        board = new GoBoard(9, 9);
    }

    @AfterEach
    public void resetBoard() {
        board.resetBoard();
    }

    @Test
    public void basicCalculateLibertiesTest() {
        // white stone by itself
        GoPosition position = new GoPosition(5, 5);
        GoStone whiteStone = new GoStone(GoStone.StoneColor.WHITE);
        board.addStone(position, whiteStone);
        assertEquals(4, whiteStone.calculateLiberties(board, position));

        // white stone with 1 black stone next to it
        GoStone blackStone = new GoStone(GoStone.StoneColor.BLACK);
        GoPosition position1 = new GoPosition(5, 4);
        board.addStone(position1, blackStone);
        assertEquals(blackStone, board.getStone(position1));
        assertNull(board.getStone(new GoPosition(4, 5)));
        assertEquals(3, whiteStone.calculateLiberties(board, position));

        // white stone with 2 black stones next to it
        GoStone blackStone2 = new GoStone(GoStone.StoneColor.BLACK);
        GoPosition position2 = new GoPosition(4, 5);
        board.addStone(position2, blackStone2);
        assertEquals(2, whiteStone.calculateLiberties(board, position));

        // white stone with 3 black stones next to it
        GoStone blackStone3 = new GoStone(GoStone.StoneColor.BLACK);
        GoPosition position3 = new GoPosition(5, 6);
        board.addStone(position3, blackStone3);
        assertEquals(1, whiteStone.calculateLiberties(board, position));
    }

    @Test
    public void complexCalculateLibertiesTest() {
        // 2 white stones side by side
        GoPosition position = new GoPosition(5, 5);
        GoStone whiteStone = new GoStone(GoStone.StoneColor.WHITE);
        board.addStone(position, whiteStone);
        GoStone whiteStone1 = new GoStone(GoStone.StoneColor.WHITE);
        GoPosition position1 = new GoPosition(5, 4);
        board.addStone(position1, whiteStone1);
        assertEquals(6, whiteStone.calculateLiberties(board, position));

        // 3 white stones in an L shape
        GoPosition position3 = new GoPosition(4, 4);
        GoStone whiteStone3 = new GoStone(GoStone.StoneColor.WHITE);
        board.addStone(position3, whiteStone3);
        assertEquals(7, whiteStone.calculateLiberties(board, position));

        // white L shape with black stone
        GoPosition position4 = new GoPosition(4, 5);
        GoStone blackStone4 = new GoStone(GoStone.StoneColor.BLACK);
        board.addStone(position4, blackStone4);
        assertEquals(6, whiteStone.calculateLiberties(board, position));
    }
}
