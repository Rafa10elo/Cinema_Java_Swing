import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private LodingPage lodingPage;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CinemaManagement cinemaManagement;

    MyFrame() {
        this.setTitle("Cinema");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);
        setLocationRelativeTo(null);

        lodingPage = new LodingPage();
        cinemaManagement = new CinemaManagement();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        LoginPanel loginPanel = new LoginPanel(this, cinemaManagement);
        RegistrationPanel registrationPanel = new RegistrationPanel(this, cinemaManagement);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(this, cinemaManagement);


        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registrationPanel, "Register");
        mainPanel.add(mainMenuPanel, "MainMenu");


        JPanel centeredPanel = new JPanel(new GridBagLayout());
        centeredPanel.setBackground(new Color(15,15,15));
        centeredPanel.add(mainPanel);


        this.add(lodingPage, BorderLayout.CENTER);


        lodingPage.setFadeCompleteListener(() -> {
            this.remove(lodingPage);
            this.add(centeredPanel, BorderLayout.CENTER);
            cardLayout.show(mainPanel, "Login");
            this.revalidate();
            this.repaint();
        });

        //this.getContentPane().setBackground();
        this.setVisible(true);
    }

   // for swiching between the pannels
    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
