public enum PaymentMethod{
    CREDIT_CARD(2.0),
    DEBIT_CARD(1.0),
    UPI(0.0),
    COD(0.0);

    private final double feePercent;
    PaymentMethod(double feePercent){
        this.feePercent = feePercent;
    }

    public double getFeePercent(){
        return feePercent;
    }
}