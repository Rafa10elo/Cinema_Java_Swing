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
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        RoundedButton backButton = new RoundedButton("Back to Main Menu");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLUE);
        backButton.setPreferredSize(new Dimension(150,30));


        RoundedButton refreshButton = new RoundedButton("get the Tickets");
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setBackground(Color.BLUE);
        refreshButton.setPreferredSize(new Dimension(150,30));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(refreshButton,BorderLayout.EAST);
        panel.add(backButton,BorderLayout.WEST);
        panel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        add(panel,BorderLayout.SOUTH);
        panel.setBackground(Color.black);

        JLabel titleLabel = CustomText.createStyledHeader("Your Booked Tickets:");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

         ticketsPanel = new JPanel();
        ticketsPanel.setLayout(new BoxLayout(ticketsPanel, BoxLayout.Y_AXIS));
        ticketsPanel.setBackground(Color.BLACK);
        RoundedScrollPane scrollPane = new RoundedScrollPane(ticketsPanel);
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
                JLabel noTicketsLabel =CustomText.createStyledLabel("No tickets booked yet.");
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
            JLabel noUserLabel = CustomText.createStyledLabel("No user logged in.");
            noUserLabel.setForeground(Color.RED);
            ticketsPanel.add(noUserLabel);
        }
        revalidate();
        repaint();

    }

}
