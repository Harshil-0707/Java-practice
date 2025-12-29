package service;

import domain.Transaction;
import domain.Budget;
import enums.*;
import java.time.LocalDate;
import java.util.ArrayList;
import util.InputValidator;
import repository.TransactionRepository;

public class TransactionService{

    TransactionRepository tr = new TransactionRepository();

    public void addTransaction(){
       
        System.out.print("Enter amount: ");
        double amount = InputValidator.validateDouble("Amount should be a number!!!","Amount should be more than 100.");

        System.out.print("Select Category:\n
                           1. FOOD\n
                           2. TRANSPORT\n
                           3. RENT\n
                           4. UTILITIES\n
                           5. ENTERTAINMENT\n
                          Enter choice:");
        int categoryNumber = validateInt("Enter a number!!!","Number should be between 1 to 5");

        Category category = Category.fromId(categoryNumber);

        System.out.print("Select Transaction Type:\n1. EXPENSE\n2. INCOME\nEnter choice: ");
        
        int transactionNumber = validateInt("Enter a number!!!","Number should be either 1 or 2");

        TransactionType tt = transactionNumber == 1 ? TransactionType.EXPENSE : TransactionType.INCOME;

        System.out.print("Enter Date (DD-MM-YYYY): ");
        LocalDate date = validateDate(true);

        System.out.print("Enter Note: ");
        String notes = sc.nextLine();

        Transaction t = new Transaction.Builder().amount(amount).category(category).type(tt).date(date).notes(notes).build();

        tr.save(t);

        System.out.println("✔ Transaction added successfully!\n" + "Transaction ID: " + t.getId() + "\n---------------------------------");

    }

    public void viewAllTransactions(){
        // ArrayList<Transaction> transactions = TransactionRepository.getTransactions(); 

        String lines = "---------------------------------------------------\n";

        for(Transaction t : TransactionRepository.getTransactions()){
            System.out.println(lines);
            System.out.println("ID \t Amount \t Type \t Category \t Date \t Notes\n");
            Sytem.out.println(lines);
            System.out.println(t.getId() + " \t " + t.getAmount() + " \t " + t.getType() + " \t " + t.getCategory() + " \t " + t.getDate() + " \t " + t.getNotes());
            Sytem.out.println(lines);
        }
    }

    public void setMonthlyBudget(){
        
        System.out.println("Set budget for which month? (MM-YYYY): ");
        LocalDate date = validateDate(false);
        Budget b = new Budget();

        double amount;

        for(TransactionType tt : Transaction.values()){
           
            System.out.print("Enter budget for " + tt + ": ");
           
            amount = InputValidator.validateDouble("Amount should be a number!!!","Amount for the budget should be more than 999.");

            b.setBudget(tt,amount);
            
        }

        b.setDate(date);

        System.out.println("✔ Monthly budget set successfully!\n----------------------------------------------");
        
    }

    public void viewMonthlyReport(){

    }

    public void categoryWiseReport(){

    }

    public void sortTransactions(){

    }

    public void exportDataToCsv(){
        
    }

}