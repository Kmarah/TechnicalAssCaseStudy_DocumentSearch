

import java.io.FileNotFoundException;
import java.util.HashMap;
 

/**
 * simple string match
 * @author Kellie Marah
 *
 */
public class SimpleStringMatch implements Search{
    /**
     * method to search a given token in files
     * @param token
     * @return map with file name and count of the token in each of the files
     * @throws java.io.FileNotFoundException
     */
    @Override
    public HashMap <String, Integer> search(String token) throws FileNotFoundException {
         
        HashMap <String, Integer> result
            = new  HashMap<String, Integer>();
        /**loop over files */
        for(String file: Utility.getFileNames()) {
            int count = 0;
            /** get words and loop */
            for(String word: Utility.readFileToList(file)) {
                if(word.equalsIgnoreCase(token)) {
                    count++;
                }
            }
            /** put in map */
            result.put(file, count);
        }
        return result;
    }
}
