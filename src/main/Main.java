package main;
import java.util.Scanner;
import payments.*;

public class Main{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while(running){

            System.out.println("\n===== Payment System =====");
            System.out.println("1. Pay using Credit Card");
            System.out.println("2. Pay using UPI");
            System.out.println("3. Pay using NetBanking");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Enter a number from given options.");    
                sc.next();
                continue;
            }
            
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                // Credit Card.
                case 1:{
                    double amount;
                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();
                    
                    while(true){
                        System.out.print("Enter Amount: ");
                        if(!sc.hasNextDouble()){
                            System.out.println("You should enter Amount.");
                            sc.next();
                            continue;
                        }
                        amount = sc.nextDouble();
                        if(amount <= 0){
                            System.out.println("Amount cannot be less than or equal to 0.");
                            continue;
                        }
                        sc.nextLine();
                        break;
                    }
                    
                    System.out.print("Enter Card Number: ");
                    String cardNumber = sc.nextLine();

                    CreditCardPayment ccp = new CreditCardPayment(customerName,amount,cardNumber);
                    ccp.processPayment();
                    break;
                }
                // UPI
                case 2:{
                    double amount;
                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();
                    
                    while(true){
                        System.out.print("Enter Amount: ");
                        if(!sc.hasNextDouble()){
                            System.out.println("You should enter Amount.");
                            sc.next();
                            continue;
                        }
                        amount = sc.nextDouble();
                        if(amount <= 0){
                            System.out.println("Amount cannot be less than or equal to 0.");
                        }
                        sc.nextLine();
                        break;
                    }
                    
                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();

                    UpiPayment upi = new UpiPayment(customerName,amount,upiId);
                    upi.processPayment();
                    break;
                }
                // NetBanking
                case 3:{
                    double amount;
                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();
                    
                    while(true){
                        System.out.print("Enter Amount: ");
                        if(!sc.hasNextDouble()){
                            System.out.println("You should enter Amount.");
                            sc.next();
                            continue;
                        }
                        amount = sc.nextDouble();
                        if(amount <= 0){
                            System.out.println("Amount cannot be less than or equal to 0.");
                        }
                        sc.nextLine();
                        break;
                    }
                    
                    System.out.print("Enter Bank Name: ");
                    String bankAccount = sc.nextLine();

                    NetBankingPayment nbp = new NetBankingPayment(customerName,amount,bankAccount);
                    nbp.processPayment();
                    break;
                }
                // Exit
                case 4:{
                    running = false;
                    System.out.println("Thank you for using our Payment System!");
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
        }

        sc.close();
    }
}