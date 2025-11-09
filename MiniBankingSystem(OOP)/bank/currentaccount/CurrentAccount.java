package bank.currentaccount;
import bank.Account;

public class CurrentAccount extends Account{

    public CurrentAccount(int accountNumber, String name){
        super(accountNumber, "Current Account", name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());
    }

    // Override withdraw method to make it specific for current account.
    public void withdraw(int amount){
        if(this.balance - amount < -10000){
            System.out.println("\nWithdrawal denied! Overdraft limit of Rupees 10,000 exceeded.");
        }else{
            this.balance -= amount;
            System.out.println(this.GREEN + "Withdrawal successful." + this.RESET);
        }
    }

}