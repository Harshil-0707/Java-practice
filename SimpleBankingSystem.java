import java.util.Scanner;

public class SimpleBankingSystem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        boolean continueBanking = true;

        int balance = 1000;

        // Continue banking until the user exits on their own.
        while(continueBanking){

            System.out.println("Welcome to Java Bank!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposite Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice : ");
            if(!sc.hasNextInt()){
                System.out.println("You should enter a number between 1 to 4");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit : ");
                    int amount = sc.nextInt();
                    if(amount <= 0){
                        System.out.println("Invalid amount! Deposit must be greater than 0.");
                    }else{
                        balance += amount;
                        System.out.println("Deposit successful! New balance = " + balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw : ");
                    int withdrawAmount = sc.nextInt();
                    if(withdrawAmount <= 0){
                        System.out.println("Invalid amount! Withdrawal must be greater than 0.");
                    }else if(withdrawAmount > balance){
                        System.out.println("Insufficient balance!");
                    }else{
                        balance -= withdrawAmount;
                        System.out.println("Withdrawal successful! New balance = " + balance);
                    }
                    break;
                case 4:
                    System.out.println("Thanky you for using Java Bank.\n Final Balance = " + balance);
                    continueBanking = false;
                    break;
                default:
                    System.out.println("Invalid option! Please select between 1 to 4.");
            }

            if(continueBanking){
                System.out.print("DO you want to countine? (y/n):");
                char continueChoice = sc.next().trim().toLowerCase().charAt(0);
                switch(continueChoice){
                    case 'y':
                    case 'Y':
                        continueBanking = true;
                        break;
                    case 'n':
                    case 'N':
                        System.out.println("Thanky you for using Java Bank.\n Final Balance = " + balance);
                        continueBanking = false;
                        break;
                }
            }
        }

        sc.close();
    }
}