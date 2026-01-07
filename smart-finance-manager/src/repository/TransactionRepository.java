package repository;

import domain.Transaction;
import java.util.ArrayList;

public interface TransactionRepository{

    void save(Transaction t);
    
    ArrayList<Transaction> getTransactions();
    
}