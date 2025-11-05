package payments;

public interface Refundable{
    
    double refundableAmount();
    
    void refund(){
        System.out.println("Refund processed");
    }
}