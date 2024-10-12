import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundedComboBox<E> extends JComboBox<E> {

    public RoundedComboBox(E[] items) {
        super(items);
        setOpaque(false);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(new RoundedBorder(15));
        setRenderer(new CustomComboBoxRenderer());

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        g2d.dispose();
    }


}
