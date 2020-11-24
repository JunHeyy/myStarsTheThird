import java.io.Serializable;
import java.util.ArrayList;

/**
 * Concrete entity class representing each Lesson belonging to an Index.
 * Lessons refer to lectures, tutorials or labs.
 */
public class Lesson implements Serializable {

    private String type;
    private String venue;
    private String groupId; 
    private ArrayList<Timeslot> timeslots;  

    /**
     * Creates a Lesson that belongs to an Index. Stored in an Index's ArrayList of lessons.
     * @param type      Lesson type (one of "Lec", "Tut" or "Lab" only).
     * @param venue     Lesson venue.
     * @param groupId   Lesson group ID (e.g. SSP1).
     * @param timeslots ArrayList of timeslots for this lesson (e.g. lectures may be held twice a week, so 2 timeslots are needed).
     */
    public Lesson(String type, String venue, String groupId, ArrayList<Timeslot> timeslots) {
        this.type = type;
        this.venue = venue;
        this.groupId = groupId;
        this.timeslots = timeslots;
    }

    /**
     * Gets this Lesson type.
     * @return this Lesson's type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets this Lesson's type. 
     * @param type This Lesson's new type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets this Lesson's venue.
     * @return this Course's course code.
     */
    public String getVenue() {
        return this.venue;
    }

    /**
     * Sets the venue of this Lesson.
     * @param venue This Lesson's new venue.
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Gets this Lesson's group ID.
     * @return this Lesson's group ID.
     */
    public String getGroupId() {
        return this.groupId;
    }

    /**
     * Sets the group ID of this Course.
     * @param groupId This Course's new group ID.
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets the ArrayList of Timeslots for this Lesson.
     * @return the ArrayList of Timeslots for this Lesson.
     */
    public ArrayList<Timeslot> getTimeslots() {
        return this.timeslots;
    }

}