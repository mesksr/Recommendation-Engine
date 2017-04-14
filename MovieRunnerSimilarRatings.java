
import java.util.*;
public class MovieRunnerSimilarRatings {
    public void  printAverageRatings(){
        FourthRatings tr = new FourthRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 35;
        ArrayList<Rating> r = tr.getAverageRatings(n);
        Collections.sort(r);
        System.out.println("more than "+n+":");
        int count = 0;
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+x);
                count++;
            }
        }
        System.out.print(count);
    }
    public void printSimilarRatings(){
        FourthRatings fr = new FourthRatings ();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> r = fr.getSimilarRatings ("337", 10, 3);
        for (Rating x : r){
                System.out.println(MovieDatabase.getTitle(x.getItem())+" " +x.getValue());
            }
    }
    public void printSimilarRatingsByGenre(){
        String g ="Mystery";
        GenreFilter f = new  GenreFilter(g);
        FourthRatings fr = new FourthRatings ();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> r = fr.getSimilarRatingsByFilter ("964", 20, 5, f);
        for (Rating x : r){
                System.out.println(MovieDatabase.getTitle(x.getItem())+" " +x.getValue());
            }
    }
    public void printSimilarRatingsByDirector(){
        String g ="Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        DirectorFilter f = new  DirectorFilter(g);
        FourthRatings fr = new FourthRatings ();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> r = fr.getSimilarRatingsByFilter ("120", 10, 2, f);
        for (Rating x : r){
                System.out.println(MovieDatabase.getTitle(x.getItem())+" " +x.getValue());
            }
    }
    public void printSimilarRatingsByGenreAndMinutes(){
        AllFilters f = new  AllFilters();
        
        int min =160;
        MinuteFilter f1 = new  MinuteFilter(min);
        f.addFilter(f1);
        
        int m =80;
        MinMinuteFilter f0 = new  MinMinuteFilter(m);
        f.addFilter(f0);
        
       
        String g ="Drama";
        GenreFilter f2 = new  GenreFilter(g);
        f.addFilter(f2);
        
        FourthRatings fr = new FourthRatings ();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> r = fr.getSimilarRatingsByFilter ("168", 10, 3, f);
        for (Rating x : r){
                System.out.println(MovieDatabase.getTitle(x.getItem())+" " +x.getValue());
            }
    }
    public void printSimilarRatingsByYearAfterAndMinutes (){
        AllFilters f = new  AllFilters();
        
        int min =200;
        MinuteFilter f1 = new  MinuteFilter(min);
        f.addFilter(f1);
        
        int m =70;
        MinMinuteFilter f0 = new  MinMinuteFilter(m);
        f.addFilter(f0);
        
       
        int year =1975;
        YearAfterFilter f2 = new  YearAfterFilter(year);
        f.addFilter(f2);
        
        FourthRatings fr = new FourthRatings ();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> r = fr.getSimilarRatingsByFilter ("314", 10, 5, f);
        for (Rating x : r){
                System.out.println(MovieDatabase.getTitle(x.getItem())+" " +x.getValue());
            }
    }
}
