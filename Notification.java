public interface Notification {
    /**
     * Sends email notification to Students.
     * @param to            Recipient's email address/phone number/Telegram username (depending on channel).
     * @param courseCode    Course code of Course to be registered to Student
     */
    public static void send(String to, String courseCode) {};
}
