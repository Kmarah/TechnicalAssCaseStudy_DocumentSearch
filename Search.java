
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Interface for search
 * @author Kellie Marah
 *
 */
public interface Search {
    public HashMap <String, Integer> search(String token) throws FileNotFoundException ;
}
