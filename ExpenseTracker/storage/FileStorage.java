package storage;

import java.util.ArrayList;
import modal.Expense;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStorage implements Storage{

    public void save(ArrayList<Expense> allExpneses){

        String csvFile = "Expenses.csv";

        try(FileWriter writer = new FileWriter(csvFile)){

            writer.append("ID, Amount, Category, Date, Note");
            writer.append("\n");
            for(Expense expense : allExpneses){
                writer.append(expense.getId() + " , " + expense.getAmount() + " , " + expense.getCategory() + " , " + expense.getDate() + " , " + expense.getNote());
            }

            System.out.println("CSV file created successfully!");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void load(){
        String csvFile = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                for (String value : data) {
                    System.out.print(value + " | ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}