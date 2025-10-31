import java.util.Scanner;

public class StudentMarksAnalyzer{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter markes of 5 studens:");

        int[] marks = new int[5];
        int sum = 0;
        int studentsAboveAvg = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Get marks of 5 students also calculate sum and find min and max marks of students.
        for(int i = 0 ; i < marks.length ;){
            if(!sc.hasNextInt()){
                System.out.println("Enter values makes!!");
                sc.next();
                continue;
            }
            marks[i] = sc.nextInt();
            if(marks[i] > 100 || marks[i] < 0){
                System.out.println("Enter values makes!!");
                continue;
            }
            sum += marks[i];
            max = max < marks[i] ? marks[i] : max;
            min = min > marks[i] ? marks[i] : min;
            i++;
        }

        float avgMarks = (float) sum / 5;

        // Print all the marks.
        System.out.print("\nAll Marks: ");
        for(int mark:marks){
            System.out.print(mark + " ");
            if(mark > avgMarks){
                studentsAboveAvg++;
            }
        }
        
        System.out.println("\nTotal Marks = " + sum);
        System.out.println("Average Marks = " + avgMarks);
        System.out.println("Highest Marks = " + max);
        System.out.println("Lowest Marks = " + min);
        System.out.println("Students scoring above average = " + studentsAboveAvg);

        sc.close();
    }
}