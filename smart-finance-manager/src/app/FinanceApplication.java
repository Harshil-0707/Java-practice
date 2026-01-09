package app;

import service.*;
import java.util.Scanner;
import repository.TransactionRepository;

public class FinanceApplication{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        TransactionRepository tr = new TransactionRepository();
        TransactionService ts = new TransactionService(tr);
        ReportService rs = new ReportService(tr);
        BudgetService bs = new BudgetService();

        System.out.println("==============================================");
        System.out.println("   SMART PERSONAL FINANCE MANAGEMENT SYSTEM   ");
        System.out.println("==============================================");
        boolean running = true;

        while(running){
            System.out.println("Choose an option:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. Set Monthly Budget");
            System.out.println("4. View Monthly Report");
            System.out.println("5. View Category-wise Report");
            System.out.println("6. Sort Transactions");
            System.out.println("7. Export Data to CSV");
            System.out.println("8. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number!!!");
                sc.nextLine();
                continue;
            }
            int userChoice = sc.nextInt();
            sc.nextLine();
            switch(userChoice){
                case 1:
                    ts.addTransaction();
                    break;
                case 2:
                    ts.viewAllTransactions();
                    break;
                case 3:
                    bs.setMonthlyBudget();
                    break;
                case 4:
                    rs.viewMonthlyReport();
                    break;
                case 5:
                    rs.categoryWiseReport();
                    break;
                case 6:
                    ts.sortTransactions();
                    break;
                case 7:
                    ts.exportDataToCsv();
                    break;
                case 8:{
                    System.out.println("Saving data...\nClosing resources...");
                    ts.exportDataToCsv();
                    System.out.println("==============================================\nThank you for using Smart Finance Manager \nHave a great day!\n==============================================");
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