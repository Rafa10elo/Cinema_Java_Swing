import javax.swing.*;
import java.awt.*;

public class CustomText {
    private static final Font DEFAULT_LABEL_FONT = new Font("Roboto", Font.PLAIN, 15);
    private static final Color DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final Font DEFAULT_HEADER_FONT = new Font("SERIF",Font.BOLD,20);


    public static JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(DEFAULT_LABEL_FONT);
        label.setForeground(DEFAULT_TEXT_COLOR);
        return label;
    }
    public static JLabel createStyledHeader(String text) {
        JLabel label = new JLabel(text);
        label.setFont(DEFAULT_HEADER_FONT);
        label.setForeground(DEFAULT_TEXT_COLOR);
        return label;
    }


}
