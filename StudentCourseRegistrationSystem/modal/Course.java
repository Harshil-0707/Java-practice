package modal;

public class Course{
    
    private String courseName;
    private int courseFee;


    // Set course name and course fee when object is created.

    public Course(String courseName,int courseFee){
        this.courseName = courseName;
        this.courseFee = courseFee;
    }

    // getters for course name and course fee

    public String getCourseName(){
        return this.courseName;
    }

    public int getCourseFee(){
        return this.courseFee;
    }

}