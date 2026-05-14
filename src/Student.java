package FinalProject;

class Student extends Person {
	
	    private int[] mark;  
	    private String id;

	    // Constructor
	    public Student(String name, int age, String id, int[] mark) {
	        super(name, age); 
	        this.setId(id);
	        this.mark = mark;
	    }

	    // Getter for marks
	    public int[] getMarks() {
	        return mark;
	    }
	    
	    // getter for id
    	public String getId() {
		   return id;
	   }
       // setter for id
	    public void setId(String id) {
		   this.id = id;
	   }
	    
	    // Method to calculate average marks
	    private int getAverageMarks() {
	        int sum = 0;
	        for (int marks : mark) {
	            sum += marks;
	        }
	        return sum / mark.length;
	    }
	    
	    // method to display the grades
	    public void displayGrades() {
	        for (int grades : mark) 
           System.out.println(grades);}		       
	        
	    //  method to display student details
	    public void displayStudentInfo() {
	    	printInfo(); // Calls method from the Person class
	        System.out.println("Student ID: " + getId());
	        System.out.println("Average Marks: " + getAverageMarks());
	        
	    }

	    // Method to sort marks in descending order (highest to lowest)
	    public void sortMarks() {
	        for (int i = 0; i < mark.length - 1; i++) {
	            for (int j = 0; j < mark.length - 1 - i; j++) {
	                if (mark[j] < mark[j + 1]) {
	                    int temp = mark[j];
	                    mark[j] = mark[j + 1];
	                    mark[j + 1] = temp;
	                }
	            }
	        }
	        
	        // After sorting, display the sorted marks
	        System.out.println("Sorted Marks (Highest to Lowest):");
	        for (int sortedMark : mark) {
	            System.out.println(sortedMark);
	        }
	    }
	    
	      // Method to search for a course and get its corresponding code
	      public String getCourseCode(String courseName, String[][] courseArray) {
	        for (int i = 0; i < courseArray[0].length; i++) {
	            if (courseArray[0][i].equalsIgnoreCase(courseName)) { 
	                return courseArray[1][i]; // Return corresponding course code
	            }
	        }
	        return "Course not found"; // If course is not found
	    }

    }