package domain;

import enums.Category;
import java.util.EnumMap;
import java.time.LocalDate;

public class Budget{
    private final LocalDate date;
    private final EnumMap<Category,Double> budgets = new EnumMap<>(Category.class);

    // Getter
    public EnumMap<Category,Double> getBudget(Category category){
        return this.budgets.get(category);
    }

    // Setter
    public void setBudget(Category category,double amount){
        budgets.put(category,amount);
    }

    public void setDate(LocalDate date){
        this.date = date;
    }    
    
}