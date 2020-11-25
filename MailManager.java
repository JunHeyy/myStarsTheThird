import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Controller class that handles all functions related to sending norifications.
 */
public class MailManager implements Notification {
    //private static String USER_NAME = "kenja1523";  // GMail user name (just the part before "@gmail.com")
    //private static String PASSWORD = "aa11bb22cc33"; // GMail password
    //private static String RECIPIENT = "junjiexavier37@gmail.com";

   /* public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Your course has been succesfully registered \n Congratulations!";
        sendFromGMail(from, pass, to, subject, body);
    }*/

    /**
     * Sends email notification to Students.
     * @param to            Recipient's email address (should be Student's email).
     * @param courseCode    Course code of Course to be registered to Student
     */
    public static void send (String to, String courseCode) {
        String from = "ntuchinesetiger@gmail.com";
        String pass = "@Testing123";
        String subject = "MySTARS Notification";
        String body = "Congratulations! You are off the waitlist and have been registered for course " + courseCode + ".";
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            //InternetAddress[] toAddress = new InternetAddress[to.length];
            InternetAddress toAddress = new InternetAddress(to);

            // To get the array of addresses
            //for( int i = 0; i < to.length; i++ ) {
            //    toAddress[i] = new InternetAddress(to[i]);
            //}

            //for( int i = 0; i < toAddress.length; i++) {
            //    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            //}
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}