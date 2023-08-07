public class ActionAttack extends Action{
    public ActionAttack(GameS22 game, int fromy, int fromx, int toy, int tox){
        super(game,fromy,fromx,toy,tox);
    }

    public void performAction(){
        this.game.getBoardSquares()[this.fromy][this.fromx].getPiece().speak();
        if ((this.game.getBoardSquares()[this.fromy][this.fromx].getPiece() instanceof PieceEvilMinion) && (this.game.getBoardSquares()[this.fromy][this.fromx].getPiece().getTeamColor().equals(this.game.getCurrentTeam().getTeamColor()))
                && this.game.getBoardSquares()[this.toy][this.tox].getPiece().getTeamColor().equals(this.game.getCurrentTeam().getTeamColor()) && this.game.getBoardSquares()[this.toy][this.tox].getPiece() instanceof PieceMinion){
            PieceEvilMinion temp = (PieceEvilMinion) this.game.getBoardSquares()[this.fromy][this.fromx].getPiece();
            PieceEvilMinion newPiece = new PieceEvilMinion(temp.symbol, temp.teamColor, 0, 0, 0, false, temp.original );
            this.game.getBoardSquares()[this.toy][this.tox].removePiece();
            this.game.getCurrentTeam().addPieceToTeam(newPiece);
            this.game.getBoardSquares()[this.toy][this.tox].setPiece(newPiece);
        }else if(this.game.getBoardSquares()[this.toy][this.tox].getPiece() instanceof PieceGreenKnight){
                if(!((PieceGreenKnight) this.game.getBoardSquares()[this.toy][this.tox].getPiece()).getHasDied()) {
                    ((PieceGreenKnight) this.game.getBoardSquares()[this.toy][this.tox].getPiece()).setDead(true);
                }
                else{
                    Piece thisPiece = this.game.getBoardSquares()[this.fromy][this.fromx].removePiece();
                    Piece opponentPiece = this.game.getBoardSquares()[this.toy][this.tox].removePiece();
                    this.game.getBoardSquares()[this.toy][this.tox].setPiece(thisPiece);
                    this.game.getOpponentTeam().removePieceFromTeam(opponentPiece);
                }
        }
        else{
            Piece thisPiece = this.game.getBoardSquares()[this.fromy][this.fromx].removePiece();
            Piece opponentPiece = this.game.getBoardSquares()[this.toy][this.tox].removePiece();
            this.game.getBoardSquares()[this.toy][this.tox].setPiece(thisPiece);
            this.game.getOpponentTeam().removePieceFromTeam(opponentPiece);
        }

        this.game.changeTurn();

    }
}
