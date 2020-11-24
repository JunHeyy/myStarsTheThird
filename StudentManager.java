import java.io.*;
import java.util.ArrayList;

/**
 * Control class that handles all functions involving reading and writing to the Student database.
 */
public class StudentManager {

    private static ArrayList<Student> studentList;
	private static final String filename = "data/Students.dat";
	
	/**
	 * Retrieves a Student from the database.
	 * @param username 					Username of Student to be retrieved.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
	public static Student getStudent(String username) throws IOException, ClassNotFoundException {
		Student student = null;
        try {
	    	studentList = IOController.readFile(filename);
	        for (Student s: studentList) {
	            if (s.getUsername().equals(username)) {
	                student = s;
	            }
			}
		}
		catch (FileNotFoundException exception){
        	System.out.println("File not found");
        }
		return student;
	}

	/**
	 * Adds a Student into the database.
	 * @param student 					Student to be added to the database.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void addStudent(Student student) throws IOException, ClassNotFoundException {
        try {
	    	studentList = IOController.readFile(filename);
	        boolean found = false;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(student.getUsername())|| s.getMatricNum().equals(student.getMatricNum())) {
	                System.out.println("This student already exist in the database, unable to add student");
	                found = true;
	                break; 
	            }
	        }
	        if (!found) {
	        	studentList.add(student);
	        	System.out.println("The following students are registered:");
				for(Student s : studentList){
					System.out.println("Student name: "  +s.getName() +"is registered in the database");

				}
	        	System.out.println("Succesfully added student into the database");
	        	IOController.writeFile(filename, studentList);
	        	}
        }
        catch (FileNotFoundException exception){
        	System.out.println("File not found");
        }
        
    }

	/**
	 * Removes a Student from the database.
	 * @param username 					Username of Student to be removed.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void removeUser(String username) throws IOException, ClassNotFoundException {
       try {
	    	studentList = IOController.readFile(filename);
	        Student toDelete = null;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(username)) {
	                toDelete = s;
	                break;
	            }
	        }
	        if (toDelete != null) studentList.remove(toDelete);
	        IOController.writeFile(filename, studentList);
       }
       catch (FileNotFoundException exception) {
    	   System.out.println("File not found");
       }
       
    }
	
	/**
	 * Retrieves the ArrayList of all Students stored in the Student database.
	 * @return the ArrayList of all Students.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static ArrayList<Student> extractDB() throws IOException, ClassNotFoundException {
    	try {
	        ArrayList<Student> studentList = IOController.readFile(filename);
	        return studentList;
		}
		catch(FileNotFoundException exception) {
			System.out.println("File not found");	
			return null;
		}
    	
    }
	
	/**
	 * Updates the Course database.
	 * @param studentList Updated ArrayList of all Students in the database.
	 */
    public static void updateStudentDB(ArrayList<Student> studentList) {
    	try {
			IOController.writeFile(filename, studentList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}