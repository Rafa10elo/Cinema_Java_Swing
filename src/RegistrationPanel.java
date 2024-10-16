import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationPanel extends JPanel {
    private MyFrame parentFrame;
    private CinemaManagement cinemaManagement;

    public RegistrationPanel(MyFrame parentFrame, CinemaManagement cinemaManagement) {
        this.parentFrame = parentFrame;
        this.cinemaManagement = cinemaManagement;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(Color.BLACK);
        setBorder(new RoundedBorder(20));




        JLabel userLabel = CustomText.createStyledLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 7, 10, 7);
        gbc.anchor = GridBagConstraints.EAST;
        add(userLabel, gbc);

        JTextField userText =new RoundedTextField(10);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(userText, gbc);


        JLabel emailLabel = CustomText.createStyledLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(emailLabel, gbc);

        JTextField emailText =new RoundedTextField(10);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailText, gbc);


        JLabel passLabel = CustomText.createStyledLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(passLabel, gbc);

        JPasswordField passText = new RoundedPasswordField(10);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passText, gbc);


        JButton registerButton = new RoundedButton("Register");
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);


        JButton backButton = new RoundedButton("Back");

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLUE);
        gbc.gridx = 1;
        add(backButton, gbc);


        registerButton.addActionListener(e -> {
            String username = userText.getText().trim();
            String email = emailText.getText().trim();
            String password = new String(passText.getPassword()).trim();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }



            cinemaManagement.register(username, password, email);
            JOptionPane.showMessageDialog(this, "Registration successful! Please login.", "Success", JOptionPane.INFORMATION_MESSAGE);


            parentFrame.switchToPanel("Login");
        });


        backButton.addActionListener(e -> {
            parentFrame.switchToPanel("Login");
        });
    }
}
