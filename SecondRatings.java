
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import org.apache.commons.csv.*;

public class SecondRatings {
    private ArrayList<CSVRecord> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }
    public SecondRatings(String moviefile,String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);
    }
    public int getMovieSize(){
        return myMovies.size();
    }
    public int getRaterSize(){
        return myRaters.size();
    }
    public double getAverageByID(String movieID, int mini){
        int count = 0;
        double rating = 0;
        for (Rater x : myRaters){
            if (x.hasRating(movieID)){
                count ++;
                rating += x.getRating(movieID);
            }
        }
        if (count>=mini)
            return rating/count;
        else
            return 0.0;
    }
    public ArrayList<Rating> getAverageRatings(int mini){
        ArrayList <Rating> r = new ArrayList <Rating>();
        for (CSVRecord name : myMovies){
            String movie = name.get("id");
            double avgRating = getAverageByID(movie, mini);
            Rating temp = new Rating(name.get("title"), avgRating);
            r.add(temp);
        }
        return r;
    }
    public String getTitle(String id)
    {
        String ans="NO SUCH TITLE.";
        for (CSVRecord name : myMovies){
            String movie = name.get("id");
            if (movie.equals(id)){
                ans =  name.get("title");
            }
        }
        return ans;
    }
    public String getID(String title)
    {
        String ans="NO SUCH TITLE.";
        for (CSVRecord name : myMovies){
            String movie = name.get("title");
            if (movie.equals(title)){
                ans =  name.get("id");
            }
        }
        return ans;
    }
}