import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    public ArrayList loadMovies (String fileName){
        ArrayList<CSVRecord> res = new ArrayList<CSVRecord>();
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record :parser){
            res.add(record);
        }
        return res;
    }
    
    public void testLoadMovies (){
        ArrayList<CSVRecord> res = loadMovies("data/ratedmoviesfull.csv");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int comedy = 0;
        int longMovie = 0;
        int mostDir = 0;
        for (CSVRecord record :res){
            System.out.println(record.get("genre"));
            if (record.get("genre").contains("Comedy"))
                comedy ++;
            if (Integer.parseInt(record.get("minutes"))>150)
                longMovie ++;
            String[] s = record.get("director").split(",");
            for (String name : s){
                if (map.keySet().contains(name))
                    map.put(name, map.get(name)+1);
                else
                    map.put(name, 1);
            }
            for (String name: map.keySet()){
                if (mostDir<map.get(name))
                    mostDir = map.get(name);
            }                
        }
        System.out.println("len = "+res.size());
        System.out.println("comedy = "+comedy);
        System.out.println("longMovie = "+longMovie);
        System.out.println("mostDir = "+mostDir);
        for (String name: map.keySet()){
                if (mostDir == map.get(name))
                    System.out.println(name);
            }     
    }
    
    public ArrayList loadRaters (String fileName){
        ArrayList<Rater> res = new ArrayList<Rater>();
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record :parser){
            String name = record.get("rater_id");
            int flag = 1;
            for (Rater r :res){
                if (name.equals(r.getID())){
                    flag = 0;
                    r.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                }
            }
            if (flag == 1){
                Rater x = new  EfficientRater(name);
                x.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                res.add(x);
            }
        }
        return res;
    }
    
    public void testLoadRaters(){
        ArrayList<Rater> res = loadRaters("data/ratings.csv");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String getRatingsFor= "193";
        int count = 0;
        int mostRated = 0;
        int mostRatedMovie = 0;
        for (Rater x : res){
            if(x.getID().equals(getRatingsFor))
                count = x.numRatings();
            
            if (mostRated<x.numRatings())
                mostRated = x.numRatings();
            
            ArrayList<String> movies = x.getItemsRated()    ;
            for (String name : movies){
                if (map.keySet().contains(name))
                    map.put(name, map.get(name)+1);
                else
                    map.put(name, 1);  
            }
        }
        for (String name: map.keySet()){
            if (mostRatedMovie<map.get(name))
                mostRatedMovie = map.get(name);
        }             
        System.out.println("len = "+res.size());
        System.out.println(getRatingsFor+" rated "+count);
        System.out.println("mostRated =  "+mostRated+"by");
        for (Rater x : res){
            if (mostRated == x.numRatings())
                System.out.println("\t"+x.getID());
        }
        System.out.println("mostRatedMovie =  "+mostRatedMovie);
        for (String name: map.keySet()){
                if (mostRatedMovie == map.get(name))
                    System.out.println("\t"+name);
            }     
        String id = "1798709";
        System.out.println(id + " = "+map.get(id));
        System.out.println("movies number = "+map.keySet().size());
    }

}