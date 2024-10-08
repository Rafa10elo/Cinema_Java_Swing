import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private LodingPage lodingPage;

    MyFrame() {
        String[] genres = {"Horror", "Action", "Romance", "Adventure"};
        this.setTitle("Cinema");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(2000, 2000);

        lodingPage = new LodingPage();
        String[] showtime = {"Thursday: 06:00PM-08:00PM-10:00PM", "Friday: 06:00PM-08:00PM-10:00PM"};

        Movie movie1 = new Movie(1, genres[1], "NAME1", showtime[0]);
        Movie movie2 = new Movie(2, genres[2], "NAME2", showtime[1]);
        String[] movies = {movie1.name, movie2.name};

        JLabel label = new JLabel("Now In Cinemas!");
        label.setBackground(Color.black);

        JList<String> list = new JList<>(movies);
        list.setVisibleRowCount(2);
        list.setBackground(Color.red);

        JComboBox<String> comboBox = new JComboBox<>(movies);

        panel = new JPanel();
    //    panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel(new FlowLayout());
        //panel1.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
      //  panel1.add(list);
        panel3.setBackground(Color.YELLOW);
      //  panel1.setPreferredSize(new Dimension(50, 50));
        panel2.setPreferredSize(new Dimension(50, 50));
        panel3.setPreferredSize(new Dimension(50, 50));

        panel.setBounds(800, 600, 100, 100);
        panel.add(comboBox);
        panel.setBackground(Color.black);
        panel.setOpaque(true);

       // this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        panel3.add(label);
        panel3.add(list);
        this.add(panel3, BorderLayout.CENTER);

        // // ITS TEST THING FOR THE REMOVAL OF THE LOADING PAGE
        panel.setVisible(false);
       // panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        this.add(lodingPage);

        lodingPage.setFadeCompleteListener(() -> {

            this.remove(lodingPage);
            panel.setVisible(true);
          //  panel1.setVisible(true);
            panel2.setVisible(true);
            panel3.setVisible(true);
            this.revalidate();
            this.repaint();
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
