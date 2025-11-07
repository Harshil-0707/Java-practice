package payments;
import utils.PaymentUtils;

public class NetBankingPayment extends Payments implements Refundable{

    private String bankAccount;

    public NetBankingPayment(String customerName,double amount,String bankAccount){
        super(customerName,amount);
        this.bankAccount = bankAccount;
    }

    @Override
    public void processPayment(){
        // Service fee of 0.5%
        double finalAmount = PaymentUtils.calculateServiceCharge(this.amount,0.5);
        System.out.println("\nPayment Successful!");
        System.out.println("Final amount after 0.5% service charge: " + finalAmount);
    }

    @Override
    public void refundableAmount(){
        // refund 90% means service charge = 5%
        double refundableAmount = this.amount - PaymentUtils.calculateServiceCharge(this.amount,5); 
        System.out.println(refundableAmount + " refunded successfully");
    }

}