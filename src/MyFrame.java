import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {

    private LodingPage lodingPage;
    private CardLayout cardLayout;
    public JPanel mainPanel;
    private CinemaManagement cinemaManagement;
    private JPanel displayMovies;
    MyFrame() {
        this.setTitle("Cinema");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setSize(new Dimension(2000,2000));
        setLocationRelativeTo(null);


        lodingPage = new LodingPage();
        cinemaManagement = new CinemaManagement();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        displayMovies=new MyFrame2(this,cinemaManagement);
        ViewBookingsPanel viewBookingsPanel = new ViewBookingsPanel(this, cinemaManagement);
        LoginPanel loginPanel = new LoginPanel(this, cinemaManagement);
        RegistrationPanel registrationPanel = new RegistrationPanel(this, cinemaManagement);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(this, cinemaManagement);
        BookingPanel bookingPanel = new BookingPanel(this, cinemaManagement);

        mainPanel.setPreferredSize(new Dimension(500,500));

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registrationPanel, "Register");
        mainPanel.add(mainMenuPanel, "MainMenu");
        mainPanel.add(bookingPanel, "Booking");
        mainPanel.add(viewBookingsPanel, "ViewBookings");

   //     displayMovies.setPreferredSize(new Dimension(1500,100));
        mainPanel.add(displayMovies,"DisplayMovies");


        JPanel centeredPanel = new JPanel(new GridBagLayout());
        centeredPanel.setBackground(new Color(15, 15, 15));
        centeredPanel.add(mainPanel);
        mainPanel.setName("MainPanel");


        this.add(lodingPage, BorderLayout.CENTER);


        lodingPage.setFadeCompleteListener(() -> {
            this.remove(lodingPage);
            this.add(centeredPanel, BorderLayout.CENTER);
            cardLayout.show(mainPanel, "Login");
            this.revalidate();
            this.repaint();
        });

        this.setVisible(true);
    }
    public JPanel getPanel(String panelName) {
        for (Component comp : mainPanel.getComponents()) {
            if (comp instanceof JPanel && panelName.equals(comp.getName())) {
                return (JPanel) comp;
            }
        }
        return null;
    }
    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}