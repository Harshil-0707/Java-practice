package payments;

public class UpiPayment extends Payments{

    private String upiId;

    public UpiPayment(String customerName,double amount,String upiId){
        this.customerName = customerName;
        this.amount = amount;
        this.upiId = upiId;
    }

    @Override
    public void processPayment(){
        // Service fee of 2%
        double finalAmount = this.amount - PaymentUtils.calculateServiceCharge(this.amount, 2);
        System.out.println("Final amount after 2% service charge: " + finalAmount);
    }

}