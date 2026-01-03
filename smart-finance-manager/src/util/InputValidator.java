package util;

import config.AppConfig;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator{

    private static Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter FULL_FMT =
    DateTimeFormatter.ofPattern(AppConfig.FULL_DATE_FORMAT);
    private static final DateTimeFormatter HALF_FMT =
    DateTimeFormatter.ofPattern(AppConfig.HALF_DATE_FORMAT);

    public static int getInt(int min , int max,String one,String two){
        while(true){
            if(!sc.hasNextInt()){
                System.out.println(one);
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice < 1 || choice > 5){
                System.out.println(two);
                continue;
            }
            return choice;
        }
    }

    public static double getDouble(String one,String two){
        while(true){
            if(!sc.hasNextDouble()){
                System.out.println(one);
                sc.nextLine();
                continue;
            }
            double amount = sc.nextDouble();
            sc.nextLine();
            if(amount < 100){
                System.out.println(two);
                continue;
            }
            return amount;
        }
    }

    public static LocalDate getFullDate() {
        while (true) {
            try {
                String input = sc.nextLine();
                return LocalDate.parse(input, FULL_FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Enter date in format: dd-MM-yyyy");
            }
        }
    }


    public static YearMonth getMonthYear() {
        while (true) {
            try {
                String input = sc.nextLine();
                return YearMonth.parse(input, HALF_FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Enter month-year in format: MM-YYYY");
            }
        }
    }



    public static String getString(){
        return sc.nextLine();
    }

}