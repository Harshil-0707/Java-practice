package app;
import java.util.Scanner;

public class FinanceApplication{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("\tSMART PERSONAL FINANCE MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        boolean running = true;

        while(running){
            System.out.println("Choose an option:\n
                                1. Add Transaction\n
                                2. View All Transactions\n
                                3. Set Monthly Budget\n
                                4. View Monthly Report\n
                                5. View Category-wise Report\n
                                6. Sort Transactions\n
                                7. Export Data to CSV\n
                                8. Exit");
            System.out.println("---------------------------------------------- 
                                \nEnter your choice:");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number!!!");
                sc.nextLine();
                continue;
            }
            int userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:{
                    System.out.println("Saving data...\nClosing resources...");
                    System.out.println("==============================================\n
                                        Thank you for using Smart Finance Manager 💰\n
                                        Have a great day!\n
                                        ==============================================");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid choice!!!");
                    continue;
            }
        }
    }
}