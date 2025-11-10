package modal;

public class Course{
    
    private String courseName;
    private int courseFee;

    public Course(String courseName,int courseFee){
        this.courseName = courseName;
        this.courseFee = courseFee;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public int getCourseFee(){
        return this.courseFee;
    }

    public void setCourseFee(int courseFee){
        if(courseFee <= this.courseFee ){
            this.courseFee -= courseFee;
            System.out.println("Course fee paid successfully!");
        }else{
            System.out.println("Invalid course fee");
        }
    }

}