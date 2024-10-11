import javax.swing.*;
import java.awt.*;

public class BookingPanel extends JPanel {
    private MyFrame parentFrame;
    private CinemaManagement cinemaManagement;

    public BookingPanel(MyFrame parentFrame, CinemaManagement cinemaManagement) {
        this.parentFrame = parentFrame;
        this.cinemaManagement = cinemaManagement;

        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        setBorder(new RoundedBorder(20));

        gbc.insets = new Insets(10, 10, 10, 10);


        JLabel movieLabel = new JLabel("Select a Movie:");//for testing
        movieLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(movieLabel, gbc);


        String[] movies = {"Inception", "The Matrix", "Titanic"}; // for testing
        JComboBox<String> movieDropdown = new JComboBox<>(movies);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(movieDropdown, gbc);


        JLabel showtimeLabel = new JLabel("Select Showtime:");//for testing
        showtimeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(showtimeLabel, gbc);


        String[] showtimes = {"5:00 PM", "7:30 PM", "10:00 PM"}; //for testing
        JComboBox<String> showtimeDropdown = new JComboBox<>(showtimes);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(showtimeDropdown, gbc);


        JLabel seatLabel = new JLabel("Select Seat Number:");//for testing
        seatLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(seatLabel, gbc);


        JSpinner seatSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); //for testing
        gbc.gridy = 2;
        gbc.gridx =1;
        add(seatSpinner, gbc);


        JButton bookButton = new JButton("Book Ticket");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bookButton, gbc);


        JButton backButton = new JButton("Back to Main Menu");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(backButton, gbc);


        bookButton.addActionListener(e -> {
            String selectedMovie = (String) movieDropdown.getSelectedItem();
            String selectedShowtime = (String) showtimeDropdown.getSelectedItem();
            int selectedSeat = (int) seatSpinner.getValue();

            Ticket newTicket = new Ticket(selectedMovie, selectedShowtime, selectedSeat);


                cinemaManagement.bookTicket(newTicket);



            JOptionPane.showMessageDialog(this, "Ticket booked for: " + selectedMovie + " at " + selectedShowtime + ", Seat: " + selectedSeat);
        });


        backButton.addActionListener(e -> parentFrame.switchToPanel("MainMenu"));
    }
}
