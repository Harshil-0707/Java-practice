package storage;

import java.util.ArrayList;
import modal.Expense;
import modal.Category;
import java.io.FileWriter;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStorage implements Storage{

    public void save(ArrayList<Expense> allExpneses){
        String csvFile = "Expenses.csv";
        try(FileWriter writer = new FileWriter(csvFile)){
            writer.append("ID,Amount,Category,Date,Note");
            writer.append("\n");
            for(Expense expense : allExpneses){
                writer.append(expense.getId() + "," + expense.getAmount() + "," + expense.getCategory() + "," + expense.getDate() + "," + expense.getNote()+"\n");
            }
            System.out.println("CSV file created successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
        load();
    }

    public ArrayList<Expense> load(){
        String csvFile = "Expenses.csv";
        String line;
        int lineNumber = 1;
        ArrayList<Expense> retrievedExpenses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(1 == lineNumber){
                    lineNumber++;
                    continue;
                }
                String[] data = line.split(",");
                for (int i = 0 ; i < data.length ;) {
                    int id = Integer.parseInt(data[i++].trim());   
                    double amount = Double.parseDouble(data[i++].trim());
                    Category category = Category.valueOf(data[i++].trim());
                    LocalDate date = LocalDate.parse(data[i++].trim());
                    String note = data[i++].trim();


                    Expense expense = new Expense(amount,category,date,note,id);
                    retrievedExpenses.add(expense);
                }
            }

        } catch (IOException e) {
            return retrievedExpenses;
        }
        return retrievedExpenses;
    }
}