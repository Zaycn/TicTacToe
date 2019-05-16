import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Hi, welcome to TicTacToe.\n Would you like to be circle or cross?");
        boolean hasPicked = false;
        Scanner scanner = new Scanner(System.in);
        String playersChoice = "";
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
        Player player = new Player(playersChoice);
        Board board = new Board(3);
        board.generateBoard();
        boolean gameLoop = true;

        while (gameLoop){
            System.out.println("This is the board currently (press q to quit)");
            board.printBoard();
            System.out.println(String.format("Where do you want to place your %s?  (first the row, after that a space and the column) ex: 1 3, places it in the first row in the third column", player.getChoice()));
            String move = scanner.nextLine();
            if(move.equals("q")){
                gameLoop = false;
            }
            else if(move.length() > 3 || move.length() < 3 || )
            {
                System.out.println("Invalid move");
            }
            board.insertMove(move);
        }
        System.out.println("Thanks for playing!");
    }
}
