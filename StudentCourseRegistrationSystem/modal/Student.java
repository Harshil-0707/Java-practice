package modal;
import java.util.ArrayList;

public class Student{

    private String studentName;
    private int rollNumber;
    private int totalFee = 0;
    private int feePaid = 0;
    private ArrayList<Course> registeredCourses = new ArrayList<Course>();

    public Student(){}

    public Student(String studentName, int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    public void addCourse(Course c){
        registeredCourses.add(c);
        totalFee += c.getCourseFee();
    }

    public String getName(){
        return this.studentName;
    }

    public ArrayList<Course> getRegisteredCourses(){
        return registeredCourses;
    }

    public int getRoll(){
        return this.rollNumber;
    }

    public void payFees(int amount){
        if(amount <= 0){
            System.out.println("Invalid amount!");
            return;
        }

        if (feePaid + amount > totalFee) {
            System.out.println("You are trying to overpay!");
            return;
        }

        feePaid += amount;
        System.out.println("Payment of Rs " + amount + " successful!");
        System.out.println("Remaining Fee: " + (totalFee - feePaid));
    }

    public int getTotalFee(){
        return this.totalFee;
    }

    public int getFeePaid(){
        return this.feePaid;
    }

    public int getRemainingFee(){
        return this.totalFee-feePaid;
    }

}