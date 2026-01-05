package domain;

import enums.Category;
import java.util.EnumMap;
import java.time.YearMonth;
import java.time.LocalDate;

public enum Budget{

    INSTANCE;

    private YearMonth date;
    private final EnumMap<Category, Double> budgets = new EnumMap<>(Category.class);

    // Getter
    public double getBudget(Category category) {
        return budgets.getOrDefault(category, 0.0);
    }

    // Setter
    public void setBudget(Category category,double amount){
        budgets.put(category,amount);
    }

    public void setDate(YearMonth date){
        this.date = date;
    }    
    
}