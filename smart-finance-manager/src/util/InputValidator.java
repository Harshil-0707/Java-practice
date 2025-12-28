package util;

import config.AppConfig;
import java.util.Scanner;
import java.time.LocalDate;

public class InputValidator{

    Scanner sc = new Scanner(System.in);

    public int validateInt(String one,String two){
        while(true){
            if(!sc.hasNextInt()){
                SYstem.out.println(s);
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            if(choice < 1 || choice > 5){
                System.out.println(two);
                continue;
            }
            return choice;
        }
    }

    public double validateDouble(String one,String two){
        while(true){
            if(!sc.hasNextDouble()){
                SYstem.out.println(s);
                sc.nextLine();
                continue;
            }
            double amount = sc.nextDouble();
            if(amount < 100){
                System.out.println(two);
                continue;
            }
            return amount;
        }
    }

    public LocalDate validateDate(){
        while(true){
            String dateString = sc.nextLine();
            try{
                return LocalDate.parse(dateString,AppConfig.DATE_FORMAT);
            }catch(Exception e){
                System.out.println("Enter valid date");
            }finally{
                sc.nextLine();
            }
        }
    }


}