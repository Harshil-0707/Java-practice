import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        boolean running = true;

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
                    
                    break;
                case 2:
                    break;
                case 3:
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