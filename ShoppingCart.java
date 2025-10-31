import java.util.Scanner;

public class ShoppingCart{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int[] cart = new int[15];
        boolean addMore = true;
        int totalAmout = 0;

        // Print selection options
        System.out.println("Available Items:");
        System.out.println("1. 100");
        System.out.println("2. 250");
        System.out.println("3. 75");
        System.out.println("4. 300");
        System.out.println("5. 120\n");

        // Loop will be executed until cart is empty or user exits by him/her self.
        for(int i = 0 ; i < cart.length && addMore ; ){
            System.out.print("Enter item number to add: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number from given options.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    cart[i] = 100;
                    break;
                case 2:
                    cart[i] = 250;
                    break;
                case 3:
                    cart[i] = 75;
                    break;
                case 4:
                    cart[i] = 300;
                    break;
                case 5:
                    cart[i] = 120;
                    break;
                default:
                    addMore = true;
                    System.out.println("Invalid choice.");
                    continue;
            }

            System.out.print("Add another item? (y/n): ");
            char addAnotherItem = sc.next().trim().toLowerCase().charAt(0);

            // Exit loop if cart is full or user exits.
            switch(addAnotherItem){
                case 'Y':
                case 'y':
                    i++;
                    if(i == cart.length){
                        System.out.println("\nYou cannot put more items in the cart because it's full now!!!");
                        addMore = false;
                    }else{
                        addMore = true;
                    }
                    break;
                case 'n':
                case 'N':
                    addMore = false;
                    break;
                default: 
                    addMore = false;
            }
        }

        // Print all the items purchesed
        System.out.print("\nItems purchased : ");
        for(int item:cart){
            if(item == 0) break;
            System.out.print(" " + item);
            totalAmout += item;
        }

        System.out.println("\nTotal = " + totalAmout);
        
        // Calculate discount amount
        int discount = totalAmout > 500 ? ( (totalAmout * 10) / 100 ) : 0;
        System.out.println("Discount = " + discount);
        
        // Subtract discount from the total amount.
        totalAmout = totalAmout - discount;
        System.out.println("Final amount = " + totalAmout);

        // Close Scanner object to stop any kind of memory leak.
        sc.close();
    }
}