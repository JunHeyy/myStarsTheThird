import java.util.ArrayList;

/**
 * Control class to handle all login related functions (password validation).
 */
public class LoginController {

    /**
     * Checks that account type and username are correct, then verifies that the password matches the User account.
     * @param accountType   The User's account type (one of "Student" or "Staff" only).
     * @param username      The User's username.
     * @param password      SThe user's raw password (unhashed).
     * @return true
     */
    public static boolean validate(String accountType, String username, String password) {
        User toMatch = null;
        if (accountType.equals("Student")) {
            try {
                ArrayList<Student> studentList = IOController.readFile("data/Students.dat");
                for (Student s: studentList) {
                    if (s.getUsername().equals(username)) {
                        toMatch = s;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("No user database found. Please try again.");
                return false;
            }
        }
        else if (accountType.equals("Staff")) {
            try {
                ArrayList<Staff> staffList = IOController.readFile("data/Staff.dat");
                for (Staff s: staffList) {
                    if (s.getUsername().equals(username)) {
                        toMatch = s;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("No user database found. Please try again.");
                return false;
            }
        }
    
        if (toMatch == null) {
            return false;
        }
        else {
            if (toMatch.getPassword().equals(Hashing.hashPassword(password))) return true;
            else return false;
        }
    }
}