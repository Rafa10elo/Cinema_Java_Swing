import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuPanel extends JPanel {
    private MyFrame parentFrame;
    private CinemaManagement cinemaManagement;

    public MainMenuPanel(MyFrame parentFrame, CinemaManagement cinemaManagement) {
        this.parentFrame = parentFrame;
        this.cinemaManagement = cinemaManagement;
        this.setBackground(Color.BLACK);
        setLayout(new BorderLayout());


        JLabel welcomeLabel = new JLabel("Welcome to Cinema Management System!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.BLACK);

        JButton bookTicketButton = new JButton("Book a Ticket");
        bookTicketButton.setForeground(Color.WHITE);
        bookTicketButton.setBackground(Color.BLUE);

        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setForeground(Color.WHITE);
        viewBookingsButton.setBackground(Color.BLUE);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLUE);

        buttonPanel.add(bookTicketButton);
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);


        logoutButton.addActionListener(e -> {

            cinemaManagement.logout();

            parentFrame.switchToPanel("Login");
        });


    }
}
