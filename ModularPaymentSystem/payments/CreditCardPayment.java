package payments;
import utils.PaymentUtils;

public class CreditCardPayment extends Payments implements Refundable {

    private String cardNumber;

    public CreditCardPayment(String customerName,double amount,String cardNumber){
        super(customerName,amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(){
        // Service fee of 1%
        double finalAmount = this.amount - PaymentUtils.calculateServiceCharge(this.amount, 1);
        System.out.println("\nPayment Successful!");
        System.out.println("Final amount after 1% service charge: " + finalAmount);
    }

    @Override
    public void refundableAmount(){
        double refundableAmount = this.amount - PaymentUtils.calculateServiceCharge(this.amount,5); 
        System.out.println(refundableAmount + " refunded successfully");
    }

}