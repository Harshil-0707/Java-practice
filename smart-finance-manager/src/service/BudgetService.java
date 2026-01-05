package service;

import domain.Budget;
import util.InputValidator;
import java.time.LocalDate;
import java.time.YearMonth;
import enums.Category;

public class BudgetService{

    public void setMonthlyBudget(){
        
        System.out.print("Set budget for which month? (MM-YYYY): ");
        YearMonth date = InputValidator.getMonthYear();

        double amount;

        for(Category c : Category.values()){
           
            System.out.print("Enter budget for " + c + ": ");
           
            amount = InputValidator.getDouble("Amount should be a number!!!","Amount for the budget should be more than 999.");

            Budget.INSTANCE.setBudget(c, amount);
            
        }

        Budget.INSTANCE.setDate(date);

        System.out.println("Monthly budget set successfully!\n----------------------------------------------");
        
    }
    
}