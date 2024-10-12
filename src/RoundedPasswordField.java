import javax.swing.*;
import java.awt.*;

public class RoundedPasswordField extends JPasswordField{
public RoundedPasswordField(int columns){
    super(columns);
    setOpaque(false);
    setPreferredSize(new Dimension(90, 50));
    setBorder(new RoundedBorder(15));
    setForeground(Color.black);
    setCaretColor(Color.black);


}

@Override
    public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D)g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(getBackground());
    g2d.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
    g2d.dispose();

    super.paintComponent(g);

}
}
