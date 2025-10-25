import java.util.Scanner;

/*

This is a Grade Calculator that takes the marks of 5 subjects, calculates the total and average, and displays whether the student has passed or failed. If the student has passed, it also shows the grade he or she received.

*/

public class GradeCalculator{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        boolean addMarksAgain = true;

        while(addMarksAgain){
            
            int totalMarks = 0;
            int failedSubCount = 0;
            int[] Marks = new int[5];
            boolean lessThen33 = false;
            
            // Take marks of five subjects
            System.out.println("Enter marks of 5 subjects: ");
            for(int i = 0 ; i < 5 ;){
                System.out.print("Subject " + (i+1) + ": ");

                //Check if the input is number or not
                if(!sc.hasNextInt()){
                    System.out.println("Marks should be numbers between 0 to 100!!!");
                    sc.next();
                    continue;
                }
                
                // Check whether the marks are between 0 to 100.
                Marks[i] = sc.nextInt();
                if(Marks[i] > 100 || Marks[i] < 0){
                    System.out.println("Marks should be between 0 and 100!!!");
                }else{
                    if(Marks[i] < 33){
                        lessThen33 = true;
                        failedSubCount++;
                    }
                    totalMarks += Marks[i];
                    i++;
                }
               
            }

            float percentage = (float)(totalMarks*100) / 500;

            System.out.println("\nTotal marks = " + totalMarks);
            System.out.println("Percentage = " + percentage + "%");


            // Check if student got less then 33 in any subject.
            if(lessThen33){
                System.out.println("Fail!!"); 
                System.out.println("You failed in " + failedSubCount + " Subject" + (failedSubCount > 1 ? "s" : ""));
            }else if(percentage >= 90 && percentage <= 100){
                System.out.println("Grade A+");
            }else if(percentage >= 80 && percentage < 90){
                System.out.println("Grade A");
            }else if(percentage >= 70 && percentage < 80){
                System.out.println("Grade B");
            }else if(percentage >= 60 && percentage < 70){
                System.out.println("Grade C");
            }else if(percentage >= 50 && percentage < 60){
                System.out.println("Grade D");
            }else {
                System.out.println("Fail!!");
            }

            System.out.print("\nDo you want to calculate for another student? (y/n):");
            char choice = sc.next().trim().toLowerCase().charAt(0);

            switch(choice){
                case 'Y':
                case 'y':
                    addMarksAgain = true;
                    break;
                case 'n':
                case 'N':
                    addMarksAgain = false;
                    break;
                default: 
                    addMarksAgain = false;
            }
        }
        sc.close();
    }
}