import java.util.Scanner;
import Bank.Account;
import Bank.SavingsAccount.SavingsAccount;
import Bank.CurrentAccount.CurrentAccount;
/*
This a mini banking system using inheritance part of OOP.
*/

public class BankingSystem_OOP_version{
    public static final String GREEN = "\u001B[92m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        Account accounts[] = new Account[10];
        boolean exitBank = false;
        int index = 0;

        while(!exitBank){

            System.out.println("\n==== Mini Banking System ====");
            System.out.println("1) Create Savings Account");
            System.out.println("2) Create Current Account");
            System.out.println("3) Deposit Money");
            System.out.println("4) Withdraw Money");
            System.out.println("5) Check Balance");
            System.out.println("6) Check Account details");
            System.out.println("7) Exit");


            System.out.print("\nEnter you choice: ");
            if(!sc.hasNextInt()){
                System.out.println("You should enter a number between 1 to 7");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch(choice){
                // Create savings account.

                case 1:
                    index = createAccount(sc,accounts,index,100,499);
                    break;
                    
                // Create current account. 
                
                case 2:
                    index = createAccount(sc,accounts,index,500,999);
                    break;
                    
                // Deposit Money
                case 3:{
                    manageTransaction(sc,accounts,false);
                    break;
                }
                // Withdraw Money
                case 4:{
                    manageTransaction(sc,accounts,true);
                    break;
                }
                // Check Balance
                case 5: 
                    getAccountDetails(sc,accounts,0);
                    break;
                // Check Account details
                case 6: 
                    getAccountDetails(sc,accounts,1);
                    break;
                // Exit
                case 7:
                    System.out.println(GREEN + "Thank you for using Mini Banking System!" + RESET);
                    exitBank = true;
                    break;
                default:
                    System.out.println("\nSelect valid option.");
            }

        }
        
        sc.close();
    }

    // Make transaction like deposit or withdrawal.
    public static void manageTransaction(Scanner sc,Account[] accounts,boolean transactionType){
        int accNum = getAccountNumber(sc,accounts);
        if(accNum == 0){
            return;
        }

        while(true){
            System.out.print("Enter " + (transactionType ? "withdrawal" : "deposit") + " amount: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter valid amount to " + (transactionType ? "withdraw." : "deposit."));
                sc.next();
                continue;
            }
            int amount = sc.nextInt();
            if(amount < 0){
                System.out.println("Amount cannot be smaller than 0.");
                continue;
            }
            for(int i = 0 ; i < accounts.length ; i++){
                if(accounts[i] != null && accounts[i].accountNumber == accNum){
                    if(transactionType){
                        accounts[i].withdraw(amount);
                    }else{
                        accounts[i].deposit(amount);
                    }
                    break;
                }
            }
            break;
        }
    }

    // Create two type of account 1. Saving account , 2. Current account.
    public static int createAccount(Scanner sc,Account[] accounts,int index,int min,int max){
        if(index == accounts.length){
            System.out.println("Your account creation limit is exceeded.");
            return index;
        }
        int accNum;
        while(true){
            System.out.print("Enter Account Number between " + min + " to "+ max + ": ");
            if(!sc.hasNextInt()){
                System.out.println("You should enter a number between min to max");
                sc.next();
                continue;
            }
            accNum = sc.nextInt();
            if(accNum < min || accNum > max){
                System.out.println("Account number should be between "+ min + " to " + max);
                continue;
            }
            for(int i = 0 ; i < accounts.length ; i++){
                if(accounts[i] != null && accounts[i].accountNumber == accNum){
                    System.out.println("Enter valid account number.");
                    accNum = 0;
                    break;
                }
            }
            if(accNum != 0){
                break;
            }
            continue;
        }
        sc.nextLine();
        String holderName = "";
        while(true){
            System.out.print("Enter Account Holder Name: ");
            holderName = sc.nextLine().trim();
            if(holderName.isEmpty()){
                System.out.println("Holder name cannot be empty.");
                continue;
            }
            break;
        }
        accounts[index] = min == 100 ? new SavingsAccount(accNum,holderName) : new CurrentAccount(accNum,holderName);
        ++index;
        System.out.println(GREEN + "\n(Account created successfully)" + RESET);
        return index;
    }

    // Get account details like balance details and all the details of account.
    public static void getAccountDetails(Scanner sc,Account[] accounts,int operation){
        
        int accNum = getAccountNumber(sc,accounts);
        if(accNum == 0){
            return;
        }
        for(int i = 0 ; i < accounts.length ; i++){
            if(accounts[i] != null && accounts[i].accountNumber == accNum){
                if(operation == 1){
                    accounts[i].displayDetails();
                } else {
                    accounts[i].checkBalance();
                }
                break;
            }
        }
    }

    // Get account number for the transections.
    public static int getAccountNumber(Scanner sc,Account[] accounts){
        boolean foundAccount = false;

        for(int i = 0 ; i < accounts.length ; i++){
            if(accounts[i] != null){
                foundAccount = true;
                break;
            }
        }
        if(!foundAccount){
            System.out.println("First create an Account.");
            return 0;
        }
        
        foundAccount = false;
        
        int accNum;
        while(true){
            System.out.print("Enter Account Number: ");
            if(!sc.hasNextInt()){
                System.out.println("You should enter your account number.");
                sc.next();
                continue;
            }
            accNum = sc.nextInt();
            if(accNum <= 0){
                System.out.println("Account number can not be less than or equals to zero.");
                continue;
            }
            for(int i = 0 ; i < accounts.length ; i++){
                if(accounts[i] != null && accounts[i].accountNumber == accNum){
                    foundAccount = true;
                    break;
                }
            }
            if(foundAccount){
                break;
            }
            System.out.println("Enter valid account number.");
            continue;
        }
        return accNum;
    }

}