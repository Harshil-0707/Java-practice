package service;

import domain.Budget;
import enums.Category;
import domain.Transaction;
import util.InputValidator;
import java.time.YearMonth;
import enums.TransactionType;
import repository.TransactionRepository;

public class ReportService{

    private final TransactionRepository tr;

    public ReportService(TransactionRepository tr){
        this.tr = tr;
    }

    private double getTotalIncomeForMonth(YearMonth date){
        double income = 0;
        for(Transaction t : tr.getTransactions()){
            if (YearMonth.from(t.getDate()).equals(date)
                && t.getType() == TransactionType.INCOME) {
                income += t.getAmount();
            }
        }
        return income;
    }

    private double getTotalExpenseForMonth(YearMonth date){
        double expense = 0;
        for(Transaction t : tr.getTransactions()){
            if (YearMonth.from(t.getDate()).equals(date)
                && t.getType() == TransactionType.EXPENSE) {
                expense += t.getAmount();
            }    
        }
        return expense;
    }

    private double getCategoryWiseExpenseForMonth(Category category,YearMonth date){
        double expense = 0;
        for(Transaction t : tr.getTransactions()){
            if(date.getYear() == t.getDate().getYear() && date.getMonth() == t.getDate().getMonth() && t.getType().getId() == 1 && t.getCategory() == category){
                expense += t.getAmount();
            }      
        }
        return expense;
    }

    public void viewMonthlyReport(){

        String line = "----------------------------------------------";

        System.out.print("Enter month and year for monthly report (MM-YYYY): ");
        YearMonth date = InputValidator.getMonthYear();

        double income = getTotalIncomeForMonth(date);
        double expense = getTotalExpenseForMonth(date);

        String message;

        System.out.println("Monthly Report for: " + date);
        System.out.println(line);
        System.out.println("Total Income: " + income);

        System.out.println("Total Expense: " + expense);
        System.out.println("Net Balance: " + (income - expense));
        System.out.println(line);
        System.out.println("Budget Status:");
        
        for (Category c : Category.values()) {
            double categoryWiseExpenseForMonth = getCategoryWiseExpenseForMonth(c,date);
            double categoryWiseBudget = Budget.INSTANCE.getBudget(c);
            double diff = categoryWiseBudget - categoryWiseExpenseForMonth;

            if (Math.abs(diff) < 0.0001) {
                message = "\tBudget Used Fully";
            } else if (diff > 0) {
                message = "\tWithin the budget";
            } else {
                message = "\tOut of budget";
            }
            System.out.printf(
                "%-15s : %8.2f / %8.2f %s%n",
                c, categoryWiseExpenseForMonth, categoryWiseBudget, message
            );

        }
        System.out.println(line);   
    }

    public void categoryWiseReport(){

        System.out.print("Enter month and year for category wise report (MM-YYYY): ");
        YearMonth date = InputValidator.getMonthYear();

        System.out.println("\nCategory-wise Expense Summary for: " + date.getMonth() + " " + date.getYear());

        System.out.println("----------------------------------------------");
        for (Category c : Category.values()) {
            double categoryWiseExpenseForMonth = getCategoryWiseExpenseForMonth(c,date);
            System.out.println(c + "\t: " + categoryWiseExpenseForMonth);
        }
        System.out.println("----------------------------------------------\n");
    }
}