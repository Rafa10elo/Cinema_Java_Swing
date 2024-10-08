import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    MyFrame(){
        String[] genres={"Horror","Action","Romance","Adventure"};
        this.setTitle("Cinema");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        LodingPage lodingPage = new LodingPage();
        String[] showtime={"Thursday: 06:00PM-08:00PM-10:00PM","Friday: 06:00PM-08:00PM-10:00PM"};

        Movie movie1=new Movie(1,genres[1],"NAME1",showtime[0]);
        Movie movie2=new Movie(2,genres[2],"NAME2",showtime[1]);
        String[] movies={movie1.name,movie2.name};
        Movie[] movies1={movie1,movie2};
        JLabel label=new JLabel("Now In Cinemas!");
        label.setBackground(Color.black);

        JList<String>list=new JList<>(movies);
        list.setVisibleRowCount(2);
        list.setBackground(Color.red);//i'll add it later,i didn't decide where to put it


        JComboBox<String> comboBox= new JComboBox<>(movies);

        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel(new FlowLayout());
        panel1.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
        panel3.setBackground(Color.YELLOW);
        panel1.setPreferredSize(new Dimension(50,50));
        panel2.setPreferredSize(new Dimension(50,50));
        panel3.setPreferredSize(new Dimension(50,50));

        panel.setBounds(800,600,100,100);
        panel.add(comboBox);
        panel.setBackground(Color.black);
        panel.setOpaque(true);


        this.add(panel);
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.WEST);
        panel3.add(label);
        panel3.add(list);
        this.add(panel3,BorderLayout.CENTER);
        this.add(lodingPage);


        this.setVisible(true);

    }


}
