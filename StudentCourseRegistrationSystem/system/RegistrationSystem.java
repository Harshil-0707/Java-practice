package system;
import java.util.ArrayList;
import java.util.Scanner;
import modal.Course;
import modal.Student;

public class RegistrationSystem{

    private ArrayList<Course> allCourses = new ArrayList<>();
    private ArrayList<Student> allStudents = new ArrayList<>();

    public void addStudent(Scanner sc){
        
        System.out.print("Enter your name: ");
        String studentName = sc.nextLine();
        int rollNumber;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            rollNumber = sc.nextInt();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }

        Student s = new Student(studentName,rollNumber);
        allStudents.add(s);

        System.out.println("Student added successfully!");

    }

    public void createCourse(Scanner sc){

        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();
        int courseFee;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            courseFee = sc.nextInt();
            if(courseFee < 0){
                System.out.println("Invalid course fee.");
                continue;
            }
            break;
        }

        Course c = new Course(courseName,courseFee);
        allCourses.add(c);

        System.out.println("Course added successfully!");
        
    }

    public void registerStudentIntoCourse(Scanner sc){
        int rollNumber;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            rollNumber = sc.nextInt();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }

        Student s = null;
        for(Student st : allStudents){
            if(rollNumber == st.getRoll()){
                s = st;
                break;
            }
        }

        if(null == s){
            System.out.println("Student not found.");
            return;
        }

        for(Course ac : allCourses){
            System.out.println((allCourses.indexOf(ac) + 1) + ". " + ac.courseName + " - Rs " + ac.courseFee);
        }

        while(true){
            System.out.print("Choose course number to register: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();

            if(choice - 1 > allCourses.size() || choice - 1 < 1){
                System.out.println("Enter number between given option.");
                continue;
            }
            Student st = new Student();
            st.addCourse(allCourses.get(choice));
            System.out.println("Course registered successfully!");
            break;
        }
    }

    public void showStudentDetails(Scanner sc){
        int rollNumber;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            rollNumber = sc.nextInt();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }
        int amountToPay;
        while(true){
            System.out.print("Enter amount to pay: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter valid amount.");
                sc.next();
                continue;
            }
            amountToPay = sc.nextInt();
            if(amountToPay < 0){
                System.out.println("Invalid amount.");
                continue;
            }
            break;
        }
    }

    public void feePayment(Scanner sc){
        int rollNumber;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            rollNumber = sc.nextInt();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }
    }

}