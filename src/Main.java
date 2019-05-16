import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        new Game();
        boolean answerLoop = true;
        System.out.println("Would you like to replay (y/n)?");
        Scanner scanner = new Scanner(System.in);
        while (answerLoop){
            String input = scanner.nextLine();
            if (input.equals("y")){
                answerLoop = false;
                new Game();
            }
            else if(input.equals("n")){
                answerLoop = false;
            }
            else{
                System.out.println("Invalid command");
            }
        }

        System.out.println("Thanks for playing!");
    }
}
