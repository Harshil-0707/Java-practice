package service;

import enums.*;
import util.CsvUtil;
import config.AppConfig;
import domain.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import util.InputValidator;
import java.util.Comparator;
import repository.TransactionRepository;

public class TransactionService{

    private final TransactionRepository tr;
    
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

    public TransactionService(TransactionRepository tr){
        this.tr = tr;
    }

    public void addTransaction(){
       
        System.out.print("Enter amount: ");
        double amount = InputValidator.getDouble(
            "Amount should be a number!!!",
            "Amount should be more than 100."
        );

        System.out.println("Select Category:");
        System.out.println("1. FOOD");
        System.out.println("2. TRANSPORT");
        System.out.println("3. RENT");
        System.out.println("4. UTILITIES");
        System.out.println("5. SHOPPING");
        System.out.println("6. ENTERTAINMENT");
        System.out.print("Enter choice: ");

        int categoryNumber = InputValidator.getInt(
            1,
            6,
            "Enter a number!!!",
            "Number should be between 1 to 6"
        );

        Category category = Category.fromId(categoryNumber);

        System.out.print("Select Transaction Type:\n1. EXPENSE\n2. INCOME\nEnter choice: ");
        
        int transactionNumber = InputValidator.getInt(
            1,
            2,
            "Enter a number!!!",
            "Number should be either 1 or 2"
        );

        TransactionType tt = transactionNumber == 1 ? TransactionType.EXPENSE : TransactionType.INCOME;

        System.out.print("Enter Date (DD-MM-YYYY): ");
        LocalDate date = InputValidator.getFullDate();

        System.out.print("Enter Note: ");
        String notes = InputValidator.getString();

        Transaction transaction = new Transaction.Builder()
                .amount(amount)
                .category(category)
                .type(tt)
                .date(date)
                .notes(notes)
                .build();

        tr.save(transaction);

        System.out.println(
            "Transaction added successfully!\n" +
            "Transaction ID: " + transaction.getId() + 
            "\n---------------------------------"
        );

    }

    public void viewAllTransactions(){ 

        String line = "-------------------------------------------------------------------------------";

        System.out.println(line);
        System.out.printf(
            "%-10s %-10s %-10s %-15s %-15s %-20s%n",
            "ID", "Amount", "Type", "Category", "Date", "Notes"
        );
        System.out.println(line);

        for(Transaction t : this.tr.getTransactions()){
            System.out.printf(
                "%-10s %-10.2f %-10s %-15s %-15s %-20s%n",
                t.getId(),
                t.getAmount(),
                t.getType(),
                t.getCategory(),
                t.getDate(),
                t.getNotes()
            );
            System.out.println(line);
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

        String line = "---------------------------------------------------";
        
        System.out.println(line);
        System.out.printf(
            "%-10s %-10s %-10s %-15s %-15s %-20s%n",
            "ID", "Amount", "Type", "Category", "Date", "Notes"
        );
        System.out.println(line);

        for(Transaction t : sortTransaction(choice)){
           System.out.printf(
                "%-10s %-10.2f %-10s %-15s %-15s %-20s%n",
                t.getId(),
                t.getAmount(),
                t.getType(),
                t.getCategory(),
                t.getDate(),
                t.getNotes()
            );
            System.out.println(line);
        }
       
    }

    public void exportDataToCsv(){
        CsvUtil.write(AppConfig.DATA_FILE,this.tr.getTransactions());
    }

}