import java.time.*;
import java.util.ArrayList;

/**
 * Concrete entity class representing each Student user account.
 */
public class Student extends User {

    private String name;
    private String matricNum;
    private char gender;
    private String nationality;
    private int yearOfStudy;
    private ArrayList<Index> registeredIndex;
    private ArrayList<Index> waitIndex;
    private LocalDateTime startAccessTime;
    private LocalDateTime endAccessTime;
    private static final long serialVersionUID = 10;

    /**
     * Creates a Student user account with Student's account and personal details and system access time.
     * @param username          Username of Student account.
     * @param password          Raw password (unhashed) of Student account.
     * @param name              Full name of Student (as in NRIC).
     * @param matricNum         Matriculation number of the Student.
     * @param gender            Student's gender (M or F).
     * @param nationality       Student's nationality.
     * @param yearOfStudy       Current year of study (1 to 5).
     * @param startAccessTime   Start time that Student can access the MySTARS system.
     * @param endAccessTime     End time after which the Student can no longer access the MySTARS system..
     */
    public Student(String username, String password, String name, 
            String matricNum, char gender, String nationality, 
            int yearOfStudy, LocalDateTime startAccessTime, LocalDateTime endAccessTime) {
        super(username, password, "Student");
        this.name = name;
        this.matricNum = matricNum;
        this.gender = gender;
        this.nationality = nationality;
        this.yearOfStudy = yearOfStudy;
        this.startAccessTime = startAccessTime;
        this.endAccessTime = endAccessTime;
        this.registeredIndex = new ArrayList<Index>();
        this.waitIndex = new ArrayList<Index>();
    }

    /**
     * Creates a Student user account with Student's account and personal details, Indexes registered for and system access time.
     * @param username          Username of Student account.
     * @param password          Raw password (unhashed) of Student account.
     * @param name              Full name of Student (as in NRIC).
     * @param matricNum         Matriculation number of the Student.
     * @param gender            Student's gender (M or F).
     * @param nationality       Student's nationality.
     * @param yearOfStudy       Current year of study (1 to 5).
     * @param registeredIndex   ArrayList of Indexes that Student is registered for.
     * @param waitIndex         ArrayList of Indexes that Student is on waitlist for.
     * @param startAccessTime   Start time that Student can access the MySTARS system.
     * @param endAccessTime     End time after which the Student can no longer access the MySTARS system..
     */
    public Student(String username, String password, String name, 
    		String matricNum, char gender, String nationality, 
            int yearOfStudy, ArrayList<Index> registeredIndex, ArrayList<Index> waitIndex, 
            LocalDateTime startAccessTime, LocalDateTime endAccessTime) {
        super(username, password, "Student");
        this.name = name;
        this.matricNum = matricNum;
        this.gender = gender;
        this.nationality = nationality;
        this.yearOfStudy = yearOfStudy;
        this.registeredIndex = registeredIndex;
        this.waitIndex = waitIndex;
        this.startAccessTime = startAccessTime;
        this.endAccessTime = endAccessTime;
    }

    /**
     * Gets this Student's username.
     * @return this Student's username.
     */
    public String getUsername() {
        return super.getUsername();
    }

    /**
     * Gets this Student's password. Used for password checking.
     * @return this Student's password.
     */
    public String getPassword() {
        return super.getPassword();
    }

    /**
     * Gets this Student's account type. Should be "Student" by default,  and should not be changed.
     * @return this Student's account type.
     */
    public String getAccountType() {
        return super.getAccountType();
    }

    /**
     * Gets this Student's name. Should be full name as per official documents.
     * @return this Student's full name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets this Student's matriculation number.
     * @return this Student's matriculation number.
     */
    public String getMatricNum() {
        return this.matricNum;
    }

    /**
     * Gets this Student's gender.
     * @return this Student's gender.
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * Gets this Student's nationality.
     * @return this Student's nationality.
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Gets the Student's year of study for this semester.
     * @return this Student's year of study.
     */
    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    /**
     * Gets ArrayList of Indexes that this Student has registered for.
     * @return the ArrayList of Indexes that this Student has registered for.
     */
    public ArrayList<Index> getRegisteredIndex() {
        return this.registeredIndex;
    }
    
    /**
     * Sets ArrayList of Indexes that this Student has registered for.
     * @param index This Student's new ArrayList of registered Indexes.
     */
    public void setRegisteredIndex(ArrayList<Index> index) {
    	this.registeredIndex = index;
    }

    /**
     * Gets ArrayList of Indexes that this Student is on waitlist for.
     * @return the ArrayList of Indexes that this Student is on waitlist for.
     */
    public ArrayList<Index> getWaitIndex() {
        return this.waitIndex;
    }
    
    /**
     * Sets ArrayList of Indexes that this Student is on waitlist for.
     * @param index This Student's new ArrayList of waitlisted Indexes.
     */
    public void setWaitIndex(ArrayList<Index> index) {
    	this.waitIndex = index;
    }

    /**
     * Gets this Student's system access start time.
     * @return this Student's system access start time.
     */
    public LocalDateTime getStartAccessTime() {
        return this.startAccessTime;
    }

    /**
     * Sets this Student's system access start time.
     * @param startTime This Student's new system access start time.
     */
    public void setStartAccessTime(LocalDateTime startTime) {
        this.startAccessTime = startTime;
    }

    /**
     * Gets this Student's system access end time.
     * @return this Student's system access end time.
     */
    public LocalDateTime getEndAccessTime() {
        return this.endAccessTime;
    }

    /**
     * Sets this Student's system access end time.
     * @param endTime This Student's new system access end time.
     */
    public void setEndAccessTime(LocalDateTime endTime) {
        this.endAccessTime = endTime;
    }

    @Override
    public boolean equals (Object o) {  
        if (o instanceof Student){
            Student s = (Student) o;
            if (this.matricNum.equals(s.matricNum)) {
                return true;
            }
        }
        return false;
    }
}