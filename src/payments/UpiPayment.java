package payments;
import utils.PaymentUtils;

public class UpiPayment extends Payments{

    private String upiId;

    public UpiPayment(String customerName,double amount,String upiId){
        super(customerName,amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment(){
        // Service fee of 2%
        double finalAmount = this.amount - PaymentUtils.calculateServiceCharge(this.amount, 2);
        System.out.println("\nPayment Successful!");
        System.out.println("Final amount after 2% service charge: " + finalAmount);
    }

}