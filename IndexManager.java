import java.util.ArrayList;
import java.io.*;

public class IndexManager {
	private static String filename = "data/Index.dat";
	
    public static void addIndex(Index newIndex) throws IOException, ClassNotFoundException {
        try {
        ArrayList<Index> indexList = IOController.readFile(filename);
        int found =0;
        for(Index index : indexList) {
        	if(index.getIndexNum() == newIndex.getIndexNum()) {
        		System.out.println("The index is already in the database");
        		found=1;
        		break;
        	}
        }
        if(found==0) {
	        indexList.add(newIndex);
	        System.out.println("Succesfully added student into the database");
	        IOController.writeFile(filename, indexList);
        	}
        }catch(FileNotFoundException exception){System.out.println("File not found");}
        
	  }

    public static void removeIndex(int index) throws IOException, ClassNotFoundException {
    	try {
	        Index toRemove = null;
	        ArrayList<Index> indexList = extractDB();
	        for (Index i: indexList) {
	            if (i.getIndexNum() == index) {
	                toRemove = i;
	                break;
	            }
	        }
	        if (toRemove != null) {
	        	System.out.println("Removing index...");
	        	indexList.remove(toRemove);
	        	System.out.println("Success");
	        	IOController.writeFile(filename, indexList);
	        }
	        else {
	        	System.out.println("There is no such index in the database");
	        }
    	}catch(FileNotFoundException exception){System.out.println("File not found");}
	        
        
    }
    

    
    
    public static ArrayList<Index> extractDB() throws IOException, ClassNotFoundException {
    	try {
	        ArrayList<Index> indexList = IOController.readFile(filename);
	        return indexList;
		}
		catch(FileNotFoundException exception) {
			System.out.println("File not found");	
			return null;
		}
    }
    
    public static void UpdateCourseDB(ArrayList<Index> indexList) {
    	try {
			IOController.writeFile(filename, indexList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}
