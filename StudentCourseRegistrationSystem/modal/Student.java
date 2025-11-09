package modal;
import java.util.ArrayList;

public class Student{

    private String studentName;
    private int rollNumber;
    private ArrayList<Course> registeredCourses = new ArrayList<Course>();

    public Student(String studentName, int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    public void addCourse(Course c){
        registeredCourses.add(c);
    }

    public ArrayList<Course> getRegisteredCourses(){
        return registeredCourses;
    }

    public int getRoll(){
        return this.rollNumber;
    }

}