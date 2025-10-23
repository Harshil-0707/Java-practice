import java.util.Scanner;
import java.lang.Math;

/* This class is about a number guessing game with hints about the guess if it's high or low and also shows how many attempts it took the user to guess the right number and also hints and correct guess have colors !!!
*/
public class GuessTheNumber{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[91m";
    public static final String GREEN = "\u001B[92m";
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        // This while loop will be executed if user playes the game
        while(playAgain){
            int attempts = 0;
            int userInput = 0;
            int random = (int)(Math.random() * 100) + 1;

            System.out.println("I'm thinking of a number between 1 and 100.");

            // This do...while loop will be executed until the user guesses the right number
            do{
                System.out.print("Enter your guess : ");
                if(sc.hasNextInt()){
                    userInput = sc.nextInt();
                    attempts++;
                    if(random > userInput){
                        System.out.println(RED + "Too low! Try again." + RESET);
                    }else if(random < userInput){
                        System.out.println(RED + "Too high! Try again." + RESET);
                    }else{
                        System.out.println(GREEN + "Correct! You got it in " + attempts + " attempts." + RESET);
                    }
                } else {
                    System.out.println("Please enter a valid number!");
                    sc.next(); // consume invalid input
                }
            }while(random != userInput);

            // Check if user wants to continue playing game or not
            System.out.print("Do you want to play again? (y/n):");
            char choice = sc.next().trim().toLowerCase().charAt(0);

            switch(choice){
                case 'Y':
                case 'y':
                    playAgain = true;
                    break;
                case 'n':
                case 'N':
                    playAgain = false;
                    System.out.println(GREEN + "Thanks for playing!" + RESET);
                    break;
                default: 
                    System.out.println(RED + "Invalid choice! Exiting..." + RESET);
                    playAgain = false;
            }
        }
    }
}