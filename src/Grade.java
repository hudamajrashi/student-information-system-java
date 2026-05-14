package FinalProject;

enum Grades { A, B, C, D, F }
public class Grade{
	
	    private String grade;
	    
	    // Constructor calculates grade based on average marks
	    public Grade(int averageMarks, String course[][]) {
	    	this.course = course;
	        calculateGrade(averageMarks);
	    }

        String[][] course = {
            {"OOP", "DLD", "Biology"},
            {"CS2113", "CEN2000", "BOI2101"}
        };

        // method to display the courses and it's codes
	    public static void DisplyCourse(String[][] array) {
	        for (int col = 0; col < array[0].length; col++) {
	            // Print the course name followed by its corresponding code
	            System.out.println(array[0][col]);  // Course name
	            System.out.println(array[1][col]);  // Corresponding course code
	            System.out.println();  // Optional blank line for spacing between pairs
	        }
	    }
   

	    //  method to calculate grade
	    public void calculateGrade(int averageMarks) {
	        if (averageMarks >= 90) {
	            grade = "A";
	        } else if (averageMarks >= 80) {
	            grade = "B";
	        } else if (averageMarks >= 70) {
	            grade = "C";
	        } else if (averageMarks >= 60) {
	            grade = "D";
	        } else {
	            grade = "F";
	        }
	    }
	    public String getGrade() {
	        return grade;
	    }
	    
	}