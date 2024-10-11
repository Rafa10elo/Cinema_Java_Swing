import java.util.List;

public class Cinema {
    private int num;
    private List<String> movies;
    Cinema(int num,List<String> movies)
    {
        this.num=num;
        this.movies=movies;
    }
    public int getNumber() {
        return num;
    }

    public List<String>  getMovies() {
        return movies;
    }
}
