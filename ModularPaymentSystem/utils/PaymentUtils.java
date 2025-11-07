package utils;

public class PaymentUtils{
    
    public static double calculateServiceCharge(double amount,double percent){
        return amount * (percent / 100);
    }
}