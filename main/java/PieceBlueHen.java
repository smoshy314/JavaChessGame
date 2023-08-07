import static java.lang.Math.abs;

/**
 * @author devinjc
 * @author Joshua Martinez
 * @version 1
 * BlueHen Piece that extends abstract piece
 */
public class PieceBlueHen extends Piece implements Attacker, Recruiter{
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    /**
     * constructor
     * @param symbol
     * @param teamColor
     * @param numAttacks
     * @param numRecruits
     * @param hidden
     * @param original
     */
    public PieceBlueHen (char symbol,
                         String teamColor,
                         int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    /**
     * NO param constructor
     */
    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    /**
     * gets num attack
     * @return
     */
    public int getNumAttacks()    {
        return this.numAttacks;
    }

    /**
     * returns num recruits
     * @return
     */
    public int getNumRecruits(){
        return this.numRecruits;
    }

    /**
     * return can fly
     * @return
     */
    public boolean canFly()    {
        return this.flies;
    }

    /**
     * returns num attacks
     * @param numAttacks
     */
    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public boolean validAttackPath(int rowR, int colR, int rowA, int colA) {
        if(canFly()){
            return true;
        }else if (abs(rowA-rowR)== 0 && abs(colA-colR) == 1){
            return true;
        }else
            return false;
    }

    /**
     * sets num recruits
     * @param numRecruits
     */
    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    public boolean validRecruitPath(int rowR, int colR, int rowA, int colA) {
        if (canFly()){
            return true;
        }else{
            return (colA - colR == 0 && abs(rowA - rowR) == 1);
        }
    }

    /**
     * updates fly
     */
    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }

    /**
     * overides speak
     */
    @Override
    public void speak(){
        System.out.println("Go UD!");
    }

    /**
     * impliment late
     * @param fromSquareRow
     * @param fromSquareCol
     * @param toSquareRow
     * @param toSquareCol
     * @return
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        if(canFly()) {
            return true;
        }else{
            return abs(toSquareCol - fromSquareCol) <= 1 && abs(toSquareRow - fromSquareRow) <= 1;
        }
    }
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        if(canFly()) {
            return true;
        }else{
            return abs(toSquareCol - fromSquareCol) == 1 && abs(toSquareRow - fromSquareRow) == 1;
        }
    }

    /**
     * overrides spawn
     * @return
     */
    @Override
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    /**
     * can spawn alwasy tru
     * @return
     */
    @Override
    public boolean canSpawn(){
        return true;
    }
}
