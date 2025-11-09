package bank.savingsaccount;
import bank.Account;

public class SavingsAccount extends Account{

    public SavingsAccount(int accountNumber,String name){
        super(accountNumber,"Savings Account",name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());
    }

    // Override withdraw method to make it specific for savings account.
    public void withdraw(int amount){
        if(this.balance - amount < MINIMUM_AMOUNT || this.balance < amount){
            System.out.println("\nWithdrawal denied! Savings account must maintain minimum balance of 1000 Rupees.");
        }else{
            this.balance -= amount;
            System.out.println(this.GREEN + "Withdrawal successful." + this.RESET);
        }
    }

}