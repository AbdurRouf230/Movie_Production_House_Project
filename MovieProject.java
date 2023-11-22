
package loginproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author abdur
 */
public class MovieProject implements Serializable{
    String movieName;
    ArrayList<User> crewList;

    public MovieProject(String movieName, ArrayList<User> crewList) {
        this.movieName = movieName;
        this.crewList = crewList;
    }

    public String getMovieName() {
        return movieName;
    }

    public ArrayList<User> getCrewList() {
        return crewList;
    }
    
    
}
