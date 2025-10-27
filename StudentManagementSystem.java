import java.util.Scanner;


/*
    This code is about simple student management system using java it uses 1D and 2D array to store data , static functions to make code re-usable and modular.
*/

public class StudentManagementSystem{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        // [10] is number of rows and [5] is number of columns in marks array. 
        int studentCount = 0;
        int[] avg = new int[10];
        int[][] marks = new int[10][5];
        int[] totalMarks = new int[10];
        int[] rollNumbers = new int[10];

        // Keep track whether to run the while loop for student management system or not.
        boolean run = true;
        // Below string array can hold total 10 strings(names).
        String[] names = new String[10];
        String[] grades = new String[10];
        

        // This loop will be executed until user selects 5th option.

        while(run){

            System.out.println("===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Show Topper");
            System.out.println("5. Exit");

            System.out.print("\nEnter you choice: ");
            if(!sc.hasNextInt()){
                System.out.println("Enter a number between 1 to 5.");
                sc.next();
                continue;
            }

            int processId = sc.nextInt();

            switch(processId){
                case 1:
                    studentCount = addStudents(names , grades , rollNumbers , marks , studentCount  , totalMarks  , sc);
                    break;
                case 2:
                    showAllStudents(names , grades , rollNumbers , marks , studentCount  , totalMarks);
                    break;
                case 3:
                    SearchStudent(rollNumbers , names , grades , totalMarks  , sc);
                    break;
                case 4:
                    TopperStudent(totalMarks, names , rollNumbers);
                    break;
                case 5:
                    run = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Enter a number between 1 to 5");
            }
        }

        sc.close();
    }

    static int addStudents(String[] names,String[] grades,int[] rollNumbers,int[][] marks,int studentCount,int[] totalMarks,Scanner sc){
        
        boolean addMore = true;

        // Execute loop if user select 1st option and when user types y or Y to enter another student's marks.
        while(addMore){

            System.out.print("Enter student name: ");
            String name = sc.next();
            for(int i = 0 ; i < names.length;i++){
                if(null == names[i]){
                    names[i] = name;
                    break;
                }
            }
            
            // Don't exit the loop until the students enter the correct marks for all subjects.
            while(true){
                System.out.print("Enter roll number: ");
                if(!sc.hasNextInt()){
                    System.out.println("Please enter a number.");
                    sc.next();
                    continue;
                }

                int rollNo = sc.nextInt();
                
                if(0 >= rollNo){
                    System.out.println("Roll number cannot be less than or equal to 0");
                    continue;
                }

                for(int i = 0 ; i < rollNumbers.length ; i++){
                    if(rollNo == rollNumbers[i]){
                        System.out.println("Students cannot have duplicate roll numbers.");
                        rollNo = -1;
                        break;
                    }
                    if(0 == rollNumbers[i]){
                        rollNumbers[i] = rollNo;
                        break;
                    }
                }
                if(-1 == rollNo){
                    continue;
                }else{
                    break;
                }
            }

            for(int col = 0; col < marks[studentCount].length ;){
                System.out.print("Enter marks of subject " + (col + 1) + ": ");
                if(!sc.hasNextInt()){
                    System.out.println("Enter a number between 0 to 100.");
                    sc.next();
                    continue;
                }

                marks[studentCount][col] = sc.nextInt();
                if(marks[studentCount][col] < 0 || marks[studentCount][col] > 100){
                    System.out.println("Enter valid marks.");
                    continue;
                }
                totalMarks[studentCount] += marks[studentCount][col];
                col++;
            }

            float percentage = (float)((totalMarks[studentCount] * 100) / 500);

            if(percentage >= 90 && percentage <= 100){
                grades[studentCount] = "Grade A+";
            }else if(percentage >= 80 && percentage < 90){
                grades[studentCount] = "Grade A";
            }else if(percentage >= 70 && percentage < 80){
                grades[studentCount] = "Grade B";
            }else if(percentage >= 60 && percentage < 70){
                grades[studentCount] = "Grade C";
            }else if(percentage >= 50 && percentage < 60){
                grades[studentCount] = "Grade D";
            }else {
                grades[studentCount] = "Fail!!";
            }

            System.out.println("Student added successfully!");
            
            System.out.print("\nDo you want to add another student? (y/n): ");
            char choice = sc.next().trim().toLowerCase().charAt(0);
            
            switch(choice){
                case 'y':
                case 'Y':
                    addMore = true;
                    ++studentCount;
                    break;
                case 'n':
                case 'N':
                default:
                    addMore = false;
                    break;
            }
        }
        return ++studentCount;
    }

    static void showAllStudents(String[] names,String[] grades,int[] rollNumbers,int[][] marks,int studentCount,int[] totalMarks){
        if(0 == studentCount){
            System.out.println("\nFirst add student's data.\n");
            return;
        }

        // This is used to format string properly so that it's structure stay as it is.
        System.out.printf("%-8s | %-15s | %-12s | %-10s | %-8s%n", 
                  "Roll No", "Name", "Total marks", "Average", "Grade");
        System.out.println("-------------------------------------------------------------");

        for(int i = 0; i < studentCount; i++){
            System.out.printf("%-8d | %-15s | %-12d | %-10d | %-8s%n",
                            rollNumbers[i], names[i], totalMarks[i], totalMarks[i]/5, grades[i]);
        }

        System.out.println("");
    }

    static void TopperStudent(int[] totalMarks,String[] names,int[] rollNumbers){

        if(null == names[0]){
            System.out.println("First add the student's details to see the topper student.");
            return;
        }

        int highestMarks = 0;
        int idx = 0;
        for(int i = 0 ; i < totalMarks.length ; i++){
            if(highestMarks < totalMarks[i]){
                highestMarks = totalMarks[i];
                idx = i;
            }
        }
        System.out.println("Topper: " + names[idx] + " (Roll no: " + rollNumbers[idx] + ") - Total Marks: " + highestMarks + "\n");
    }

    static void SearchStudent(int[] rollNumbers,String[] names,String[] grades,int[] totalMarks ,Scanner sc){
        while(true){
                System.out.print("Enter the Roll number of student: ");

                if(!sc.hasNextInt()){
                    System.out.println("Please enter a number.");
                    sc.next();
                    continue;
                }

                int rollNumber = sc.nextInt();
                
                if(0 >= rollNumber){
                    System.out.println("Roll number cannot be less than or equal to 0");
                    continue;
                }

                for(int i = 0 ; i < rollNumbers.length ; i++){
                    if(rollNumber == rollNumbers[i]){
                        System.out.println("\n===== These are the student details of given roll number =====\n");
                        System.out.println("Roll number: " + rollNumber);
                        System.out.println("Name: " + names[i]);
                        System.out.println("Total marks: " + totalMarks[i]);
                        System.out.println("Average marks: " + (totalMarks[i] / 5));
                        System.out.println("Grades : " + grades[i] + "\n");
                        return;
                    }
                }
                System.out.println("Student with roll number " + rollNumber + " does not exists.\n");
                continue;
            }
    }
}