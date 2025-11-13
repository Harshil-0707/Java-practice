package systems;
import java.util.ArrayList;
import java.util.Scanner;
import modal.*;

/*
* This class handles all the logic for the student's course registration system
*/

public class RegistrationSystem{

    // To store all the course that has been created and also all the students that are registered

    private ArrayList<Course> allCourses = new ArrayList<>();
    private ArrayList<Student> allStudents = new ArrayList<>();


    // A simple function to get student by roll number

    private Student findStudentByRoll(int rollNumber){
        for(Student s : allStudents){
            if(rollNumber == s.getRoll()){
                return s;
            }
        }
        return null;
    }

    // Add student

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
            sc.nextLine();
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


    // Create course

    public void createCourse(Scanner sc){

        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();
        int courseFee;
        while(true){
            System.out.print("Enter course fee: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter course fee.");
                sc.next();
                continue;
            }
            courseFee = sc.nextInt();
            sc.nextLine();
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

    // Register course into student's object

    public void registerStudentIntoCourse(Scanner sc){
        if(allCourses.size() == 0){
            System.out.println("Create the course first.");
            return;
        }
        int rollNumber;
        while(true){
            System.out.print("Enter roll number: ");
            if(!sc.hasNextInt()){
                System.out.println("Please enter your roll number.");
                sc.next();
                continue;
            }
            rollNumber = sc.nextInt();
            sc.nextLine();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }

        Student s = findStudentByRoll(rollNumber);

        if(null == s){
            System.out.println("Student not found.");
            return;
        }

        for(Course ac : allCourses){
            System.out.println((allCourses.indexOf(ac) + 1) + ". " + ac.getCourseName() + " - Rs " + ac.getCourseFee());
        }

        while(true){
            System.out.print("Choose course number to register: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice > allCourses.size() || choice < 1){
                System.out.println("Enter number between given option.");
                continue;
            }
            for(Course c : s.getRegisteredCourses()){
                if(c.getCourseName().equalsIgnoreCase(allCourses.get(choice-1).getCourseName())){
                    System.out.println("You are already registered in the course.");
                    return;
                }
            }
            s.addCourse(allCourses.get(choice-1));
            System.out.println("Course registered successfully!");
            break;
        }
    }


    // Show student info by roll number

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
            sc.nextLine();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }
        Student s = findStudentByRoll(rollNumber);

        if(null == s){
            System.out.println("Student not found.");
            return;
        }

        System.out.println("---------- Student Details ----------");
        System.out.println("Name: " + s.getName());
        System.out.println("Roll: " + rollNumber);
        System.out.println("Courses Registered:");
        for (Course c : s.getRegisteredCourses()) {
            System.out.println("- " + c.getCourseName() + " (Fee: " + c.getCourseFee() + ")");
        }
        System.out.println("-------------------------------------");
        System.out.println("Total Fee: " + s.getTotalFee());
        System.out.println("Fee Paid: " + s.getFeePaid());
        System.out.println("Remaining Fee: " + s.getRemainingFee());
       
    }


    // Fee payment

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
            sc.nextLine();
            if(rollNumber <= 0){
                System.out.println("Invalid roll number.");
                continue;
            }
            break;
        }
        Student s = findStudentByRoll(rollNumber);

        if(null == s){
            System.out.println("Student not found.");
            return;
        }
        if(s.getRegisteredCourses().size() == 0){
            System.out.println("Enroll in the course first.");
            return;
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
            sc.nextLine();
            if(amountToPay < 0){
                System.out.println("Invalid amount.");
                continue;
            }
            break;
        }

        s.payFees(amountToPay);
    }

}