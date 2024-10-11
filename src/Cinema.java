
import java.util.List;

public class Cinema {
    final private int num;
    final private List<String> movies;

    Cinema(int num, List<String> movies) {
        this.num = num;
        this.movies = movies;
    }

    public int getNumber() {
        return num;
    }

    public List<String> getMovies() {
        return movies;
    }
}

