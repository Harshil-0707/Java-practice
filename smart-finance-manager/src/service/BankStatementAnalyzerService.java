package service;

import util.CsvUtil;
import java.util.List;
import enums.Category;
import java.util.Map;
import java.time.Month;
import config.AppConfig;
import domain.Transaction;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import enums.TransactionType;
import java.util.stream.Collectors;
import repository.TransactionRepository;

public class BankStatementAnalyzerService{

    private ArrayList<Transaction> data;
 
    private double getTotalIncome(){
        double income = 0;
        for(Transaction t : this.data){
            if(t.getType() == TransactionType.INCOME){
                income += t.getAmount();
            }
        }
        return income;
    }

    private double getTotalExpense(){
        double expense = 0;
        for(Transaction t : this.data){
            if(t.getType() == TransactionType.EXPENSE){
               expense += t.getAmount();
            }
        }
        return expense;
    }

    private double getCategoryWiseExpense(Category c){
        double expense = 0;
        for(Transaction t : this.data){
            if(t.getCategory() == c && t.getType() == TransactionType.EXPENSE){
                expense += t.getAmount();
            }
        }
        return expense;
    }

    private ArrayList<Transaction> getExpensesByCategory(Category c){
        ArrayList<Transaction> transactions = new ArrayList<>();
        for(Transaction t : this.data){
            if(t.getCategory() == c){
                transactions.add(t);
            }
        }

        return transactions;
    }

    private void showSummary(){
        double income = getTotalIncome();
        double expense = getTotalExpense();
        System.out.println("-------------------------------");
        System.out.println("SUMMARY");
        System.out.println("-------------------------------");
        System.out.println("Total Income\t: " + income);
        System.out.println("Total Expense\t: " + expense);
        System.out.println("Net Savings\t: " + (income - expense));
    }

    private void showMontlyExpenseReport(){
        System.out.println("\n-------------------------------");
        System.out.println("MONTHLY EXPENSE REPORT");
        System.out.println("-------------------------------");

        Map<Month,Double> transactions = data.stream().collect(Collectors.groupingBy(d -> d.getDate().getMonth(),Collectors.reducing(0.0, Transaction::getAmount,Double::sum)));

        if(transactions.isEmpty()){
            System.out.println("No Expenses found!");
            return;
        }

        for(Map.Entry<Month,Double> entry : transactions.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    private void showCategoryWiseExpense(){
        System.out.println("\n-------------------------------");
        System.out.println("CATEGORY-WISE EXPENSE");
        System.out.println("-------------------------------");

        double expense = 0;
        ArrayList<Double> expenses = new ArrayList<>();

        for(Category c : Category.values()){
            expense = getCategoryWiseExpense(c); 
            if(expense != 0){
                expenses.add(expense);
                System.out.println(c + "\t\t: " + expense);
            }
        }

        if(expenses.size() == 0){
            System.out.println("No expense transactions found.");
            return;
        }
    }

    private void showHighestExpense(){
        List<Transaction> result = this.data;
        
        System.out.println("\n-------------------------------");
        System.out.println("TOP 5 HIGHEST EXPENSES");
        System.out.println("-------------------------------");

        result = result.stream().filter(r -> r.getType() == TransactionType.EXPENSE).sorted(Comparator.comparing(Transaction::getAmount).reversed()).limit(5).collect(Collectors.toList());

       
        if(result.isEmpty()){
            System.out.println("No Expenses found!");
            return;
        }

        System.out.printf(
            "%-10s %-15s %-10s %-15s %-20s%n",
            "ID", "Category" ,"Amount", "Date", "Notes"
        );

        for(Transaction t : result){
            System.out.printf(
                "%-10s %-15s %-10.2f %-15s %-20s%n",
                t.getId(),
                t.getCategory(),
                t.getAmount(),
                t.getDate(),
                t.getNotes()
            );
        }

    }

    private void showSearchedExpenses(){
        System.out.println("\n-------------------------------");
        System.out.println("SEARCH RESULTS");
        System.out.println("-------------------------------");

        ArrayList<Transaction> transaction = getExpensesByCategory(Category.FOOD);

        if(transaction.size() == 0){
            System.out.println("No transactions matched the search keyword.");
            return;
        }

        System.out.printf(
            "%-10s | %-10s | %-15s | %-15s | %-20s%n",
            "ID", "Amount", "Category", "Date", "Notes"
        );

        for(Transaction t : transaction){
            System.out.printf(
                "%-10s | %-10.2f | %-15s | %-15s | %-20s%n",
                t.getId(),
                t.getAmount(),
                t.getCategory(),
                t.getDate(),
                t.getNotes()
            );
        }

    }

    public void analyze(){
       
        System.out.println("\n----------------------------------------------------");
        System.out.println("BANK STATEMENT ANALYZER");
        System.out.println("----------------------------------------------------");
        System.out.println("Importing bank statement from: " + AppConfig.DATA_FILE);

        this.data = CsvUtil.read(AppConfig.DATA_FILE);

        if(this.data.isEmpty()){
            System.out.println("\nNo transactions found in the bank statement.");
            System.out.println("\nPossible reasons:");
            System.out.println("- The file is empty");
            System.out.println("- The file contains only headers");
            System.out.println("- The data format is invalid");
            System.out.println("\nNo analysis was performed.");
            System.out.println("----------------------------------------------------");
            return;
        }

        System.out.println("\n" + data.size() + " transactions imported successfully");

        showSummary();

        showMontlyExpenseReport();

        showCategoryWiseExpense();

        showHighestExpense();

        showSearchedExpenses();

        System.out.println("\n----------------------------------------------------");
        System.out.println("BANK STATEMENT ANALYSIS COMPLETED");
        System.out.println("----------------------------------------------------");

    }
}