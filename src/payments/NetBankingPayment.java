package payments;
import utils.PaymentUtils;

public class NetBankingPayment extends Payments implements Redundable{

    private String bankAccount;

    public NetBankingPayment(String customerName,double amount,String bankAccount){
        this.customerName = customerName;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    @override
    public void processPayment(){
        // Service fee of 0.5%
        double finalAmount = PaymentUtils.calculateServiceCharge(this.amount,0.5);
        System.out.println("Final amount after 0.5% service charge: " + finalAmount);
    }

    @override
    public double refundAmount(){
        // refund 90% means service charge = 5%
        return this.amount - PaymentUtils.calculateServiceCharge(this.amount,5);
    }

}