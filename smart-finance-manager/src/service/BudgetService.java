package service;

import domain.Budget;
import util.InputValidator;
import java.time.LocalDate;
import enums.Category;

public class BudgetService{

    public void setMonthlyBudget(){
        
        System.out.println("Set budget for which month? (MM-YYYY): ");
        LocalDate date = InputValidator.getMonthYear(false);
        Budget b = new Budget();

        double amount;

        for(Category c : Category.values()){
           
            System.out.print("Enter budget for " + c + ": ");
           
            amount = InputValidator.getDouble("Amount should be a number!!!","Amount for the budget should be more than 999.");

            b.setBudget(c,amount);
            
        }

        b.setDate(date);

        System.out.println("Monthly budget set successfully!\n----------------------------------------------");
        
    }
    
}