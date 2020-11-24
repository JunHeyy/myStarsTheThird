import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.io.Console;

/**
 * Main driver class for the MySTARS system, also facilitates login.
 */
public class MySTARSApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
        //StaffUI.display();
       // StudentUI.display(StudentManager.getStudent("YANG0570"));
       // StudentUI.display(StudentManager.getStudent("CHAN0935"));
        boolean loginSuccess = false;
        Staff staffjj = new Staff("Staffjj", "passjj", 2);
        StaffManager.addStaff(staffjj);


        
        int choice;
        Scanner sc = new Scanner(System.in);
        Console con = System.console();

        Date date = new Date();
        String currentDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        String currentTime = new SimpleDateFormat("HH:mm").format(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String currenTime = dtf.format(now);


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
            Student student = StudentManager.getStudent(username);
            LocalDateTime localDateTime = LocalDateTime.now();

            if(student.getStartAccessTime().isBefore(localDateTime) && student.getEndAccessTime().isAfter(localDateTime))
                StudentUI.display(StudentManager.getStudent(username));
            else
                System.out.println("You are unable to access within this period of time");
        }
        else if (accountType == "Staff") {
            StaffUI.display();
        }
    }
}
