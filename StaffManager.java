import java.io.*;
import java.util.ArrayList;

public class StaffManager {

    private static ArrayList<Staff> staffList;
    private static final String filename = "data/Staff.dat";

    /**
	 * Adds a Staff into the database.
	 * @param staff 					Staff to be added to the database.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void addStaff(Staff staff) throws IOException, ClassNotFoundException {
        staffList = IOController.readFile(filename);
        boolean found = false;
        for (Staff s : staffList){
        	if(s.getStaffId() == staff.getStaffId()) {
        		System.out.println("Staff is already in database");
        		found = true;
        	}
        }
        if (!found) {
        	staffList.add(staff);
        	System.out.println("Succesfully added staff into the database");
            updateStaffDB(staffList);
        }
        
    }

	/**
	 * Removes a Staff from the database.
	 * @param username 					Username of Staff to be removed.
	 * @throws IOException 				if file does not exist.
	 * @throws ClassNotFoundException 	if mentioned classes are not found in the classpath.
	 */
    public static void removeStaff(String username) throws IOException, ClassNotFoundException {
        staffList = IOController.readFile(filename);
        Staff toDelete = null;
        for (Staff s: staffList) {
            if (s.getUsername().equals(username)) {
                toDelete = s;
                break;
            }
        }
        if (toDelete != null) staffList.remove(toDelete);
        updateStaffDB(staffList);
    }
    
	/**
	 * Retrieves the ArrayList of all Staff stored in the Staff database.
	 * @return the ArrayList of all Staff.
	 */
    public static ArrayList<Staff> extractStaff() {
    	try {
	        ArrayList<Staff> staffList = IOController.readFile("src/data/Staff.dat");
	        return staffList;
		}
		catch(Exception e) {
			System.out.println("File not found");	
			return null;
		}
    }
    
	/**
	 * Updates the Course database.
	 * @param staffList Updated ArrayList of all Staff in the database.
	 */
    public static void updateStaffDB(ArrayList<Staff> staffList) {
    	try {
			IOController.writeFile(filename, staffList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
}