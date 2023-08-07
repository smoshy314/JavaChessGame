
/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * A default object Piece that the other piece classes extend off of.
 * Contains the properties symbol, teamColor, hidden, and original, has
 * getters for symbol, teamColor, hidden, and original, has setters for
 * hidden and original, has a default constructor using the previously stated
 * parameters, overrides the toString method, and defines abstract methods
 * that are used in the other piece classes.
 */
import java.util.Collections;

public abstract class Piece implements Comparable<Piece> {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    /**
     * @return the symbol of the piece
     * Retrieves the character value of symbol
     */
    public char getSymbol() {
        return symbol;
    }
    /**
     * @return the team color of the piece
     * Retrieves the string value of teamColor
     */
    public String getTeamColor() {
        return teamColor;
    }

    /**
     * @return if the piece is hidden
     * Retrieves the truth value of hidden
     */
    public boolean isHidden() {
        return hidden;
    }
    /**
     * @return if the piece is original
     * Retrieves the truth value of original
     */
    public boolean isOriginal() {
        return original;
    }

    /**
     * @param hidden if the piece is hidden
     * Sets the truth value of hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    /**
     * @param original if the piece is original
     * Sets the truth value of original
     */
    public void setOriginal(boolean original) {
        this.original = original;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * @param symbol the character value of the symbol of the piece
     * @param teamColor the string value of the team color of the piece
     * @param hidden if the piece is hidden (boolean)
     * @param original if the piece is original (boolean)
     * A constructor that creates a basic piece using the values above as
     * parameters
     */
    public Piece(char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    /**
     * Provides a prototype for the speak function
     */
    public abstract void speak();
    /**
     * Provides a prototype for the spawn function
     */
    public abstract Piece spawn();
    /**
     * Provides a prototype for the canSpawn function
     */
    public abstract boolean canSpawn();
    /**
     * Provides a prototype for the validMovePath function
     */
    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    public abstract boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    /**
     * @return the string representation of the object Piece
     * Overrides the built in toString method in order to more accurately
     * display the object as a string
     */
    @Override
    public String toString(){
        return (this.teamColor + " " + this.symbol);
    }

    @Override
    public int compareTo(Piece other){
        return Character.valueOf(symbol).compareTo(other.symbol);
    }

}
