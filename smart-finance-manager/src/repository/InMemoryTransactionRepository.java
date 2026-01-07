package repository;

import enums.Category;
import domain.Transaction;
import java.util.ArrayList;
import java.time.YearMonth;

public class InMemoryTransactionRepository implements TransactionRepository{

    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void save(Transaction t){
        transactions.add(t);
    }

    public ArrayList<Transaction> getTransactions(){
        return new ArrayList<>(transactions);
    }

}