public class ActionRocket extends Action{
    public ActionRocket(GameS22 game, int fromy, int fromx, int toy, int tox){
        super(game,fromy,fromx,toy,tox);
    }

    public void performAction(){
        this.game.getBoardSquares()[this.fromy][this.fromx].getPiece().speak();
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (this.game.getGameBoard().inBounds(toy + i, tox + j)){
                    if (!(this.game.getBoardSquares()[this.toy + i][this.tox + j].isEmpty()) && this.game.getBoardSquares()[this.toy + i][this.tox + j].getPiece().getTeamColor().equals(this.game.getOpponentTeam().getTeamColor())){
                        if (!(this.game.getBoardSquares()[this.toy + i][this.tox + j].getPiece() instanceof PieceGreenKnight && ((PieceGreenKnight) this.game.getBoardSquares()[this.toy + i][this.tox + j].getPiece()).getDead())) {
                            Piece opponentPiece = this.game.getBoardSquares()[this.toy + i][this.tox + j].removePiece();
                            this.game.getOpponentTeam().removePieceFromTeam(opponentPiece);
                        }
                    }
                }
            }
        }

        ((PieceBobaFett)this.game.getBoardSquares()[this.fromy][this.fromx].getPiece()).setNumAttacks(0);

        this.game.changeTurn();

    }
}
