import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Movie {
    private int id;
    private  String genre;
    private  String name;
    private String ShowTimes;
    private String posterPath;
    private String description;
    Movie(){}
    Movie(int id, String genre,String name,String ShowTimes,String posterPath,String description)
    {
        this.id=id;
        this.genre=genre;
        this.name=name;
        this.ShowTimes=ShowTimes;
        this.posterPath = posterPath;
        this.description=description;
    }
    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String getShowTimes() {
        return ShowTimes;
    }

    public String getPosterPath() {
        return posterPath;
    }
    public String getDescription(){
        return description;
    }
    void add(Movie movie){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MOVIES.txt", true));
            writer.write(movie.id + "|" + movie.genre + "|" + movie.name + "|" + movie.ShowTimes + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public String toString() {
        return "ID: " + id + ", Genre: " + genre + ", Name: " + name + ", Show Time: " + ShowTimes;
    }
}
