import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewBookingsPanel extends JPanel {
    private MyFrame parentFrame;
    private CinemaManagement cinemaManagement;
    private JPanel ticketsPanel;
    public ViewBookingsPanel(MyFrame parentFrame, CinemaManagement cinemaManagement) {
        this.parentFrame = parentFrame;
        this.cinemaManagement = cinemaManagement;
        System.out.println(1);
      
        JButton backButton = new JButton("Back to Main Menu");
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        add(backButton,BorderLayout.SOUTH);

        JLabel titleLabel = new JLabel("Your Booked Tickets:", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

         ticketsPanel = new JPanel();
        ticketsPanel.setLayout(new BoxLayout(ticketsPanel, BoxLayout.Y_AXIS));
        ticketsPanel.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(ticketsPanel);
        add(scrollPane, BorderLayout.CENTER);

        User currentUser = cinemaManagement.getCurrentUser();
        if (currentUser != null) {
            ArrayList<Ticket> tickets = (ArrayList<Ticket>) currentUser.getTicketsList();
            if (tickets.isEmpty()) {
                JLabel noTicketsLabel = new JLabel("No tickets booked yet.");
                noTicketsLabel.setForeground(Color.WHITE);
                ticketsPanel.add(noTicketsLabel);
            } else {
                for (Ticket ticket : tickets) {
                    TicketPanel ticketPanel = new TicketPanel(ticket, cinemaManagement, currentUser, ticketsPanel);
                    ticketsPanel.add(ticketPanel);
                }
            }
        } else {
            System.out.println();
            JLabel noUserLabel = new JLabel("No user logged in.");
            noUserLabel.setForeground(Color.RED);
            ticketsPanel.add(noUserLabel);
        }
        backButton.addActionListener(e -> parentFrame.switchToPanel("MainMenu"));

    }
//    public void loadTickets() {
//        User currentUser = cinemaManagement.getCurrentUser();
//        if (currentUser != null) {
//            ArrayList<Ticket> tickets = (ArrayList<Ticket>) currentUser.getTicketsList();
//            if (tickets.isEmpty()) {
//                JLabel noTicketsLabel = new JLabel("No tickets booked yet.");
//                noTicketsLabel.setForeground(Color.WHITE);
//                ticketsPanel.add(noTicketsLabel);
//            } else {
//                for (Ticket ticket : tickets) {
//                    addTicketPanel(ticket);
//                }
//            }
//        } else {
//            JLabel noUserLabel = new JLabel("No user logged in.");
//            noUserLabel.setForeground(Color.RED);
//            ticketsPanel.add(noUserLabel);
//        }
//
//    }
//
//    public void reload() {
//
//        ticketsPanel.removeAll();
//        User currentUser = cinemaManagement.getCurrentUser();
//        if (currentUser != null) {
//            ArrayList<Ticket> tickets = (ArrayList<Ticket>) currentUser.getTicketsList();
//            if (tickets.isEmpty()) {
//                JLabel noTicketsLabel = new JLabel("No tickets booked yet.");
//                noTicketsLabel.setForeground(Color.WHITE);
//                ticketsPanel.add(noTicketsLabel);
//            } else {
//                for (Ticket ticket : tickets) {
//                    addTicketPanel(ticket);
//                }
//            }
//        } else {
//            JLabel noUserLabel = new JLabel("No user logged in.");
//            noUserLabel.setForeground(Color.RED);
//            ticketsPanel.add(noUserLabel);
//        }
//
//
//        ticketsPanel.revalidate();
//        ticketsPanel.repaint();
//    }
//    public void addTicketPanel(Ticket ticket) {
//        TicketPanel ticketPanel = new TicketPanel(ticket, cinemaManagement, cinemaManagement.getCurrentUser(), ticketsPanel);
//        ticketsPanel.add(ticketPanel);
//        ticketsPanel.revalidate();
//        ticketsPanel.repaint();
//    }
}
