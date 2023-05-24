package Views;

import controllers.Conn;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
    public class viewemployee extends JFrame implements ActionListener {
        JTable table;
        JButton btn;

        viewemployee() {

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\897ebf9256244ad0a1a6ea9e01007133.jpg");
            Image img = background_image.getImage();
            Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            background_image = new ImageIcon(temp_img);
            JLabel background = new JLabel("", background_image, JLabel.CENTER);
            background.setBounds(500, 0, 600, 600);
            add(background);

            JLabel l1 = new JLabel("Name");
            l1.setBounds(10, 10, 100, 20);
            add(l1);

            JLabel l2 = new JLabel("Age");
            l2.setBounds(90, 10, 100, 20);
            add(l2);

            JLabel l3 = new JLabel("Gender");
            l3.setBounds(150, 10, 100, 20);
            add(l3);

            JLabel l4 = new JLabel("Post");
            l4.setBounds(230, 10, 100, 20);
            add(l4);
            JLabel l5 = new JLabel("Email");
            l5.setBounds(300, 10, 100, 20);
            add(l5);
            JLabel l6 = new JLabel("Phone");
            l6.setBounds(370, 10, 100, 20);
            add(l6);
            JLabel l7 = new JLabel("NationalID");
            l7.setBounds(430, 10, 100, 20);
            add(l7);

            table = new JTable();
            table.setBounds(0, 40, 500, 400);
            add(table);

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from employee");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
            btn = new JButton("Back");
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.white);
            btn.addActionListener(this);
            btn.setBounds(220, 500, 120, 30);
            add(btn);

            setBounds(300, 200, 1050, 600);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            new Reception();
        }


        public static void main(String[] args) {

            new viewemployee();
        }
    }