import java.io.IOException;
import java.util.ArrayList;

/**
 * Control class that handles all functions involving reading and writing to the Course database.
 */
public class CourseManager implements StarsManager{
	
    private static ArrayList<Course> courseList;
    private static final String filename = "data/Course.dat";
    
    /**
	 * Adds new Course into the database
	 * @param course 					Course to be added.
	 * @throws IOException 				if file cannot be read in.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void addCourse(Course course) throws IOException, ClassNotFoundException {
        
        ArrayList<Course> courseList = IOController.readFile(filename);
        boolean found = false;
        for(Course c : courseList) {
        	if(c.getCourseCode().equals(course.getCourseCode())) {
        		System.out.println("The course is already in the database");
        		found = true;
        		break;
        	}
        }
        if (!found) {
        	courseList.add(course);
			System.out.println("These are the course registered in the database");
			for(Course c : courseList){
				System.out.println("Coursename: "  + c.getCourseName() + " CourseCode: " + c.getCourseCode());
			}
			System.out.println("Success you have just registered");
	        IOController.writeFile(filename, courseList);
        }
    }

	/**
	 * Remove course from the database.
	 * @param courseCode 				Course code of the Course to be removed.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void removeCourse(String courseCode) throws IOException, ClassNotFoundException {
    	courseList = IOController.readFile(filename);
        Course toDelete = null;
        for (Course c: courseList) {
            if (c.getCourseCode().equals(courseCode)) {
                toDelete = c;
                break;
            }
        }
        if (toDelete != null) {
        	System.out.println("Removing index...");
        	courseList.remove(toDelete);
        	System.out.println("Success");
        	IOController.writeFile(filename, courseList);
        }
        else {
        	System.out.println("There is no such Course in the database");
        }
        
	}
	
    /**
	 * Removes a slot from an Index when a Student registers for it
	 * @param newIndex 					The index number of the Index belonging to the Course that a Student has registered for.
	 * @param CourseCode  				The course code of the Course that a student has registered for.
	 * @throws IOException				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void slotTaken(int newIndex, String courseCode) throws IOException, ClassNotFoundException{
		ArrayList<Course> courseList = extractDB();
		for (Course c: courseList) {
			for (Index i : c.getIndexList()) {
				if (c.getCourseCode().equals(courseCode) && (i.getIndexNum() == newIndex)) {
					i.setNumStudents(i.getNumStudents() + 1);
					UpdateDB(courseList);
					
					break;
				}
			}
		}
  	}

   /**
	 * Adds a slot to an Index when a Student drops it
	 * @param oldIndex 					The index number of the Index belonging to the Course that a Student has dropped.
	 * @param courseCode  				The course code of the Course that a student has dropped.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
   	public static void slotGivenBack(int oldIndex, String courseCode) throws IOException, ClassNotFoundException{
	   	 ArrayList<Course> courseList = extractDB();
	   	 for(Course c: courseList) {
			for(Index i : c.getIndexList()) {
				if((i.getIndexNum() == oldIndex) && c.getCourseCode().equals(courseCode)) {
					
					i.setNumStudents(i.getNumStudents() - 1);
					UpdateDB(courseList);
					
					break;
				}
			}
	   	}
	}
	
    /**
	 * Retrieves the ArrayList of all courses stored in the Course database.
	 * @return the ArrayList of all courses.
	 */
    public static ArrayList<Course> extractDB() {
    	try {
	        ArrayList<Course> courseList = IOController.readFile(filename);
	        return courseList;
		}
		catch(Exception e) {
			System.out.println("File not found");	
			return null;
		}
    }
    
    /**
	 * Updates the Course database.
	 * @param courseList Updated ArrayList of all courses in the database.
	 */
    public static void UpdateDB(ArrayList<Course> courseList) throws IOException {
    	try {
			IOController.writeFile(filename, courseList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
