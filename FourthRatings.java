
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import org.apache.commons.csv.*;

public class FourthRatings {
    private ArrayList<Rater> myRaters;
    
    public FourthRatings() {
        // default constructor
        this("data/ratings.csv");
    }
    
    public FourthRatings(String ratingsfile){
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
    
    public double dotProduct(Rater me, Rater r){
        double dp = 0;
        for (String m : me.getItemsRated()){
            if (r.hasRating(m)){
                dp += (r.getRating(m)-5.0)*(me.getRating(m)-5.0);
            }
        }
        return dp;
    }
    
    public ArrayList <Rating> getSimilarities(String id){
        ArrayList <Rating> ret = new  ArrayList <Rating>();
        Rater me = RaterDatabase.getRater(id);
        for (Rater r : RaterDatabase.getRaters()){
            if (id.equals(r.getID()))
                continue;
            else{
                double dp = dotProduct(me,r);
                ret.add(new Rating(r.getID(), dp));
            }
        }
        Collections.sort(ret, Collections.reverseOrder());  
        for (int k = 0; k<100; k++){
                Rating x = ret.get(k);
            }
        return ret;
    }
    
    public ArrayList<Rating> getSimilarRatings (String id, int numSimilarRaters, int minimalRaters){
        ArrayList <Rating> sim = getSimilarities(id);
        ArrayList <Rating> ret = new  ArrayList <Rating>();
        System.out.println("Start");
        int count = 0;
        double sum = 0;
        for (String m :  MovieDatabase.filterBy(new TrueFilter())){
            count = 0;
            sum = 0;
            for (int k = 0; k<numSimilarRaters; k++){
                Rating x = sim.get(k); //rater id and weighted avg
                if ( x.getValue()<=0)
                    break;
                String i = x.getItem(); //rater id
                Rater r = RaterDatabase.getRater(i); //rater id and double
                if (r.getRating(m) != -1){
                    sum += r.getRating(m)*(x.getValue());
                    count++;
                }
            }
            double dp = sum / count;
            Rating newR = new Rating(m, dp);
            if (count>=minimalRaters){
                ret.add(newR);
            }
        }
        Collections.sort(ret);
        return ret;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter (String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
        ArrayList <Rating> sim = getSimilarities(id);
        ArrayList <Rating> ret = new  ArrayList <Rating>();
        System.out.println("Start");
        int count = 0;
        double sum = 0;
        for (String m : MovieDatabase.filterBy(filterCriteria)){
            count = 0;
            sum = 0;
            for (int k = 0; k<numSimilarRaters; k++){
                Rating x = sim.get(k); //rater id and weighted avg
                if ( x.getValue()<=0)
                    break;
                String i = x.getItem(); //rater id
                Rater r = RaterDatabase.getRater(i); //rater id and double
                if (r.getRating(m) != -1){
                    sum += r.getRating(m)*(x.getValue());
                    count++;
                }
            }
            double dp = sum / count;
            Rating newR = new Rating(m, dp);
            if (count>=minimalRaters){
                ret.add(newR);
            }
        }
        Collections.sort(ret);
        return ret;
    }
    
}
