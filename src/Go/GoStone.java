package Go;

public class GoStone {
    public enum StoneColor {
        WHITE,
        BLACK
    }

    private final GoStone.StoneColor color;
    private int liberties;

    public GoStone (GoStone.StoneColor color, int liberties) {
        this.color = color;
        this.liberties = liberties;
    };

    public int getLiberties() {
        return liberties;
    }

    public StoneColor getColor() {
        return color;
    }

    public void setLiberties(int liberties) {
        this.liberties = liberties;
    }
}
