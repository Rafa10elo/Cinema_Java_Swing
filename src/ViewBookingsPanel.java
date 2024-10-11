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
        setBorder(new RoundedBorder(20));



        JButton refreshButton = new JButton("get the Tickets");
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(refreshButton,BorderLayout.EAST);
        panel.add(backButton,BorderLayout.WEST);
        add(panel,BorderLayout.SOUTH);

        JLabel titleLabel = new JLabel("Your Booked Tickets:", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

         ticketsPanel = new JPanel();
        ticketsPanel.setLayout(new BoxLayout(ticketsPanel, BoxLayout.Y_AXIS));
        ticketsPanel.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(ticketsPanel);
        add(scrollPane, BorderLayout.CENTER);


        backButton.addActionListener(e ->
        {
            parentFrame.switchToPanel("MainMenu");
        });
        refreshButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                getTickets();


            });
        });
    }
    public void getTickets(){
        ticketsPanel.removeAll();
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
        revalidate();
        repaint();

    }

}
