import java.util.Scanner;

public class TicTacToe{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameEnded = false;

        while(!gameEnded){
            System.out.println("\nCurrent board: ");
            for(int i = 0 ; i < 3 ; i++){
                System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
                if (i < 2) System.out.println("---+---+---");
            }

            int row , col;
            while(true){
                System.out.print("\nPlayer " + currentPlayer + ", enter row ( 0 , 1 , 2 ): ");
                if(!sc.hasNextInt()){
                    System.out.println("You must enter a number!!!");
                    sc.next();
                    continue;
                }
                row = sc.nextInt();
                System.out.print("\nPlayer " + currentPlayer + ", enter column ( 0 , 1 , 2 ): ");
                 if(!sc.hasNextInt()){
                    System.out.println("You must enter a number!!!");
                    sc.next();
                    continue;
                }
                col = sc.nextInt();

                // Check if position is valid or not.
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid position! Try again.");
                } else if (board[row][col] != ' ') {
                    System.out.println("That spot is already taken! Try again.");
                } else {
                    board[row][col] = currentPlayer;
                    break;
                }

            }
            boolean win = false;
            for(int i = 0 ; i < 3 ; i++){
                // This is for row and column 1st condition is for row and 2nd condition that is after or is for column.
                if(
                    (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) || 
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                ){
                    win = true;
                    break;
                }
            }

            // This checks diagonals.
            if(
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || 
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            ){
                win = true;
            }

            // If game is finished and either player won the match.
            if(win){
                System.out.println("\nFinal Board:");
                for (int i = 0; i < 3; i++) {
                    System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
                    if (i < 2) System.out.println("---+---+---");
                }
                System.out.println("\nPlayer " + currentPlayer + " wins!");
                gameEnded = true;
            }else{
                // Checks if game is draw
                boolean draw = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == ' ') {
                            draw = false;
                            break;
                        }
                    }
                }

                if(draw){
                    System.out.println("\nIt's a draw.");
                    gameEnded = true;
                }else{
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
        sc.close();
    }
}