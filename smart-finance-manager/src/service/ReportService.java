package service;

import domain.Budget;
import enums.Category;
import util.InputValidator;
import java.time.LocalDate;
import repository.TransactionRepository;

public class ReportService{

    private final TransactionRepository tr;

    public ReportService(TransactionRepository tr){
        this.tr = tr;
    }

    public void viewMonthlyReport(){

        System.out.println("Enter month and year for monthly report (MM-YYYY): ");
        LocalDate date = InputValidator.getDate(false);
        System.out.println("Monthly Report for: " + date);
        System.out.println("----------------------------------------------");
        System.out.println("Total Income: " + tr.getTotalIncomeForMonth(date));
        System.out.println("Total Expense: " + tr.getTotalExpenseForMonth(date));
        System.out.println("Net Balance: " + (tr.getTotalIncomeForMonth(date) - tr.getTotalExpenseForMonth(date)));
        System.out.println("----------------------------------------------");
        System.out.println("Budget Status:");
        
        Budget b = new Budget();
        for (Category c : Category.values()) {
            System.out.println(c + " : 200 / 2000 " + b.getBudget(c) + " ✔ ");
        }
        System.out.println("----------------------------------------------");
        
    }

    public void categoryWiseReport(){

    }
}