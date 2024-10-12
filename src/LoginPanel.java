import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
    private MyFrame parentFrame;
    private CinemaManagement cinemaManagement;


    public LoginPanel(MyFrame parentFrame, CinemaManagement cinemaManagement) {
        this.parentFrame = parentFrame;
        this.cinemaManagement = cinemaManagement;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.BLACK);
        setBorder(new RoundedBorder(20));
        setPreferredSize(new Dimension(400, 400));


        JLabel userLabel = CustomText.createStyledLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 9, 10, 5);
        gbc.anchor = GridBagConstraints.EAST;
        add(userLabel, gbc);

        JTextField userText = new RoundedTextField(12);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(userText, gbc);


        JLabel passLabel =CustomText.createStyledLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(passLabel, gbc);

        JPasswordField passText = new RoundedPasswordField(12);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passText, gbc);


        JButton loginButton = new RoundedButton("Login") ;

        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);


        JButton registerButton = new RoundedButton("Register");
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLUE);
        gbc.gridx = 1;

        add(registerButton, gbc);


        loginButton.addActionListener(e -> {
            String username = userText.getText().trim();
            String password = new String(passText.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean success = cinemaManagement.login(username, password);
            if (success) {
                    parentFrame.switchToPanel("MainMenu");

            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            parentFrame.switchToPanel("Register");
        });


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }
}
