package FinalProject;

import java.io.*;
import java.util.Scanner;

public class University {

    public static void main(String[] args) {
        System.out.println("Welcome to the University System");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        String password;
        while (true) {
            try {
                System.out.print("Enter password: ");
                password = scanner.nextLine();

                // Check if password contains any whitespace
                if (password.contains(" ")) {
                    // If it does, throw an exception to enter the catch block
                    throw new Exception("Invalid password. Password cannot contain spaces.");
                } else {
                    break; // Exit the loop if the password is valid
                }
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display error message
            }
        }


        System.out.print("\nEnter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student age: ");
        int studentAge = scanner.nextInt();
        System.out.print("Enter student ID: ");
        String studentID = scanner.next();

        System.out.println("Enter student marks for 3 subjects:");
        int[] marks = new int[3];
        for (int i = 0; i < marks.length; i++) { // for loop to store the marks in array
            System.out.print("Mark " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Method to calculate average marks
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        int averageMarks = sum / marks.length;

        String[][] course = {
            {"OOP", "DLD", "Biology"},
            {"CS2113", "CEN2000", "BOI2101"}
        };

        Student student = new Student(studentName, studentAge, studentID, marks);
        Grade grade = new Grade(averageMarks, course);

        System.out.println("\nStudent Information:");
        student.displayStudentInfo();
        student.sortMarks();

        System.out.println("\nFor these courses:");
        Grade.DisplyCourse(grade.course);

        System.out.println("Student Grade: " + grade.getGrade());

        // Allow the user to search for a course
        System.out.print("\nEnter the course name to search for its code: ");
        String courseName = scanner.next();

        String courseCode = student.getCourseCode(courseName, course);
        System.out.println("The corresponding course code for " + courseName + " is: " + courseCode);

        // Write student information to a file
        writeStudentToFile(student);
    }

      // Method to write student information to a file using PrintWriter
      public static void writeStudentToFile(Student student) {
        PrintWriter writer = null;

        try {
            // Create a new file or overwrite if it already exists
            File file = new File("students.txt");
            writer = new PrintWriter(file);

            // Write student information to the file
            writer.println("Name: " + student.name);
            writer.println("Age: " + student.age);
            writer.println("ID: " + student.getId());
            writer.println("Marks: " + java.util.Arrays.toString(student.getMarks())); // Accessing marks using the getter
            System.out.println("Student information written to file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while creating or writing to the file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close(); // Close the PrintWriter
            }
        }
    }
    }
