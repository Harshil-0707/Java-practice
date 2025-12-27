package repository;

import java.util.ArrayList;
import domain.Transaction;

public class TransactionRepository{

    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void save(Transaction t){
        transactions.add(t);
    }

    public ArrayList<Transaction> getTransactions(){
        return new ArraList<>(transactions);
    }

}