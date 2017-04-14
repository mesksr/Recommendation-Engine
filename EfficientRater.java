
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class EfficientRater implements Rater {
    private String myID;
    private  HashMap<String,Rating> myRating;

    public EfficientRater(String id) {
        myID = id;
        myRating = new HashMap<String, Rating>();
    }

    public void addRating(String item, double rating) {
        Rating x = new Rating(item,rating);
        myRating.put(item, x);
    }

    public boolean hasRating(String item) {
        if (myRating.keySet().contains(item))
            return true;
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        if (myRating.keySet().contains(item))
            return  myRating.get(item).getValue();
        return -1;
    }

    public int numRatings() {
        return myRating.keySet().size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(String movie : myRating.keySet()){
            list.add(myRating.get(movie).getItem());
        }
        
        return list;
    }
}

