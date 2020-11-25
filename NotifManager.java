public class NotifManager {

    public static void sendNotif(String to, String courseCode, String channel) {
        if (channel.equals("email")) {
            MailManager.send(to, courseCode);
        }
    }

}
