import java.awt.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        new MyFrame();
        /*try {
            BufferedReader reader = new BufferedReader(new FileReader("MOVIES.txt"));
            Movie m=new Movie();
            Movie movie=new Movie(1,"Romance","Love Hurts","Sunday:10:00PM-12:00PM");
            Movie movie1=new Movie(2,"Action","MISSION IMPOSSIBLE","Friday:08:00PM-10:00PM-12:00PM");
            m.add(movie);
            m.add(movie1);
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    System.out.println(line);
                    String[] movieDetails = line.split("\\|");
                    if (movieDetails.length == 4) {
                        int id = Integer.parseInt(movieDetails[0].trim());
                        String genre = movieDetails[1].trim();
                        String name = movieDetails[2].trim();
                        String showTime = movieDetails[3].trim();
                        Movie movie2 = new Movie(id, genre, name, showTime);
                        System.out.println("Movie Added: " + movie2);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}