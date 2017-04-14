public class GenreFilter implements Filter {
    private String G;
    
    public GenreFilter(String g) {
        G = g;
    }
    
    @Override
    public boolean satisfies(String id) {
        String[] movies = MovieDatabase.getGenres(id).split(", "); 
        for (String m : movies)
            if (m.equals(G))
                return true;
        return false;
    }

}
