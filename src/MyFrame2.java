import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MyFrame2 extends JFrame {
     final private JPanel moviePanelContainer;
    final private Map<Integer, Cinema> cinemaMap = new HashMap<>();

    public MyFrame2() {
        setTitle("Movies");

        setSize(800, 600);
        setBackground(Color.BLACK);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel hallSelectionPanel = createHallSelectionPanel();
        moviePanelContainer = new JPanel();
        moviePanelContainer.setLayout(new BoxLayout(moviePanelContainer, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(moviePanelContainer);
        mainPanel.add(hallSelectionPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        readHalls();
        add(mainPanel);
        setVisible(true);
    }

    private void readHalls() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Hall.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] HallsDetails = line.split("\\|");
                if (HallsDetails.length == 2) {
                    int num = Integer.parseInt(HallsDetails[0].trim());
                    List<String> movies = Arrays.asList(HallsDetails[1].split("-"));
                    Cinema cinema = new Cinema(num, movies);
                    cinemaMap.put(num, cinema);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Movie> readMoviesFromFile(int hallNumber) {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("MOVIES.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] movieDetails = line.split("\\|");
                if (movieDetails.length == 5) {
                    int id = Integer.parseInt(movieDetails[0].trim());
                    String genre = movieDetails[1].trim();
                    String name = movieDetails[2].trim();
                    String showTime = movieDetails[3].trim();
                    String description = movieDetails[4].trim();
                    //الهبد القندسيييييييييييييييييي
                    if (id == 1 && hallNumber == 1) {
                        movies.add(new Movie(id, genre, name, showTime, "poster2.jpg", description));
                    } else if (id == 2 && hallNumber == 1) {
                        movies.add(new Movie(id, genre, name, showTime, "poster1.jpg", description));
                    } else if (id == 3 && hallNumber == 2) {
                        movies.add(new Movie(id, genre, name, showTime, "poster3.jpg", description));
                    } else if (id == 4 && hallNumber == 2) {
                        movies.add(new Movie(id, genre, name, showTime, "poster4.jpg", description));
                    } else if (id == 5 && hallNumber == 3) {
                        movies.add(new Movie(id, genre, name, showTime, "poster5.jpg", description));
                    } else if (id == 6 && hallNumber == 3) {
                        movies.add(new Movie(id, genre, name, showTime, "poster6.jpg", description));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    private JPanel createHallSelectionPanel() {
        JPanel hallPanel = new JPanel();
        hallPanel.setBackground(Color.GRAY);
        hallPanel.setLayout(new FlowLayout());
        JLabel hallLabel = new JLabel("Select Cinema Hall: ");
        hallPanel.add(hallLabel);
        for (int i = 1; i <= 3; i++) {
            JButton hallButton = new JButton("Hall " + i);
            hallButton.setFocusable(false);
            hallButton.setBackground(Color.DARK_GRAY);
            hallButton.setForeground(Color.WHITE);
            hallPanel.add(hallButton);
            final int hallNumber = i;
            hallButton.addActionListener(e -> displayMoviesForHall(hallNumber));
        }
        return hallPanel;
    }

    private void displayMoviesForHall(int hallNumber) {
        if (moviePanelContainer != null) {
            moviePanelContainer.removeAll();
        }
        Cinema cinema = cinemaMap.get(hallNumber);
        if (cinema != null) {
            List<Movie> movies = readMoviesFromFile(hallNumber);
            for (Movie movie : movies) {
                JPanel moviePanel = createMoviePanel(movie);
                assert moviePanelContainer != null;
                moviePanelContainer.add(moviePanel);
            }
        }
        assert moviePanelContainer != null;
        moviePanelContainer.revalidate();
        moviePanelContainer.repaint();
    }

    private JPanel createMoviePanel(Movie movie) {
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BorderLayout());
        moviePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        moviePanel.setBackground(Color.BLACK);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(new JLabel("Name: " + movie.getName()));
        infoPanel.add(new JLabel("Genre: " + movie.getGenre()));
        infoPanel.add(new JLabel("ID: " + movie.getId()));
        infoPanel.add(new JLabel("Show Time: " + movie.getShowTimes()));
        infoPanel.add(new JLabel("Description: " + movie.getDescription()));
        JLabel posterLabel = new JLabel();
        ImageIcon posterIcon = new ImageIcon(movie.getPosterPath());
        Image posterImage = posterIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        posterLabel.setIcon(new ImageIcon(posterImage));
        JPanel color = new JPanel();
        color.setBackground(Color.DARK_GRAY);
        moviePanel.add(posterLabel, BorderLayout.WEST);
        moviePanel.add(infoPanel, BorderLayout.CENTER);
        moviePanel.add(color, BorderLayout.SOUTH);
        return moviePanel;
    }
}
