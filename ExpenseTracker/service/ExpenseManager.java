package service;

import modal.Expense;
import modal.Category;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager{

    private ArrayList<Expense> allExpenses = new ArrayList<>(); 


    private int getExpenseId(Scanner sc){
        int id;
        while(true){
            System.out.print("Enter ID: ");
            if(!sc.hasNextInt()){
                System.out.println("ID in valid!!!");
                sc.nextLine();
                continue;
            }
            id = sc.nextInt();
            sc.nextLine();
            if(id < 1){
                System.out.println("Id cannot be less 1.");
                continue;
            }
            break;
        }
        return id;
    }


    public void addExpense(Scanner sc){
        double amount;
        while(true){
            System.out.print("Enter amount: ");
            if(!sc.hasNextDouble()){
                System.out.println("Enter valid amount.");
                sc.nextLine();
                continue;
            }
            amount = sc.nextDouble();
            sc.nextLine();
            if(amount < 100){
                System.out.print("Amount needs to be more than 100.");
                continue;
            }
            break;
        }
        Category category;
        while(true){
            System.out.print("Enter category (Food/Travel/Shopping/Bills/Others): ");
            String userInput = sc.nextLine().toUpperCase();

            try{
                category = Category.valueOf(userInput.toUpperCase());

            }catch(IllegalArgumentException e){
                System.out.println("Invalid category!");
                continue;
            }

            break;
        }

        LocalDate date;

        while(true){
            try {
                System.out.print("Enter year (YYYY): ");
                int year = sc.nextInt();

                System.out.print("Enter month (1-12): ");
                int month = sc.nextInt();

                System.out.print("Enter day (1-31): ");
                int day = sc.nextInt();

                date = LocalDate.of(year, month, day);

            } catch (Exception e) {
                System.out.println("Invalid date! Please enter a valid day, month, and year.");
                continue;
            }
            break;
        }
        System.out.print("Enter note: ");
        String note = sc.nextLine();

        Expense expense = new Expense(amount, category , date , note);
        allExpenses.add(expense);
    }

    public void editExpense(Scanner sc){
        int id = getExpenseId(sc);
        for(Expense e : allExpenses){
            if(e.getId() == id){
                System.out.println("Editing Expense ID " + id + ":");
                System.out.print("Enter new amount (or press Enter to keep same): ");
                System.out.print("Enter new category (or press Enter to keep same): "); 
                System.out.print("Enter new date (YYYY-MM-DD or Enter to keep same):");  
                System.out.print("Enter new note (or press Enter to keep same): Sneakers on discount");
                break;
            }
        }

    }

    public void deleteExpense(Scanner sc){
        int id = getExpenseId(sc);
        for(Expense e : allExpenses){
            if(e.getId() == id){
                System.out.println("Expense deleted successfully!");
                e.remove(e);
                break;
            }
        }
    }

    public void viewAllExpense(Scanner sc){}

    public void monthlyTotal(Scanner sc){}

    public void categoryWiseStats(Scanner sc){}

    public void searchExpenseByDateRange(Scanner sc){}

    public void exportToCSV(){}

}