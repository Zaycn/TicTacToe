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

    // returns the symbol that won, if it has won.
    // first checks for horizontal rows
    // then for vertical rows
    // then for diagonal rows
    // needs refactoring because this is bad code
    public String checkForWin(String symbolPlayer, String symbolAI){
        symbolPlayer = "[" + symbolPlayer + "]";
        symbolAI = "[" + symbolAI + "]";
        for (int i = 0; i < this.size; i++) {
            if (board[i][0].equals(symbolPlayer) && board[i][1].equals(symbolPlayer) && board[i][2].equals(symbolPlayer)){
                return symbolPlayer;
            }
            else if (board[i][0].equals(symbolAI) && board[i][1].equals(symbolAI) && board[i][2].equals(symbolAI)){
                return symbolAI;
            }
        }

        for (int i = 0; i < this.size; i++) {
            if (board[0][i].equals(symbolPlayer) && board[1][i].equals(symbolPlayer) && board[2][i].equals(symbolPlayer)){
                return symbolPlayer;
            }
            else if (board[0][i].equals(symbolAI) && board[1][i].equals(symbolAI) && board[2][i].equals(symbolAI)){
                return symbolAI;
            }
        }

        if (board[0][0].equals(symbolPlayer) && board[1][1].equals(symbolPlayer) && board[2][2].equals(symbolPlayer)){
            return symbolPlayer;
        }
        else if (board[0][0].equals(symbolAI) && board[1][1].equals(symbolAI) && board[2][2].equals(symbolAI)){
            return symbolAI;
        }

        if (board[0][2].equals(symbolPlayer) && board[1][1].equals(symbolPlayer) && board[2][0].equals(symbolPlayer)){
            return symbolPlayer;
        }
        else if (board[0][2].equals(symbolAI) && board[1][1].equals(symbolAI) && board[2][0].equals(symbolAI)){
            return symbolAI;
        }
        else{
            return "";
        }
    }

    private void generateValidMoves(){
        for (int i = 1; i <= this.size; i++) {
            for (int j = 1; j <= this.size ; j++) {
                this.validMoves.add(i + " " + j);
            }
        }
    }
}
