
import java.io.FileNotFoundException;
 
import java.util.Random;

/**
 * 
 * @author Kellie Marah
 * Technical Case Study...
 * Performance test that does 2 Million searches with random search terms, and measures execution time.
 *
 */
public class MainPerfTest {
    public static void main(String[] args) throws FileNotFoundException {
        int numTests = 2000000;
        
        System.out.println("Running Indexed test...");
        String str = generateRandomString(3);
        System.out.println("Time taken: "+preprocessMatch(str,numTests)+" ms");
        System.out.println();
        
        System.out.println("Running String Match test...");
        str = generateRandomString(3);
        System.out.println("Time taken: "+stringMatch(str,numTests)+" ms");
        System.out.println();
        
        System.out.println("Running Regular Expresession test...");
        str = generateRandomString(3);
        System.out.println("Time taken: "+regExMatch(str,numTests)+" ms");
        System.out.println();
        
    }
    
     /**
     * Simple String matching...
     * @param token
     * @param numTests
     * @return
     * @throws FileNotFoundException
     */
    public static long stringMatch(String token, int numTests) throws FileNotFoundException {
        long time = System.currentTimeMillis();
        for(int i=0;i<numTests;i++) {
            Search search = new SimpleStringMatch();
              search.search(token);
        }
        return System.currentTimeMillis()-time;
    }

    /**
     * Text search using regular expressions...
     * @param token
     * @param numTests
     * @return
     * @throws FileNotFoundException
     */
    public static long regExMatch(String token, int numTests) throws FileNotFoundException {
       
        long time = System.currentTimeMillis();
        for(int i=0;i<numTests;i++) {
            Search search = new RegExSearch();
              search.search(token);
        }
        return System.currentTimeMillis()-time;
        
    }

    /**
     * Preprocess the content and then search the index
     * @param token
     * @param numTests
     * @return
     * @throws FileNotFoundException
     */
    public static long preprocessMatch(String token, int numTests) throws FileNotFoundException {
        long time = System.currentTimeMillis();
        for(int i=0;i<numTests;i++) {
            Search search = new SearchIndex();
              search.search(token);
        }
        return System.currentTimeMillis()-time;
    }
    
    /**
     * method to generate a random string of given length
     * @param len
     * @return 
     */
    public static String generateRandomString(int len) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomString = "";
        Random r = new Random();
        for(int i=0;i<len;i++) {
            randomString += s.charAt(r.nextInt(s.length()));
        }
        return randomString;
    }
}
