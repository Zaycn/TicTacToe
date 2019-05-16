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

    public void insertMove(String move, String symbol){
        this.validMoves.remove(move);
        move = move.replace(" ", "");
        this.board[Integer.parseInt(move.substring(0, 1)) - 1][Integer.parseInt(move.substring(1,2)) - 1] = String.format("[%s]", symbol);
    }

    public boolean checkForValidMove(String move){
        if (this.validMoves.contains(move)) {
            return true;
        }
        else{
            return false;
        }
    }

    public List<String> getValidMoves(){
        return this.validMoves;
    }

    public boolean checkForWin(){
        
        return true;
    }

    private void generateValidMoves(){
        for (int i = 1; i <= this.size; i++) {
            for (int j = 1; j <= this.size ; j++) {
                this.validMoves.add(i + " " + j);
            }
        }
    }
}
