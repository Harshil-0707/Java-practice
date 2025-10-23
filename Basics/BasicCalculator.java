import java.util.Scanner;

public class BasicCalculator{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // Takes First number from the user in the firstNumber variable using java's Scanner class
        System.out.print("Enter the first number : ");
        int firstNumber = sc.nextInt();
        
        // Takes Second number from the user in the secondNumber variable using java's Scanner class
        System.out.print("Enter the Second number : ");
        int secondNumber = sc.nextInt();
        
        // Takes operator to perform the operation on the numbers taken as an input from the user using java's Scanner class
        System.out.print("Now select which task you want to perform (+ , - , * , /) : ");
        char operator = sc.next().charAt(0);
        double result = 0;
        // Switch case to perform task based on the operator selected by the user
        switch(operator){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Provide valid sign");
                return;
        }
        System.out.println("Final output : " + result);
    }
}