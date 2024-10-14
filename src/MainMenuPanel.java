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
        //setPreferredSize(new Dimension(1600,1000));


        JLabel welcomeLabel = new JLabel("Welcome to Cinema Management System!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(Box.createVerticalGlue());

        JButton bookTicketButton = new RoundedButton("Book a Ticket");
        bookTicketButton.setForeground(Color.WHITE);
        bookTicketButton.setBackground(Color.BLUE);
        bookTicketButton.setFocusable(false);
        bookTicketButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));





        JButton viewBookingsButton = new RoundedButton("View Bookings");
        viewBookingsButton.setForeground(Color.WHITE);
        viewBookingsButton.setBackground(Color.BLUE);
        viewBookingsButton.setFocusable(false);
        viewBookingsButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton logoutButton = new RoundedButton("Logout");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.PINK);
        logoutButton.setFocusable(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton viewHalls = new RoundedButton("View Halls and Movies");
        viewHalls.setForeground(Color.WHITE);
        viewHalls.setBackground(Color.BLUE);
        viewHalls.setFocusable(false);
        viewHalls.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonPanel.add(Box.createVerticalGlue());

        buttonPanel.add(bookTicketButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(viewHalls);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(logoutButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));



        add(buttonPanel, BorderLayout.CENTER);

        viewHalls.addActionListener(e -> {
            parentFrame.mainPanel.setPreferredSize(new Dimension(1500,700));
parentFrame.switchToPanel("DisplayMovies");

        });
        bookTicketButton.addActionListener(e -> parentFrame.switchToPanel("Booking"));
        viewBookingsButton.addActionListener(e -> parentFrame.switchToPanel("ViewBookings"));


        logoutButton.addActionListener(e -> {

            cinemaManagement.logout();

            parentFrame.switchToPanel("Login");
        });


    }
}
