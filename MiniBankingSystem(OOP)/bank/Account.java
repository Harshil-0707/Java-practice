package bank;

public class Account{

    public static final String GREEN = "\u001B[92m";
    public static final String RESET = "\u001B[0m";

    public final int accountNumber; 
    public final String accountType;
    public final int MINIMUM_AMOUNT = 1000;

    public String name;
    public double balance;

    public Account(int accountNumber,String accountType,String name){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.name = name;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println(this.GREEN + "Deposit successful." + this.RESET);
    }

    public void withdraw(int amount){
        if(this.balance < amount){
            System.out.println("Insufficient balance");
        }else{
            this.balance -= amount;
        }
    }

    // It's final function because there is no need to override it.
    final public void checkBalance(){
        System.out.println("\nYour balance is " + this.balance);
        System.out.println("Account type: " + this.accountType);
    }

    // It's final function because there is no need to override it.
    final public void displayDetails(){
        System.out.println("\nAccount No: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}