package service;

import domain.Transaction;
import enums.*;
import java.time.LocalDate;
import util.InputValidator;
import repository.TransactionRepository;

public class TransactionService{

    TransactionRepository tr = new TransactionRepository();

    public void addTransaction(){
       
        System.out.print("Enter amount: ");
        double amount = InputValidator.validateDouble("Enter a amount!!!","Amount should be more than 100.");

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

        System.out.print("Enter Date (YYYY-MM-DD): ");
        LocalDate date = validateDate();

        System.out.print("Enter Note: ");
        String notes = sc.nextLine();

        Transaction t = new Transaction.Builder().amount(amount).category(category).type(tt).date(date).notes(notes).build();

        tr.save(t);

        System.out.println("✔ Transaction added successfully!\n" + "Transaction ID: " + t.getId() + "\n---------------------------------");

    }


}