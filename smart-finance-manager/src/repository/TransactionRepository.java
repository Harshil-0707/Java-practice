package repository;

import util.CsvUtil;
import java.util.List;
import enums.Category;
import java.util.Objects;
import domain.Transaction;
import java.util.ArrayList;

public class TransactionRepository {

    private ArrayList<Transaction> transactions =
        new ArrayList<>(Objects.requireNonNullElse(
            CsvUtil.read("data/Data.csv"),
            List.of()
        ));

    public void save(Transaction t){
        transactions.add(t);
    }
    
    public ArrayList<Transaction> getTransactions(){
        return new ArrayList<>(transactions);
    }

}