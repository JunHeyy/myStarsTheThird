public class NotifManager {
    /**
     * Sends email notification to Students.
     * @param to            Recipient's email address (should be Student's email).
     * @param courseCode    Course code of Course to be registered to Student
     * @param channel       Recipient's preferred channel of communication (email, SMS etc)
     */
    public static void sendNotif(String to, String courseCode, String channel) {
        if (channel.equals("email")) {
            MailManager.send(to, courseCode);
        }
    }

}
