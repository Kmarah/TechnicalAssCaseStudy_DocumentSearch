import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
	/**
	 * To get names of files in to search
	 * @author Kellie Marah
     * @return 
     */
    public static ArrayList<String> getFileNames() {
        ArrayList<String> files = new ArrayList<String>();
        
        //files.add("french_armed_forces.txt");
        //files.add("hitchhikers.txt");
        //files.add("warp_drive.txt");
        
        /** Please point to the appropriate folder of your search text files...  */
        
        files.add("C:\\sample_text\\french_armed_forces.txt");
        files.add("C:\\sample_text\\hitchhikers.txt");
        files.add("C:\\sample_text\\warp_drive.txt");
        return files;
    }
    
    /**
     * method to read file in arraylist
     * @param fileName
     * @return
     * @throws FileNotFoundException 
     */
    public static ArrayList<String> readFileToList(String fileName) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(fileName));
        ArrayList<String> wordsList = new ArrayList<String>();
         while(fileReader.hasNext()) {
             wordsList.add(fileReader.next());
         }
         
        fileReader.close();
        return wordsList;
    }
}
