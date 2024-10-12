import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {
    private Ticket ticket;
    private CinemaManagement cinemaManagement;
    private User currentUser;
    private JPanel parentPanel;

    public TicketPanel(Ticket ticket, CinemaManagement cinemaManagement, User currentUser, JPanel parentPanel) {
        this.ticket = ticket;
        this.cinemaManagement = cinemaManagement;
        this.currentUser = currentUser;
        this.parentPanel = parentPanel;

        setLayout(new GridLayout(1, 4));
        setBackground(Color.BLACK);
        setBorder(new RoundedBorder(20));


        JLabel movieLabel = CustomText.createStyledLabel("Movie: " + ticket.getMovieName());
        movieLabel.setForeground(Color.WHITE);
        add(movieLabel);


        JLabel showtimeLabel = CustomText.createStyledLabel("Showtime: " + ticket.getShowTime());
        showtimeLabel.setForeground(Color.WHITE);
        add(showtimeLabel);


        JLabel seatLabel = CustomText.createStyledLabel("Seat: " + ticket.getSeatNumber());
        seatLabel.setForeground(Color.WHITE);
        add(seatLabel);


        JButton removeButton = new RoundedButton("Remove");
        removeButton.setBackground(Color.RED);
        removeButton.setForeground(Color.WHITE);
        add(removeButton);

        removeButton.addActionListener(e -> {

            currentUser.removeTicket(ticket);
            cinemaManagement.setUsersToFile();


            parentPanel.remove(this);
            parentPanel.revalidate();
            parentPanel.repaint();

            JOptionPane.showMessageDialog(this, "Ticket removed for: " + ticket.getMovieName());
        });
    }
}
