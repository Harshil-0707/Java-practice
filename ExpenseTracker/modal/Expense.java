package modal;
import java.time.LocalDate;
import modal.category;

public class Expense{

    private double amount;
    private Category category;
    private LocalDate date;
    private String note;
    private static int idCounter;
    private int id;

    // Empty constuctor because default constructor is already overridden by parameterised constuctor. 
    public Expense(){}

    // This constructor sets the values of above fields. In short it addes expenses.
    public Expense(double amount,Category category,LocalDate date,String note){
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
        this.id = idCounter++;

        System.out.println("Expense successfully! \n\n===========================================\n");

    }

    public void editExpense(){

    }

    public void deleteExpense(){

    }

    public int getId(){
        return this.id;
    }

    public double getMonthlyTotal(){

    }

    public String getCategoryStats(){

    }

    public String searchByDateRange(){

    }

    public void saveToFile(){

    }

    public void loadFromFile(){
        
    }

}