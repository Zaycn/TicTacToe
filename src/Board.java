import java.util.ArrayList;
import java.util.List;

public class Board {
    List<String> validMoves;
    private int size;
    private String[][] board;

    public Board(int size){
        this.validMoves = new ArrayList<>();
        this.size = size;
        this.board = new String[size][size];
        generateValidMoves();
    }


    public void generateBoard(){
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = "[]";
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if(j == this.size - 1 ){
                    System.out.print(this.board[i][j] + "\n");
                }
                else{
                    System.out.print(this.board[i][j]);
                }
            }
        }
    }

    public void insertMove(String move){

    }

    public boolean checkForValidMove(String move){


        return true;
    }

    private void generateValidMoves(){
        int numOfColumns = this.size;
        while(numOfColumns != 0){
            
            numOfColumns--;
        }
    }
}
