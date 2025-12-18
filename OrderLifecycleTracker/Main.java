import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        boolean running = true;
        Order order = new Order(14000,PaymentMethod.UPI);


        while(running){
            System.out.println("Choose action:");
            System.out.println("1. View order");
            System.out.println("2. Move to next logical state");
            System.out.println("3. Cancel order");
            System.out.println("4. Exit");
            System.out.print(">");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println(order);
                    break;
                case 2:
                      boolean moved = false;
                    for (OrderStatus s : OrderStatus.values()) {
                        if (order.getOrderStatus().canTransitionTo(s)) {
                            moved = order.transitionTo(s);
                            if (moved) {
                                System.out.println("Transitioned to: " + order.getOrderStatus());
                                break;
                            }
                        }
                    }
                    if (!moved) System.out.println("No valid forward transition from " + order.getOrderStatus());
                    break;
                case 3:
                    if (order.cancel()) System.out.println("Order cancelled.");
                    else System.out.println("Cannot cancel at status: " + order.getOrderStatus());
                    break;
                case 4:
                    System.out.println("Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }


        sc.close();
    }
}