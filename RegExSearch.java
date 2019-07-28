import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text search using reg ex
 * @author Kellie Marah
 *
 */
public class RegExSearch implements Search{
    /**
     * method to search a given token in files
     * @param token
     * @return map with file name and count of the token in each of the files
     * @throws java.io.FileNotFoundException
     */
    public HashMap <String, Integer> search(String token) throws FileNotFoundException {
        token= token.toLowerCase();
        HashMap <String, Integer> result
            = new  HashMap<String, Integer>();
        
        Pattern p = Pattern.compile(token);   // the pattern to search for
        Matcher m ;
        
        /**
         * Loop over files
         */
        for(String file: Utility.getFileNames()) {
            int count = 0;
            
            /**
             * get words and loop
             */
            for(String word: Utility.readFileToList(file)) {
                m = p.matcher(word.toLowerCase()); //if found
                if(m.matches()) {
                    count++;
                }
            }
            
            /**
             * put in map
             */
            result.put(file, count);
        }
        return result;
    }
}
