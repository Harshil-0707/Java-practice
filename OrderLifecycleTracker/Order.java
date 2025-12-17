import java.util.UUID;

public class Order{

    private final String Id;
    private OrderStatus status;
    private final PaymentMethod paymentMethod;
    private double amount;

    public Order(double amount,PaymentMethod paymentmethod){
        this.Id = UUID.randomUUID().toString().subString(0,8);
        this.status = OrderStatus.PLACED;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getId(){
        return this.Id;
    }

    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }

    public double getAmount(){
        return this.amount;
    }

    public OrderStatus getOrderStatus(){
        return this.status;
    }

    public boolean transitionTo(OrderStatus status){
        if(status.canTransitionTo(status)){
            status = next;
            return true;
        }
        return false;
    }

    public boolean cancel(){
        if(status == OrderStatus.PLACED || status == OrderStatus.PAID){
            status = OrderStatus.CANCELLED;
            return true;
        }
        return false;
    }

    public String toString(){
        return String.format("Order[%s] Status: %s, Amount: %.2f, Payment: %s, Total: %.2f",
                id, status, amount, paymentMethod, totalWithFees());
    }

}