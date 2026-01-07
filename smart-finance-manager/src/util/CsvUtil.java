package util;

import java.io.FileWriter;
import java.io.FileReader;
import domain.Transaction;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;

public final class CsvUtil{

    public static ArrayList<Transaction> read(String path){
        ArraysList<Transaction> t = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

        }catch(IOException e){
            return t;
        }

        return t;
    }

    public static void write(String path,ArrayList<Transaction> t){
        try(FileWriter writer = new FileWriter(path)){
            writer.append();
            writer.append("\n");
            for(Transaction transaction : t){
                writer.append();
            }
            System.out.println("CSV file created successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}