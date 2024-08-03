import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine();  

        
        String[] subjectNames = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];
        
        
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();
            System.out.print("Enter marks for " + subjectNames[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine();  
        }
        
     
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        
       
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        
        System.out.println("\nSubject-wise Results:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("Subject: " + subjectNames[i] + ", Marks: " + marks[i]);
        }
        
        System.out.println("\nOverall Results:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
      
    }
}
