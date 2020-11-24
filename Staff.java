import java.io.Serializable;

/**
 * Concrete ebtity class representing Staff user account
 */
public class Staff extends User implements Serializable{
    
    private int staffId;
    private static final long serialVersionUID = 11;

    /**
     * Staff contructor for staff object.
     * @param username  Staff member's username
     * @param password  Staff member's raw password (unhashed)
     * @param staffId   Staff member's unique ID
     */

    public Staff(String username, String password, int staffId) {
        super(username, password, "Staff");
        this.staffId = staffId;
    }

    /**
     * Gets this Staff member's ID.
     * @return this Staff member's ID.
     */
    public int getStaffId() {
        return this.staffId;
    }
    
}
