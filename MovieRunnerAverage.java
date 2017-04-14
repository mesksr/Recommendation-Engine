
import java.util.*;
public class MovieRunnerAverage {
    public void  printAverageRatings(){
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        System.out.println("Movies = "+sr.getMovieSize());
        System.out.println("Raters = "+sr.getRaterSize());
        int n = 12;
        ArrayList<Rating> r = sr.getAverageRatings(n);
        Collections.sort(r);
        System.out.println("more than "+n+":");
        for (Rating x : r){
            if (x.getValue()!=0.0)
                System.out.println(x);
        }
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(x);
                break;
            }
        }
    }
    public void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        String name = "Vacation";
        String id = sr.getID(name);
        ArrayList<Rating> r = sr.getAverageRatings(3);
        for (Rating x : r){
            if (x.getItem().equals(name))
                System.out.println(name + " " +x);
        }
    }
}
