import java.util.Scanner;

public class TextView {
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private char action;

    public int getFromRow(){
        return this.fromRow;
    }

    public int getFromColumn(){
        return this.fromColumn;
    }

    public int getToRow(){
        return this.toRow;
    }

    public int getToColumn(){
        return this.toColumn;
    }

    public char getAction(){
        return this.action;
    }

    public static int getValidInt(int min, int max, Scanner scr){
        boolean valid = false;
        int intValue = 0;

        while (!valid){
            System.out.println("Enter an integer between " + min + " and " + max + ".");
            if (scr.hasNextInt()) {
                intValue = scr.nextInt();
                if (intValue >= min && intValue <= max) {
                    valid = true;
                }
            }
            else{
                scr.next();
            }
        }

        return intValue;
    }

    public static char getUsersNextActionType(Scanner scr){
        boolean valid = false;
        char characterInput;
        char characterReturn = ' ';
        String input;

        while (!valid){
            System.out.println("Enter A for attack, M for move, R for recruit, L for launch a rocket, or S for spawn");
            input = scr.next();
            characterReturn = input.charAt(0);
            input = input.toUpperCase();
            characterInput = input.charAt(0);
            if (characterInput == 'A' || characterInput == 'M' || characterInput == 'R' || characterInput == 'S' || characterInput == 'L'){
                valid = true;
            }
        }
        return characterReturn;
    }

    public void getNextPlayersAction(GameS22 game){
        Scanner scr = new Scanner(System.in);
        this.action = getUsersNextActionType(scr);
        System.out.println("Enter the row of the piece you want to use");
        this.fromRow = getValidInt(0,game.getGameBoard().getNumRows() - 1,scr);
        System.out.println("Enter the column the piece you want to use");
        this.fromColumn = getValidInt(0,game.getGameBoard().getNumColumns() - 1,scr);
        System.out.println("Enter the row of the space you want to act on");
        this.toRow = getValidInt(0,game.getGameBoard().getNumRows() - 1,scr);
        System.out.println("Enter the column of the space you want to act on");
        this.toColumn = getValidInt(0,game.getGameBoard().getNumColumns() - 1,scr);
    }

    public void updateView(Game game){
        System.out.println(game.toString());
    }

    public void printEndOfGameMessage(GameS22 game){
        System.out.println("The game is over, " + game.getWinner().getTeamColor() + " won.");
    }
}
