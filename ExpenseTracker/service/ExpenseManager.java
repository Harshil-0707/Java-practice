package service;

import modal.Expense;
import modal.Category;
import java.util.Scanner;
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
            String userInput = sc.nextLine();

            try{
                category = Category.valueOf(userInput.toUpperCase());

            }catch(IllegalArgumentException ex){
                System.out.println("Invalid category!");
                continue;
            }

            break;
        }

        LocalDate date;
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        while(true){
            try {
                System.out.print("Enter year (YYYY): ");
                int year = sc.nextInt();
                sc.nextLine();
                if(year > currentYear){
                    System.out.println("Enter valid Year.");
                    continue;
                }
                int month;
                while(true){
                    System.out.print("Enter month (1-12): ");
                    month = sc.nextInt();
                    sc.nextLine();
                    if(month > currentMonth && year == currentYear){
                        System.out.println("Enter valid month.");
                        continue;
                    }
                    break;
                }
                int day;
                while(true){
                    System.out.print("Enter day (1-31): ");
                    day = sc.nextInt();
                    sc.nextLine();
                    if(day > currentDay && year == currentYear && month == currentMonth){
                        System.out.println("Enter valid day.");
                        continue;
                    }
                    break;
                }

                date = LocalDate.of(year, month, day);

            }catch (Exception e) {
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
        for(Expense expense : allExpenses){
            if(expense.getId() == id){
                System.out.println("Editing Expense ID " + id + ":");
                // Take amount
                double amount;
                while(true){
                    System.out.print("Enter new amount (or press Enter to keep same): ");
                    String amountInString;
                    amountInString = sc.nextLine();
                    if(amountInString.isEmpty()){
                        amount = expense.getAmount();
                        break;
                    }else{
                        try{
                           amount = Integer.parseInt(amountInString);
                        }catch(Exception e){
                            System.out.println("Enter valid amount.");
                            continue;
                        }
                    }
                }
                // Take categroy
                Category category;
                while(true){
                    System.out.print("Enter new category (or press Enter to keep same): ");
                    String userInput = sc.nextLine();
                    if(userInput.isEmpty()){
                        category = expense.getCategory();
                        break;
                    }else{
                        try{
                            category = Category.valueOf(userInput.toUpperCase());

                        }catch(IllegalArgumentException iae){
                            System.out.println("Invalid category!");
                            continue;
                        }
                    }
                    break;
                } 
                // Take date
                LocalDate date;
                while(true){
                    System.out.print("Enter new date (YYYY-MM-DD or Enter to keep same: ");
                    String userInput = sc.nextLine();
                    if(userInput.isEmpty()){
                        date = expense.getDate();
                        break;
                    }else{
                        try {
                            date = LocalDate.parse(userInput);
                        } catch (Exception exe) {
                            System.out.println("Invalid date! Please enter a valid day, month, and year.");
                            continue;
                        }
                    }
                    break;
                }
                // Take note
                System.out.print("Enter new note (or press Enter to keep same): Sneakers on discount");
                String note = sc.nextLine();
                if(note.isEmpty()) note = expense.getNote();
                expense.editExpense(amount , category , date , note);
                break;
            }
        }

    }

    public void deleteExpense(Scanner sc){
        int id = getExpenseId(sc);
        for(Expense expense : allExpenses){
            if(expense.getId() == id){
                allExpenses.remove(expense);
                System.out.println("Expense deleted successfully!");
                break;
            }
        }
    }

    public void viewAllExpense(Scanner sc){
        double totalAmount=0;
        System.out.println("-------------------- ALL EXPENSES -------------------");
        System.out.printf("%-4s | %-10s | %-12s | %-10s  | %-8s%n", 
                  "ID", "Amount", "Category", "Date", "Note");
        for(Expense expense : allExpenses){
            double amount = expense.getAmount();
            totalAmount += amount;
            System.out.printf("%-4d | %-10.2f | %-12s | %-10s  | %-8s%n",expense.getId(),amount,expense.getCategory(),expense.getDate(),expense.getNote());
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Total: " + totalAmount);
    }

    public void monthlyTotal(Scanner sc){
        int month;
        while(true){
            System.out.print("Enter month (1-12): ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number for month!!!");
                sc.nextLine();
                continue;
            }
            month = sc.nextInt();
            if(month > 12 || month < 1){
                System.out.println("Enter valid month!!!");
                continue;
            }
            break;
        }

        int year;
        while(true){
            System.out.println("Enter year: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number for year!!!");
                sc.nextLine();
                continue;
            }
            year = sc.nextInt();
            if(year < 0){
                System.out.println("Year cannot be negative.");
                continue;
            }
            break;
        }
    }

    public void categoryWiseStats(Scanner sc){}

    public void searchExpenseByDateRange(Scanner sc){}

    public void exportToCSV(){}

}