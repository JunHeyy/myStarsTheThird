import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Console;

/**
 * Boundary class to display user interface for student functions.
 */
public class StudentUI {

    public static void display(Student s) throws ClassNotFoundException, IOException, FileNotFoundException {

        int choice;
        Scanner sc = new Scanner(System.in);
        Console con = System.console();
        Student student = s;

        do {
            System.out.println("Menu: ");
            System.out.println("(1) Add course ");
            System.out.println("(2) Drop course ");
            System.out.println("(3) Check/Print courses registered ");
            System.out.println("(4) Check vacancies available ");
            System.out.println("(5) Change index number of course ");
            System.out.println("(6) Swap index number with another student ");
            System.out.println("(7) Log off");
            System.out.print("Select an option: ");

            while (true){
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                }catch(Exception NumberFormatException) {
                    System.out.println("Please enter choice again (1-7) and only integers");
                }

            }






            switch (choice) {
                case 1:
                    try {
                        StaffController.printAllCourses();
                        System.out.print("Enter the course code to be added: ");
                        String courseToAdd = sc.nextLine();
                        System.out.print("Enter the index number to be added: ");
                        int indexToAdd = Integer.parseInt(sc.nextLine());
                        student = StudentController.addCourse(student, indexToAdd, courseToAdd);

                        }catch(Exception NumberFormatException){
                            System.out.println("Please key in only integers in the index!");
                        } finally{break;}



                case 2:
                    StudentController.printCourseRegistered(student);
                    System.out.print("Enter the course code to be removed: ");
                    String courseToRemove = sc.nextLine();
                    student = StudentController.removeCourse(student, courseToRemove);
                    break;
                case 3:
                    StudentController.printCourseRegistered(student);
                    break;
                case 4:
                    try {
                        System.out.print("Enter the index number to be checked: ");
                        int indexToCheck = Integer.parseInt(sc.nextLine());
                        StudentController.printVacancies(indexToCheck);
                    }catch(Exception NumberFormatException){
                        System.out.println("Please key in only integers in the index!");
                    }finally{break;}

                case 5:
                    try {
                        StaffController.printAllCourses();
                        System.out.print("Enter the course code for the course to be changed: ");
                        String courseCode = sc.nextLine();
                        System.out.print("Enter the new index number: ");
                        int indexToChange = Integer.parseInt(sc.nextLine());
                        student = StudentController.changeAvailableIndex(student, indexToChange, courseCode);
                    }catch(Exception NumberFormatException){System.out.println("Please key in only integers in the index!");
                    }finally{break;}
                case 6:
                    try {
                        StudentController.printCourseRegistered(student);
                        System.out.print("Enter your index to be swapped: ");
                        int ownIndex = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter the other student's index to be swapped: ");
                        int peerIndex = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter the other student's matriculation number: ");
                        String peerMatricNum = sc.nextLine();
                       // char[] readin = con.readPassword("Enter the other student's password: ");
                         System.out.print("Enter the other student's password: ");
                         String peerPw = sc.nextLine();
                       // String peerPw = String.valueOf(readin);
                        student = StudentController.swapIndex(student, ownIndex, peerIndex, peerMatricNum, peerPw);
                    }catch(Exception NumberFormatException){
                        System.out.println("Please key in integers for integer only fields");
                    }finally{break;}
                case 7:
                    System.out.println("Quitting program...");
                    break;
                default:
                    System.out.println("Invalid input! Please select a valid choice.");
                    break;
            }
        } while (choice != 7);
    }

}
