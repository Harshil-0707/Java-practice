package util;

import enums.*;
import java.io.FileWriter;
import java.io.FileReader;
import domain.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;

public final class CsvUtil{

    public static ArrayList<Transaction> read(String path){
        ArrayList<Transaction> retrievedTransactions = new ArrayList<>();
        String line;
        int lineNumber = 1;

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            while((line = br.readLine()) != null){
                if(1 == lineNumber){
                    lineNumber++;
                    continue;
                }
                
                String[] data = line.split(",");

                String id = data[0].trim();
                double amount = Double.parseDouble(data[1].trim());
                TransactionType type = TransactionType.valueOf(data[2].trim());
                Category category = Category.valueOf(data[3].trim());
                LocalDate date = LocalDate.parse(data[4].trim());
                String notes = data[5].trim();

                Transaction t = new Transaction.Builder().amount(amount).category(category).type(type).date(date).notes(notes).build();
                
                retrievedTransactions.add(t);
            }

        }catch(IOException e){
            return retrievedTransactions;
        }

        return retrievedTransactions;
    }

    public static void write(String path,ArrayList<Transaction> t){
        if(t.isEmpty()){
            System.out.println("Add a transaction before saving it.");
            return;
        }
        try(FileWriter writer = new FileWriter(path)){
            writer.append("id,amount,type,category,date,notes\n");
            for(Transaction transaction : t){
                writer.append(
                    transaction.getId() + "," +
                    transaction.getAmount() + "," +
                    transaction.getType() + "," +
                    transaction.getCategory() + "," +
                    transaction.getDate() + "," +
                    transaction.getNotes() + "\n"
                );
            }
            System.out.println("CSV file created successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}