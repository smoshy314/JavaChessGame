import static java.lang.Math.abs;

// New Piece Modification : Added this Piece which moves like a king in chess
//    and can not attack. When it is killed it enters a dead state in which it
//    is invincible. Every 12 turns the game attempts to revive all Pieces of
//    this type. When revived it is no longer invincible but It can move anywhere
//    and attack anywhere. After it is killed a second time it is dead for good.
//    Thy symbols change from G to D to V to represent each stage. Green knight
//    before death(G) A Dead Green Knight(D) A knight back for vengence(V)
public class PieceGreenKnight extends Piece implements Attacker{
    private boolean hasDied;
    private boolean isDead;
    private int numAttacks;
    /**
     * @param symbol    the character value of the symbol of the piece
     * @param teamColor the string value of the team color of the piece
     * @param hidden    if the piece is hidden (boolean)
     * @param original  if the piece is original (boolean)
     *                  A constructor that creates a basic piece using the values above as
     */
    public PieceGreenKnight(char symbol, String teamColor, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.hasDied = false;
        this.isDead = false;
    }
    public void setDead(boolean death){
        this.isDead = death;
        if (death = true){
            this.symbol = 'D';
        }
    }
    public boolean getDead(){
        return isDead;
    }
    public void revive(){
        this.isDead = false;
        this.hasDied = true;
        this.symbol = 'V';
    }
    public boolean getHasDied(){
        return hasDied;
    }

    @Override
    public int getNumAttacks() {
        return this.numAttacks;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int rowR, int colR, int rowA, int colA) {
        return this.hasDied;
    }

    @Override
    public void speak() {
        System.out.println("Off With Your HEAD!!!!");
    }

    @Override
    public Piece spawn() {
        return null;
    }

    @Override
    public boolean canSpawn() {
        return false;
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if(isDead){
            return false;
        }else if (!hasDied){
            return abs(toSquareCol - fromSquareCol) <= 1 && abs(toSquareRow - fromSquareRow) <= 1;
        } else {
            return true;
        }
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }
}
