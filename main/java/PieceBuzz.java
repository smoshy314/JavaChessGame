import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * @author devinjc
 * @version 1
 * Creates a chess piece PieceBuzz that extends the piece class
 * and additionally keeps track of how many times it has attacked,
 * how many times it's been attacked, and if it's laser is working.
 * The class also contains modifiers for symbol, if its laser is working,
 * and how many times it has been attacked.
 * It also allows the piece to speak.
 */
public class PieceBuzz extends Piece implements Attacker {
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;

    /**
     * @param symbol               the symbol of the piece
     * @param teamColor            the team color of the piece
     * @param numAttacks           the number of times the piece has attacked
     * @param numTimesBeenAttacked the number of times the piece has been attacked
     * @param workingLaser         if the laser of the piece is working
     * @param hidden               if the piece is hidden
     * @param original             if the piece is hidden
     *                             This function constructs a PieceBuzz with the attributes borrowed from the parameters
     *                             and uses the constructor from the Piece class
     */
    public PieceBuzz(char symbol,
                     String teamColor,
                     int numAttacks,
                     int numTimesBeenAttacked,
                     boolean workingLaser,
                     boolean hidden,
                     boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    /**
     * Constructs a PieceBuzz with no parameters and thus default attributes
     */
    public PieceBuzz() {
        this('B', "- -",
                0, 0,
                true, false, true);
    }

    /**
     * @return the number of times the piece has attacked
     * retrieves the value of numAttacks
     */
    public int getNumAttacks() {
        return numAttacks;
    }

    /**
     * @return the number of times the piece has been attacked
     * retrieves the value of numTimesBeenAttacked
     */
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }

    /**
     * @return if the laser is working
     * retrieves the value of workingLaser
     */
    public boolean canAttack() {
        return workingLaser;
    }

    /**
     * @param workingLaser the truth value as to if the laser is working
     *                     sets the value for workingLaser for the piece
     */
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (toSquareRow - fromSquareRow == 0){
            return true;
        }
        else if ((toSquareCol - fromSquareCol == 0) && (abs(toSquareRow - fromSquareRow) == 2)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Increments the value of numTimesBeenAttacked by 1 and sets the value of
     * workingLaser to false
     */
    public void updateNumTimesBeenAttacked() {
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    /**
     * Overrides the abstract method in the piece class to print out
     * the message "To Infinity and Beyond!"
     */
    @Override
    public void speak() {
        System.out.println("To Infinity and Beyond!");
    }

    /**
     * Implemented late
     *
     * @param fromSquareRow
     * @param fromSquareCol
     * @param toSquareRow
     * @param toSquareCol
     * @return
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        return true;
    }
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        return false;
    }

    /**
     * Overrides spawn() so it returns null
     *
     * @return
     */
    @Override
    public Piece spawn() {
        return null;
    }

    /**
     * Overrides can Spawn so it is alwasy false
     *
     * @return
     */
    @Override
    public boolean canSpawn() {
        return false;
    }

}
