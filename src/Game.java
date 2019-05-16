import java.util.Scanner;

public class Game {

    private boolean hasPicked;
    private String playersChoice;
    private String aiChoice;
    private Player player;
    private AI ai;
    private Board board;
    private boolean gameLoop;
    private Scanner scanner;

    public Game(){
        System.out.println("Hi, welcome to TicTacToe.\n Would you like to be circle or cross?");
        hasPicked = false;
        scanner = new Scanner(System.in);
        playersChoice = "";
        aiChoice = "";
        while(!hasPicked)
        {
            playersChoice = scanner.nextLine();
            if(playersChoice.equals("circle") || playersChoice.equals("cross")){
                System.out.println("You picked " + playersChoice);
                hasPicked = true;
            }
            else{
                System.out.println("Your input was invalid, try again.");
            }
        }
        if (playersChoice.equals("circle")) {
            playersChoice = "O";
            aiChoice = "X";
        }
        else {
            playersChoice = "X";
            aiChoice = "O";
        }
        player = new Player(playersChoice);
        ai = new AI(aiChoice);
        board = new Board(3);
        board.generateBoard();
        gameLoop = true;
        gameLoop();
    }

    private void gameLoop(){
        while (gameLoop){
            System.out.println("This is the board currently (press q to quit)");
            board.printBoard();
            System.out.println(String.format("Where do you want to place your %s?  (first the row, after that a space and the column) ex: 1 3," +
                    "places it in the first row in the third column\n or press q to quit", player.getChoice()));
            String move = scanner.nextLine();
            if(move.equals("q")){
                gameLoop = false;
            }
            else if(board.checkForValidMove(move)){
                board.insertMove(move, player.getChoice());
                board.printBoard();
                if (checkForWin()) {
                    break;
                }
                String aiMove = ai.generateMove(board.getValidMoves());
                board.insertMove(aiMove, ai.getChoice());
                System.out.println("The ai played move " + aiMove);
                board.printBoard();
                if(checkForWin()){
                    break;
                }
            }
            else{
                System.out.println("Invalid command");
            }

        }
    }

    private boolean checkForWin(){
        if (board.checkForWin(player.getChoice(), ai.getChoice()).equals("[O]") || board.checkForWin(player.getChoice(), ai.getChoice()).equals("[X]")){
            System.out.println(board.checkForWin(player.getChoice(), ai.getChoice()) + " won the game!");
            return true;
        }
        else{
            return false;
        }
    }

    private void handleInput(){

    }
}
