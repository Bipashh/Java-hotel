package Views;

import controllers.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import java.sql.SQLException;

public class viewroom extends JFrame implements ActionListener {
    JTable table;
    JButton btn;
    viewroom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\loroom3.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(500, 0, 600, 600);
        add(background);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Status");
        l2.setBounds(160,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Price");
        l3.setBounds(300,10,100,20);
        add(l3);
        JLabel l4 = new JLabel("BedType");
        l4.setBounds(400,10,100,20);
        add(l4);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn = new JButton("Back");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.addActionListener(this);
        btn.setBounds(220,500,120,30);
        add(btn);

        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }


    public static void main(String[] args) {
        new viewroom();
    }
}
