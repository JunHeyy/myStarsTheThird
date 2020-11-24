import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Control class that handles password hashing using MD5Hash
 * */
public class Hashing {

    /**
     * Hash the input password using MD5Hash
     * @param password The raw password to be hashed
     * @return the hashed version of the password
     */
    public static String hashPassword(String password) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    // public static void main(String[] args) {
    //     // TO DELETE THIS PORTION
    //     String pw = "testPassword";
    //     String hashPw = hashPassword(pw);
    //     System.out.println("Password before hashing is: " + pw);
    //     System.out.println("Password after hashing is: " + hashPw);
    // }



}