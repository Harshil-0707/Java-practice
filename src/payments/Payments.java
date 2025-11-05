package payments;

abstract public class Payments{

    protected double amount;
    protected String customerName;

    public Payments(String customerName , double amount){
        this.amount = amount;
        this.customerName = customerName;
    }    

    public abstract void processPayment();

    public void displayDetails(){
        System.out.println("Name: " + this.customerName);
        System.out.println("Amount: " + this.amount);
    }

    public boolean validateAmount(){
        return true;
    }
}