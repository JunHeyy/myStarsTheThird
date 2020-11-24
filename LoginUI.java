import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Boundary class to display the login user interface.
 */
public class LoginUI {
        
    /**
     * Reads in account type, username and password from User and passes them as input to the LoginController class to validate.
     */
    public static void loginProcess() throws NoSuchAlgorithmException {

        boolean success = false;
        
        int choice;
        Scanner sc = new Scanner(System.in);

        String accountType = null;
        String username = null;
        String password = null;

        while (!success) {
            System.out.println("Select your account type:");
            System.out.println("1. Student");
            System.out.println("2. Staff");
            choice = Integer.parseInt(sc.nextLine());
            do {
                switch (choice) {
                    case 1:
                        accountType = "Student";
                        break;
                    case 2:
                        accountType = "Staff";
                        break;
                    default:
                        System.out.println("Invalid input! Please select a valid choice.");
                }
            } while (choice != 1 && choice != 2);

            System.out.println("Enter your username: ");
            username = sc.nextLine();
            System.out.println("Enter your password: ");
            password = sc.nextLine();

            success = LoginController.validate(accountType, username, password);

            if (!success) System.out.println("Username or password incorrect.");
        }
    }
}