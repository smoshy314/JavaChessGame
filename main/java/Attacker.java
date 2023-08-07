public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);
    public abstract boolean validAttackPath(int rowR, int colR, int rowA, int colA);
}