import java.io.Serializable;
import java.util.ArrayList;

/**
 * Concrete entity class representing each Course available.
 */
public class Course implements Serializable  {

    private String courseCode;
    private String courseName;
    private String school;
    private int numAUs;
    private ArrayList<Index> indexList;

    /**
     * Creates a Course with its course code, name, host school, number of AUs and list of indexes under this Course.
     * @param courseCode    This Course's unique course code.
     * @param courseName    This Course's course name.
     * @param school        This Course's host school name.
     * @param numAUs        The number of AUs for this Course. Used to determine if student has enough AUs to register for the Course.
     * @param indexList     ArrayList of the Indexes in this Course. Each Course can have multiple Indexes.
     */
    public Course(String courseCode, String courseName, String school, int numAUs, ArrayList<Index> indexList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.school = school;
        this.numAUs = numAUs;
        this.indexList = indexList;
    }

    /**
     * Gets the course code of this Course.
     * @return this Course's course code.
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Sets the course code of this Course.
     * @param courseCode This Course's new course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

        /**
     * Gets the name of this Course.
     * @return this Course's name
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Sets the name of this Course
     * @param courseName This Course's new name.
     */    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the name of the host school of this Course.
     * @return the name of this Course's host school.
     */
    public String getSchool() {
        return this.school;
    }

    /**
     * Sets the new name of the host school of this Course.
     * @param school the new name of this Course's host school.
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Gets the number of AUs for this Course
     * @return this Course's number of AUs.
     */
    public int getNumAUs() {
        return this.numAUs;
    }

    /**
     * Sets the new number of AUs for this course.
     * @param numAUs this Course's new numebr of AUs.
     */
    public void setNumAUs(int numAUs) {
        this.numAUs = numAUs;
    }

    /**
     * Get ArrayList of indexes under this Course
     * @return ArrayList of indexes under this Course
     */
    public ArrayList<Index> getIndexList() {
        return this.indexList;
    }

    /**
     * Set ArrayList of indexes under this Course
     * @param indexList new ArrayList of indexes belonging to this Course
     */
    public void setIndexList(ArrayList<Index> indexList) {
        this.indexList = indexList;
    }
    
    @Override
    public boolean equals (Object o) {  
        if (o instanceof Course){
            Course c = (Course) o;
            if (this.courseCode.equals(c.courseCode)) {
                return true;
            }
        }
        return false;
    }

}
