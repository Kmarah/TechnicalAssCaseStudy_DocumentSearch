
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * 
 * @author Kellie Marah
 * Technical Case Study...
 * Main program
 * Performs case insensitive search and finds full words only
 */
public class MainUserInput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter the search term: ");
        Scanner input = new Scanner(System.in);
        String token = input.nextLine();
        System.out.println("Search Method: 1) String Match 2) Regular Expression 3) Indexed: ");
        int method = input.nextInt();

        HashMap<String, Integer> result = null;
        long time = System.currentTimeMillis();
        if (method == 1) {

            result = stringMatch(token);
        } else if (method == 2) {
            result = regExMatch(token);
        } else if (method == 3) {
            result = stringMatch(token);
        } else {
            System.out.println("Invalid choice!");
            System.exit(1);
        }
               
        /**
         * Display result
         */
        for (String file : result.keySet()) {
            System.out.println(file + " - " + result.get(file) + " matches ");
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Elapsed time: " + time + " ms");
    }
    
    /**
     * Three methods for searching the documents:
     * Simple string matching
     * @param token
     * @return
     * @throws FileNotFoundException
     */

   public static HashMap<String, Integer> stringMatch(String token) throws FileNotFoundException {
        Search search = new SimpleStringMatch();
        return search.search(token);
    }
    
    /**
     * Text search using regular expressions
     * @param token
     * @return
     * @throws FileNotFoundException
     */

    public static HashMap<String, Integer> regExMatch(String token) throws FileNotFoundException {
        Search search = new RegExSearch();
        return search.search(token);
    }
    
    /**
     * Preprocess the content and then search the index
     * @param token
     * @return
     * @throws FileNotFoundException
     */
  
    public static HashMap<String, Integer> preprocessMatch(String token) throws FileNotFoundException {
        Search search = new SearchIndex();
        return search.search(token);
    }
}
