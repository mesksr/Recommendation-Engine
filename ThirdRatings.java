
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import org.apache.commons.csv.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("data/ratings.csv");
    }
    public ThirdRatings(String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
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
        ArrayList <String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String movie : movies){
            double avgRating = getAverageByID(movie, mini);
            Rating temp = new Rating(movie, avgRating);
            r.add(temp);
        }
        return r;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int mini, Filter filterCriteria){
        
        ArrayList <Rating> r = new ArrayList <Rating>();
        ArrayList <String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String movie : movies){
            double avgRating = getAverageByID(movie, mini);
            Rating temp = new Rating(movie, avgRating);
            r.add(temp);
        }
        return r;
    }
}