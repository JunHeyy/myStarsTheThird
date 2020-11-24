import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Concrete entity class representing each Index belonging to a Course.
 */
public class Index implements Serializable{

    private Integer indexNum;
    private String courseCode;
    private int maxSize;
    private int numStudents;
    private ArrayList<Lesson> lessons;
    private LinkedList<Student> waitlist;

    public Index(Integer indexNum, String courseCode, int maxSize, int numStudents, ArrayList<Lesson> lessons) {
        this.indexNum = indexNum;
        this.courseCode = courseCode;
        this.maxSize = maxSize;
        this.numStudents = numStudents;
        this.lessons = lessons;
        this.waitlist = new LinkedList<Student>();
    }

    /**
     * Creates an Index with a unique index number belonging to the Course with a matching course code.
     * @param indexNum      The unique index number of this Index.
     * @param courseCode    Should match the course code of the Course that it belongs to.
     * @param maxSize       Maximum number of students allowed to be enrolled in this Index.
     * @param numStudents   Number of students currently registered to this Index.
     * @param lessons       ArrayList of Lessons (e.g. lecture, tutorial, lab) under this Index.
     * @param waitlist      LinkedList (acting as a queue) of Students in the waitlist for this Index. Should be empty if numStudents < maxSize.
     */
    public Index(Integer indexNum, String courseCode, int maxSize, ArrayList<Lesson> lessons) {
        this.indexNum = indexNum;
        this.courseCode = courseCode;
        this.maxSize = maxSize;
        this.numStudents = 0;
        this.lessons = lessons;
        this.waitlist = new LinkedList<Student>();
    }

    /**
     * Gets the index number of this Index.
     * @return this Index's index number.
     */
    public Integer getIndexNum() {
        return this.indexNum;
    }

    /**
     * Sets the index number of this Index.
     * @param indexNum This Index's new index number.
     */
    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }

    /**
     * Gets the course code of the Course that this index belongs to.
     * @return this course code of the Course it belongs to.
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Sets the course code of the Course that this Index belongs to. Should be changed only if the Course's course code changes.
     * @param courseCode This Course's new course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the maximum capacity for this Index.
     * @return the maximum number of students that can enrol in this Index..
     */
    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Sets the maximum capacity of this Index.
     * @param maxSize This Index's new maximum capacity.
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Gets the number of students currently registered to this Index.
     * @return the number of students registered to this Index..
     */
    public int getNumStudents() {
        return this.numStudents;
    }

    /**
     * Sets the course code of this Course. Called in CourseManager class when Students register for or drop Index.
     * @param numStudents This Course's new number of students..
     */
    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    /**
     * Gets the ArrayList of Lessons under this Index.
     * @return the ArrayList of Lessons under this Index..
     */
    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    /**
     * Sets the ArrayList of Lessons belonging to this Course.
     * @param lessons This Course's new ArrayList of Lessons..
     */
    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    /**
     * Gets the waitlist for this Index.
     * @return the waitlist for this Index.
     */
    public LinkedList<Student> getWaitlist() {
        return this.waitlist;
    }

    /**
     * Sets the waitlist of this Course.
     * @param courseCode This Course's new waitlist..
     */
    public void setWaitlist(LinkedList<Student> waitlist) {
        this.waitlist = waitlist;
    }

    @Override
    public boolean equals (Object o) {  
        if (o instanceof Index){
            Index i = (Index) o;
            if (this.indexNum.equals(i.indexNum) || this.courseCode.equals(i.courseCode)) {
                return true;
            }
        }
        return false;
    }

}