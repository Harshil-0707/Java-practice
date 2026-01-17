package service;

import util.CsvUtil;
import java.util.List;
import config.AppConfig;
import domain.Transaction;
import java.util.ArrayList;

public class BankStatementAnalyzerService{


    public void analyze(){
       
        System.out.println("\n----------------------------------------------------");
        System.out.println("BANK STATEMENT ANALYZER");
        System.out.println("----------------------------------------------------");
        System.out.println("Importing bank statement from: " + AppConfig.DATA_FILE);

        ArrayList<Transaction> data = CsvUtil.read(AppConfig.DATA_FILE);
        if(data.size() == 0){
            System.out.println("\nNo transactions found in the bank statement.");
            System.out.println("\nPossible reasons:");
            System.out.println("- The file is empty");
            System.out.println("- The file contains only headers");
            System.out.println("- The data format is invalid");
            System.out.println("\nNo analysis was performed.");
            System.out.println("----------------------------------------------------");
            return;
        }

        System.out.println(data.size() + " transactions imported successfully");

        System.out.println("-------------------------------");
        System.out.println("SUMMARY");
        System.out.println("-------------------------------");

    }

    
}