package main;
import java.util.Scanner;
import payments.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while(running){

            System.out.println("===== Payment System =====");
            System.out.println("1. Pay using Credit Card");
            System.out.println("2. Pay using UPI");
            System.out.println("3. Pay using NetBanking");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Enter a number from given options.");    
                sc.next();
                continue;
            }
            
            int choice = nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Customer Name: ");
                    System.out.print("Enter Amount: ");
                    System.out.print("Enter Card Number: ");

                    System.out.println("------ PAYMENT PROCESSED ------");
                    break;
                case 2:
                    System.out.print("Enter Amount Paid : ");
                    System.out.prtinln("------ REFUND CALCULATION ------");
                    break;
                case 3:
                    System.out.print("Enter Customer Name: ");
                    System.out.print("Enter Amount: ");
                    System.out.print("Enter Bank Name: ");

                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using our Payment System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
        }

        sc.close();
    }
}