/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * This class represents an object of type BoardSquare that can hold
 * a boolean value for if it is empty, a value of type Piece for the
 * piece that is on the square, and the color of the square of type
 * string. It also contains a constructor with color as a parameter,
 * as well as getter methods, a way to add or remove a piece from a
 * BoardSquare object, and an override of toString to better represent
 * the object.
 */
public class BoardSquare {
    private boolean empty;
    private Piece piece;
    private String color;
    private boolean isSticky;

    /**
     * @param color the String value of the color of the square
     * Constructs a BoardSquare object assigning the value of the
     * color parameter to the color of the square and sets the
     * empty value to true.
     */
    public BoardSquare(String color){
        this.color = color;
        this.empty = true;
        this.isSticky = false;
    }
    // Board Square Modification : modification makes a board square Sticky
    //    There is functionality in the Controller class that toggles a randomly chosen
    //    square(chosen at start) from sticky to not sticky every 6 turns. In Rules it
    //    first checks if the Piece trying to perfom an action is on a sticky square.
    //    if it is It can not do anything.
    public void toggleSticky(){
        this.isSticky = !this.isSticky;
    }
    public boolean getSticky(){
        return this.isSticky;
    }

    /**
     * @return the piece that's on the square
     * Retrieves the value of the piece on the BoardSquare
     */
    public Piece getPiece(){
        return this.piece;
    }

    /**
     * @return if the space is empty
     * Retrieves the truth value of empty
     */
    public boolean isEmpty(){
        return this.empty;
    }

    /**
     * @return the color of the BoardSquare
     * Retrieves the string value of color
     */
    public String getSquareColor(){
        return this.color;
    }

    /**
     * @param piece the piece that will be placed on the square
     * Assigns a piece to the BoardSquare object and sets the
     * truth value of empty to false
     */
    public void setPiece(Piece piece){
        this.piece = piece;
        this.empty = false;
    }

    /**
     * @return the piece that is removed
     * Removes the piece that is on the square, sets the truth value
     * of empty to true, and returns the piece that is removed.
     */
    public Piece removePiece(){
        Piece middle = this.piece;
        this.piece = null;
        this.empty = true;
        return middle;
    }

    /**
     * @return the string representation of the BoardSquare object
     * Overrides the toString method in order to more accurately
     * describe the object in string form
     */
    @Override
    public String toString(){
        if (this.piece == null){
            return "-------";
        }
        else{
            return "-" + this.piece.toString() + "-";
        }
    }
}
