import java.util.Scanner;
import system.RegistrationSystem;

public class App{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        RegistrationSystem rs = new RegistrationSystem();
        boolean running = true;

        while(running){
            System.out.println("1. Add Student");
            System.out.println("2. Create Course");
            System.out.println("3. Register Student into Course");
            System.out.println("4. Show Student Details");
            System.out.println("5. Fee Payment");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Enter a number from given options.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    rs.addStudent(sc);
                    break;
                case 2:
                    rs.createCourse(sc);
                    break;
                case 3:
                    rs.registerStudentIntoCourse(sc);
                    break;
                case 4:
                    rs.showStudentDetails(sc);
                   break;
                case 5:
                    rs.feePayment(sc);
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the system!\nExiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
        }

        sc.close();
        
    }
    
}