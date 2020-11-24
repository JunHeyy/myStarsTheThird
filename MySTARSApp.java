import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.Console;

/**
 * Main driver class for the MySTARS system, also facilitates login.
 */
public class MySTARSApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
       // StaffUI.display();
        boolean loginSuccess = false;
        Staff staffjj = new Staff("Staffjj", "passjj", 2);
        StaffManager.addStaff(staffjj);


        
        int choice;
        Scanner sc = new Scanner(System.in);
        Console con = System.console();

        String accountType = null;
        String username = null;
        String password = null;

        while (!loginSuccess) {
            do {
                System.out.println("Select your account type:");
                System.out.println("1. Student");
                System.out.println("2. Staff");
                choice = Integer.parseInt(sc.nextLine());    
                switch (choice) {
                    case 1:
                        accountType = "Student";
                        //StaffController.addCourse("OODP");
                        break;
                    case 2:
                        accountType = "Staff";
                        break;
                    default:
                        System.out.println("Invalid input! Please select a valid choice.");
                        break;
                }
            } while (choice != 1 && choice != 2);
            System.out.print("Enter your username: ");
            username = sc.nextLine();
            //char [] readin;
           // readin = con.readPassword("Enter your password: ");
            //password = String.valueOf(readin);
             System.out.println("Enter your password: ");
             password = sc.nextLine();

            loginSuccess = LoginController.validate(accountType, username, password);

            if (!loginSuccess) System.out.println("Username or password incorrect.");
        }
        
        if (accountType == "Student") {
            StudentUI.display(StudentManager.getStudent(username));
        }
        else if (accountType == "Staff") {
            StaffUI.display();
        }
    }
}
