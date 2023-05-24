package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DashBoard extends JFrame implements ActionListener{
    JLabel luton;
    JPanel heading;
    JMenuBar mb;
    JMenu m1, m2;
    DashBoard() {
        luton = new JLabel("Hotel Luton");
        luton.setBounds(550,40,1200,100);
        luton.setFont(new Font("Verdana",Font.PLAIN,40));
        luton.setForeground(Color.BLACK);
        add(luton);

        //heading
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 100));
        heading.setBounds(0, 0, 1536, 40);
        add(heading);

        mb = new JMenuBar();
        mb.setAlignmentX(Component.LEFT_ALIGNMENT);
        mb.setPreferredSize(new Dimension(1536, 30));
        heading.add(mb);

        m1 = new JMenu("Hotel Management");
        m1.setHorizontalAlignment(SwingConstants.LEFT);
        mb.add(m1);

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        m1.add(reception);

        m2 = new JMenu("Admin");
        m2.setHorizontalAlignment(SwingConstants.LEFT);
        mb.add(m2);

        JMenuItem addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        m2.add(addemployee);

        JMenuItem addroom = new JMenuItem("Add Room");
        addroom.addActionListener(this);
        m2.add(addroom);

        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\Dash_img.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1536, 864, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel backgrouund = new JLabel("", background_image, JLabel.CENTER);

        backgrouund.add(heading);
        backgrouund.setBounds(0, 0, 1536, 864);
        add(backgrouund);
        setSize(1536, 864);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        } else if (ae.getActionCommand().equals("Add Room")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("Reception")) {
            new Reception();
            }
        }

    public static void main(String[] args) {
        new DashBoard();
    }
}
