import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MyFrame extends JFrame {
    private JPanel moviePanelContainer;
    private JPanel mainPanel;
    //private Map<Integer, List<Movie>> cinemaHallMovies = new HashMap<>();
    public MyFrame() {
        setTitle("Movies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setBackground(Color.BLACK);
       // JPanel mainPanel = new JPanel(new BorderLayout());
       // JPanel hallSelectionPanel = createHallSelectionPanel();
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(moviePanel);
        //mainPanel.add(hallSelectionPanel, BorderLayout.NORTH);
       // mainPanel.add(scrollPane, BorderLayout.CENTER);
        List<Movie>movies=readMoviesFromFile("MOVIES.txt");
        for (Movie movie : movies) {
            JPanel MovieMenu = createMoviePanel(movie);
            moviePanel.add(MovieMenu);
        }

        add(scrollPane);
    }
    private List<Cinema> readHalls(String filePath){
        List<Cinema> halls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=reader.readLine())!=null)
            {
                String[] HallsDetails = line.split("\\|");
                if (HallsDetails.length==2) {
                    int num=Integer.parseInt(HallsDetails[0].trim());
                    String available_movies=HallsDetails[1].trim();
                    halls.add(new Cinema(num,available_movies));
                }
            }
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
        return halls;
    }
    private List<Movie> readMoviesFromFile(String filePath) {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=reader.readLine())!=null)
            {
                String[] movieDetails = line.split("\\|");
                if (movieDetails.length==5) {
                    int id=Integer.parseInt(movieDetails[0].trim());
                    String genre=movieDetails[1].trim();
                    String name=movieDetails[2].trim();
                    String showTime=movieDetails[3].trim();
                    String description=movieDetails[4].trim();
                    if(id==1){movies.add(new Movie(id, genre, name, showTime, "poster2.jpg",description));}
                    else{movies.add(new Movie(id, genre, name, showTime, "poster1.jpg",description));}

                }
            }
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }
    private JPanel createMoviePanel(Movie movie) {
        JPanel moviePanel=new JPanel();
        moviePanel.setLayout(new BorderLayout());
        moviePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        moviePanel.setBackground(Color.BLACK);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
        infoPanel.add(new JLabel("Name: "+movie.getName()));
        infoPanel.add(new JLabel("Genre: "+movie.getGenre()));
        infoPanel.add(new JLabel("ID: "+movie.getId()));
        infoPanel.add(new JLabel("Show Time: "+movie.getShowTimes()));
        infoPanel.add(new JLabel("Description: "+movie.getDescription()));
        JLabel posterLabel=new JLabel();
        ImageIcon posterIcon=new ImageIcon(movie.getPosterPath());
        Image posterImage=posterIcon.getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);
        posterLabel.setIcon(new ImageIcon(posterImage));
        JPanel color=new JPanel();
        color.setBackground(Color.DARK_GRAY);
        moviePanel.add(posterLabel,BorderLayout.WEST);
        moviePanel.add(infoPanel,BorderLayout.CENTER);
        moviePanel.add(color,BorderLayout.SOUTH);
        return moviePanel;
    }
}
