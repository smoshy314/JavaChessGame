
// New Extended Piece Modification : Piece extends piece buzz and works the same besides his
//     added rocket function. After three attacks BobaFell can use his rocket which is a newAction
public class PieceBobaFett extends PieceBuzz implements Attacker{
    private boolean workingRocket;

    public PieceBobaFett(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser, boolean hidden, boolean original, boolean workingRocket){
        super(symbol, teamColor, numAttacks, numTimesBeenAttacked, workingLaser, hidden, original);
        this.workingRocket = workingRocket;
    }

    public boolean getWorkingRocket(){
        return this.getNumAttacks() >= 3;
    }

    @Override
    public void speak(){
        System.out.println("Like a bantha!");
    }

}
