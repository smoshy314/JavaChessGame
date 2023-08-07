public abstract class Action {
    protected GameS22 game;
    protected int fromy;
    protected int fromx;
    protected int toy;
    protected int tox;

    public Action(GameS22 game, int fromy, int fromx, int toy, int tox){
        this.game = game;
        this.fromy = fromy;
        this.fromx = fromx;
        this.toy = toy;
        this.tox = tox;
    }

    public abstract void performAction();
}
