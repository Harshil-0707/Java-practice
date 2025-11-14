import java.util.Scanner;
import service.ExpenseManager;

public class App{
    public static void main(String args[]){
        
        Scanner sc = new Scanner();

        ExpenseManager em = new ExpenseManager();

        boolean running = true;

        while(running){
            System.out.println("===========================================");
            System.out.println("           EXPENSE TRACKER SYSTEM          ");
            System.out.println("===========================================");
            System.out.println("1. Add Expense");
            System.out.println("2. Edit Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View All Expense");
            System.out.println("5. Monthly Total");
            System.out.println("6. Category-wise Statistics");
            System.out.println("7. Search Expenses by Date Range");
            System.out.println("8. Export to CSV");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            if(!sc.hasNextInt()){
                System.out.println("You should enter a number!!!");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    em.addExpense(sc);
                    break;
                case 2:
                    em.editExpense(sc);
                    break;
                case 3:
                    em.deleteExpense(sc);
                    break;
                case 4:
                    em.viewAllExpense(sc);
                    break;
                case 5:
                    em.monthlyTotal(sc);
                    break;
                case 6:
                    em.categoryWiseStats(sc);
                    break;
                case 7:
                    em.searchExpenseByDateRange(sc);
                    break;
                case 8:
                    em.exportToCSV(sc);
                    break;
                case 9:
                    System.out.println("Saving data...");
                    System.out.println("Data saved to expense.txt");
                    System.out.println("Thank you for using Expense Tracker! Goodbye :)");
                    break;
                default:
                    System.out.println("Enter valid number!!!");
                    continue;
            }
        }

        sc.close();
    }
}