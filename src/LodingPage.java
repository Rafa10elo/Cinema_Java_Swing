import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LodingPage extends JPanel {
    private static final int SIZE = 100;
    private static final int DOT_RADIUS = 10;
    private static final int DOT_COUNT = 8;
    private int angle = 0;
    private float messageOpacity = 0.0f;
    private boolean showMessage = false;
    private FadeCompleteListener fadeCompleteListener;
// صلح اللودنق مشان الله يزلمة
    public LodingPage() {
        Timer spinnerTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!showMessage) {
                    angle += 30;
                    if (angle >= 360) {
                        angle = 0;
                    }
                    repaint();
                }
            }
        });
        spinnerTimer.start();

        Timer messageTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage = true;
                ((Timer) e.getSource()).stop();
                startMessageFadeIn();
            }
        });
        messageTimer.setRepeats(false);
        messageTimer.start();
    }

    private void startMessageFadeIn() {
        Timer fadeInTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageOpacity += 0.05f;
                if (messageOpacity >= 1.0f) {
                    messageOpacity = 1.0f;
                    ((Timer) e.getSource()).stop();

                    // Notify that the effect has finished
                    if (fadeCompleteListener != null) {
                        fadeCompleteListener.onFadeComplete();
                    }
                }
                repaint();
            }
        });
        fadeInTimer.start();
    }

    public void setFadeCompleteListener(FadeCompleteListener listener) {
        this.fadeCompleteListener = listener;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        if (!showMessage) {
            for (int i = 0; i < DOT_COUNT; i++) {
                double theta = Math.toRadians(i * 360.0 / DOT_COUNT + angle);
                int x = (int) (centerX + Math.cos(theta) * (SIZE / 2 - DOT_RADIUS));
                int y = (int) (centerY + Math.sin(theta) * (SIZE / 2 - DOT_RADIUS));
                float opacity = (i + 1) / (float) DOT_COUNT;
                g2d.setColor(new Color(0, 0, 0, opacity));
                g2d.fillOval(x - DOT_RADIUS, y - DOT_RADIUS, DOT_RADIUS * 2, DOT_RADIUS * 2);
            }
        } else {
            g2d.setFont(new Font("Arial", Font.BOLD, 36));
            g2d.setColor(new Color(0, 0, 0, messageOpacity));
            String welcomeMessage = "Welcome!";
            FontMetrics fm = g2d.getFontMetrics();
            int messageWidth = fm.stringWidth(welcomeMessage);
            g2d.drawString(welcomeMessage, centerX - messageWidth / 2, centerY);
        }

        g2d.dispose();
    }

    public interface FadeCompleteListener {
        void onFadeComplete();
    }
}
