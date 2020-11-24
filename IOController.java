import java.io.*;
import java.util.ArrayList;

/**
 * Controller class to handle all general IO operations. Used by manager classes to access and modify databases.
 */
public class IOController <T> {

    /**
     * Function to write an ArrayList to its file (database).
     * @param filename      Relative path to the file to write to (or filename if file is in current directory).
     * @param list          ArrayList of Objects (does not depend on Object type) to be written back to the database file.
     * @throws IOException  if file does not exist.
     */
    public static <T> void writeFile(String filename, ArrayList<T> list) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(list);
    }

    /**
     * Function to read file with the array list.
     * @param filename Relative path to the file to read from (or filename if file is in current directory).
     * @return ArrayList of (serializable) Objects stored in the database.
     * @throws IOException              if file does not exist.
     * @throws ClassNotFoundException   when mentioned classes are not found in the classpath.
     */
    public static <T> ArrayList<T> readFile(String filename) throws IOException, ClassNotFoundException {
        ArrayList<T> list = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            list = (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            list = new ArrayList<T>();
        }
        return list;
    }

}
