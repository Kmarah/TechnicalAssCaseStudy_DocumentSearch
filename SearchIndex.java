
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * class for preprocessing the files and put data in map for faster search
 * @author Kellie Marah
 *
 */
public class SearchIndex implements Search{

    
	/**
	 * map to store file names as keys and words/count as values
	 */
    static HashMap<String,HashMap<String, Integer>> fileToWordsCountMap 
            = new HashMap<String,HashMap<String, Integer>>();
    public SearchIndex() throws FileNotFoundException {
        preprocess();
    }
    
    /**
     * preprocess files
     */
    private static void preprocess() throws FileNotFoundException {
        if(fileToWordsCountMap.size()>0) {
            return; /** already processed */
        }
        
        ArrayList<String> fileList = Utility.getFileNames();
        
        /**
         * loop over files
         */
        for(String file: fileList) {
            HashMap <String, Integer> wordsCount
            = new  HashMap<String, Integer>();
            /** get all words in current file */
           ArrayList<String> wordsList = Utility.readFileToList(file);
           /** loop over words in current file */
           for(String word:wordsList) {
               word = word.toLowerCase();
               /** if word is not in map */
               if(wordsCount.get(word)==null) {
                   /** put it */
                   wordsCount.put(word,1);
               }else {
                   /** else increment the count */
                    wordsCount.put(word,wordsCount.get(word)+1);
               }
                
           }
           
           /** put in main map */
           fileToWordsCountMap.put(file,wordsCount);
        }
    }
    
    /**
     * method to search a given token in files
     * @param token
     * @return map with file name and count of the token in each of the files
     */
    @Override
    public HashMap <String, Integer> search(String token) throws FileNotFoundException {
        preprocess();
        token= token.toLowerCase();
        HashMap <String, Integer> result
            = new  HashMap<String, Integer>();
        /** loop over already processed contents */
        for(String file: fileToWordsCountMap.keySet()) {
            HashMap <String, Integer> wordsCount = fileToWordsCountMap.get(file);
            if(wordsCount.size() >0) {
                /** if found */
                if(wordsCount.get(token)!=null) {
                    result.put(file, wordsCount.get(token));
                }else {
                    result.put(file, wordsCount.get(0));
                }
            }
        }
        return result;
    }
     
}
