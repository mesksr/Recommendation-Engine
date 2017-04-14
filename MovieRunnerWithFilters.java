
import java.util.*;
public class MovieRunnerWithFilters {
    public void  printAverageRatings(){
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
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
    public void  printAverageRatingsByYear ()
    {
        int year =2000;
        YearAfterFilter f = new  YearAfterFilter(year);
         
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 20;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and after year "+year+" :");
        int count = 0;         
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getYear(x.getItem())+" "+x);
                count++;
            }
        }
         System.out.print(count);
    }
    public void  printAverageRatingsByMinute ()
    {
        AllFilters f = new  AllFilters();
        
        int min =135;
        MinuteFilter f1 = new  MinuteFilter(min);
        f.addFilter(f1);
        
        int m =105;
        MinMinuteFilter f0 = new  MinMinuteFilter(m);
        f.addFilter(f0);
         
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 5;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and time "+m+" to "+min+" :");
        int count = 0;         
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getMinutes(x.getItem())+" "+x);
                count++;
            }
        }
        
                 System.out.print(count);
    }
    public void  printAverageRatingsByGenre ()
    {
        String g ="Comedy";
        GenreFilter f = new  GenreFilter(g);
         
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 20;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and genre "+ g+" :");
        int count = 0;         
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getYear(x.getItem())+" "+x);
                count++;}
        }
        
                 System.out.print(count);
    }
    public void  printAverageRatingsByDirector ()
    {
        String g ="Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
        DirectorFilter f = new  DirectorFilter(g);
         
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 4;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and Director "+ g +" :");
        int count = 0;         
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getDirector(x.getItem())+" "+x);
                count++;}
        }
        
                 System.out.print(count);
    }
     public void  printAverageRatingsByYearAfterAndGenre ()
    {
        AllFilters f = new  AllFilters();
        
        int year =1990;
        YearAfterFilter f1 = new  YearAfterFilter(year);
        f.addFilter(f1);
        
        String g ="Drama";
        GenreFilter f2 = new  GenreFilter(g);
        f.addFilter(f2);
        
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 8;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and Year "+ year +" "+ g + " :");
        int count = 0;         
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getYear(x.getItem())+" "+md.getGenres(x.getItem())+" "+x);
                count++;
            }
        }
                 System.out.print(count);
    }
     public void  printAverageRatingsByDirectorsAndMinutes ()
    {
        AllFilters f = new  AllFilters();
        
        int min =180;
        MinuteFilter f1 = new  MinuteFilter(min);
        f.addFilter(f1);
        
        int m =90;
        MinMinuteFilter f0 = new  MinMinuteFilter(m);
        f.addFilter(f0);
        
       
        String g ="Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
        DirectorFilter f2 = new  DirectorFilter(g);
        f.addFilter(f2);
        
        ThirdRatings tr = new ThirdRatings("data/ratings.csv");
        System.out.println("Raters = "+tr.getRaterSize());
        MovieDatabase md = new MovieDatabase();
        md.initialize("ratedmoviesfull.csv");
        System.out.println("Movies = "+md.size());
        
        int n = 3;
        ArrayList<Rating> r = tr.getAverageRatingsByFilter(n,f);
        Collections.sort(r);
        System.out.println("more than "+n+" and Time "+ m + " to "+min +" by "+ g + " :");
        int count = 0;        
        for (Rating x : r){
            if (x.getValue()!=0.0){
                System.out.println(md.getTitle(x.getItem())+" "+md.getYear(x.getItem())+" "+md.getGenres(x.getItem())+" "+x);
                count++;}
        }
        System.out.print(count);
    }
}
