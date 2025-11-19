package storage;

import modal.Expense;
import java.util.ArrayList;

interface Storage{
    void save(ArrayList<Expense> expenses);
    void load();
}