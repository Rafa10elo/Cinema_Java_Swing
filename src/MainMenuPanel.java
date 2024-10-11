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
        setBorder(new RoundedBorder(20));
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
        bookTicketButton.setFocusable(false);

        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setForeground(Color.WHITE);
        viewBookingsButton.setBackground(Color.BLUE);
        viewBookingsButton.setFocusable(false);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLUE);
        logoutButton.setFocusable(false);

        JButton viewHalls = new JButton("View Halls and Movies");
        viewHalls.setForeground(Color.WHITE);
        viewHalls.setBackground(Color.BLUE);
        viewHalls.setFocusable(false);

        buttonPanel.add(bookTicketButton);
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(logoutButton);
        buttonPanel.add(viewHalls);
        add(buttonPanel, BorderLayout.CENTER);

        viewHalls.addActionListener(e -> {

            cinemaManagement.logout();

            new MyFrame2();
        });

        logoutButton.addActionListener(e -> {

            cinemaManagement.logout();

            parentFrame.switchToPanel("Login");
        });


    }
}
