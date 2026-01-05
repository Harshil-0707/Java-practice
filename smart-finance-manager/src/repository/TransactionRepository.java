package repository;

import java.util.ArrayList;
import java.time.YearMonth;
import enums.Category;
import domain.Transaction;

public class TransactionRepository{

    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void save(Transaction t){
        transactions.add(t);
    }

    public ArrayList<Transaction> getTransactions(){
        return new ArrayList<>(transactions);
    }

    public double getTotalIncomeForMonth(YearMonth date){
        double income = 0;
        for(Transaction t : transactions){
            if(date.getYear() == t.getDate().getYear() && date.getMonth() == t.getDate().getMonth() && t.getType().getId() == 2){
                income += t.getAmount();
            }
        }
        return income;
    }

    public double getTotalExpenseForMonth(YearMonth date){
        double expense = 0;
        for(Transaction t : transactions){
            if(date.getYear() == t.getDate().getYear() && date.getMonth() == t.getDate().getMonth() && t.getType().getId() == 1){
                expense += t.getAmount();
            }      
        }
        return expense;
    }

    public double getCategoryWiseExpenseForMonth(Category category,YearMonth date){
        double expense = 0;
        for(Transaction t : transactions){
            if(date.getYear() == t.getDate().getYear() && date.getMonth() == t.getDate().getMonth() && t.getType().getId() == 1 && t.getCategory() == category){
                expense += t.getAmount();
            }      
        }
        return expense;
    }

}