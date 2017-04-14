public class DirectorFilter implements Filter {
    private String[] directors;
    
    public DirectorFilter(String g) {
        directors = g.split(",");
    }
    
    @Override
    public boolean satisfies(String id) {
        String[] movies = MovieDatabase.getDirector(id).split(", "); 
        for (String m : movies)
            for (String d: directors)
                if (m.equals(d))
                    return true;
        return false;
    }

}
