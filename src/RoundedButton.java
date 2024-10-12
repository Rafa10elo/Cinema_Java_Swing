import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setOpaque(false);
        setBorder(new RoundedBorder(15));
        setPreferredSize(new Dimension(120, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g2d);

        g2d.dispose();
    }
}