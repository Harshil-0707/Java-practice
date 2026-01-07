package service;

import enums.*;
import domain.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import util.InputValidator;
import java.util.Comparator;
import repository.InMemoryTransactionRepository;

public class TransactionService{

    private final InMemoryTransactionRepository tr;
    private static String[] sortTransactionsOptions = {
            "Amount (Low -> High)",
            "Amount (High -> Low)",
            "Date (Oldest -> Newest)",
            "Date (Newest -> Oldest)",
        };

    private ArrayList<Transaction> sortTransaction(int choice){

        ArrayList<Transaction> result = tr.getTransactions();
        
        switch(choice){
            case 1 -> result.sort(Comparator.comparing(Transaction::getAmount));
            case 2 -> result.sort(Comparator.comparing(Transaction::getAmount).reversed());
            case 3 -> result.sort(Comparator.comparing(Transaction::getDate));
            case 4 -> result.sort(Comparator.comparing(Transaction::getDate).reversed());
        }

        return result;
    }

    public TransactionService(InMemoryTransactionRepository tr){
        this.tr = tr;
    }

    public void addTransaction(){
       
        System.out.print("Enter amount: ");
        double amount = InputValidator.getDouble("Amount should be a number!!!","Amount should be more than 100.");

        System.out.println("Select Category:");
        System.out.println("1. FOOD");
        System.out.println("2. TRANSPORT");
        System.out.println("3. RENT");
        System.out.println("4. UTILITIES");
        System.out.println("5. ENTERTAINMENT");
        System.out.print("Enter choice: ");

        int categoryNumber = InputValidator.getInt(1,5,"Enter a number!!!","Number should be between 1 to 5");

        Category category = Category.fromId(categoryNumber);

        System.out.print("Select Transaction Type:\n1. EXPENSE\n2. INCOME\nEnter choice: ");
        
        int transactionNumber = InputValidator.getInt(1,2,"Enter a number!!!","Number should be either 1 or 2");

        TransactionType tt = transactionNumber == 1 ? TransactionType.EXPENSE : TransactionType.INCOME;

        System.out.print("Enter Date (DD-MM-YYYY): ");
        LocalDate date = InputValidator.getFullDate();

        System.out.print("Enter Note: ");
        String notes = InputValidator.getString();

        Transaction t = new Transaction.Builder().amount(amount).category(category).type(tt).date(date).notes(notes).build();

        tr.save(t);

        System.out.println("Transaction added successfully!\n" + "Transaction ID: " + t.getId() + "\n---------------------------------");

    }

    public void viewAllTransactions(){ 

        String lines = "---------------------------------------------------\n";
        System.out.println(lines);
        System.out.println("ID \t Amount \t Type \t Category \t Date \t Notes");
        System.out.println(lines);

        for(Transaction t : this.tr.getTransactions()){
            System.out.println(t.getId() + " \t " + t.getAmount() + " \t " + t.getType() + " \t " + t.getCategory() + " \t " + t.getDate() + " \t " + t.getNotes());
            System.out.println(lines);
        }
    }

    public void sortTransactions(){

        System.out.println("Sort by:");
        
        for(int i = 0; i < sortTransactionsOptions.length;i++){
            System.out.println((i+1) + ". " + sortTransactionsOptions[i]);
        }

        System.out.print("Enter choice: ");
        int choice = InputValidator.getInt(
            1,
            sortTransactionsOptions.length,
            "Enter a number!!!",
            "Number should be between 1 to " + sortTransactionsOptions.length
        );

        String lines = "---------------------------------------------------";
        
        System.out.println(lines);
        System.out.println("ID \t Amount \t Type \t Category \t Date \t Notes");
        System.out.println(lines);

        for(Transaction t : sortTransaction(choice)){
            System.out.println(t.getId() + " \t " + t.getAmount() + " \t " + t.getType() + " \t " + t.getCategory() + " \t " + t.getDate() + " \t " + t.getNotes());
            System.out.println(lines);
        }
       
    }

    public void exportDataToCsv(){
        
    }

}