package Views;

import controllers.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import java.sql.SQLException;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JComboBox bedType;
    JCheckBox available;
    JButton btn,Submit;
    SearchRoom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);


        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedType = new JComboBox(new String[]{"Single Bed","Double Bed","Twin Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Status");
        l2.setBounds(350,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Price");
        l3.setBounds(590,160,100,20);
        add(l3);
        JLabel l4 = new JLabel("BedType");
        l4.setBounds(850,160,   100,20);
        add(l4);

        ImageIcon background_image1 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\Finding Your Migraine Triggers - My Migraine Miracle.jpg");
        Image img1 = background_image1.getImage();
        Image temp_img1 = img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        background_image1 = new ImageIcon(temp_img1);
        JLabel background1 = new JLabel("", background_image1, JLabel.CENTER);
        background1.setBounds(600, 0, 100, 100);
        add(background1);

        table = new JTable();
        table.setBounds(0,200,1000,300);
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
        btn.setBounds(500,520,120,30);
        add(btn);


        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        Submit.setBounds(300,520,120,30);
        add(Submit);

        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Submit){
            try {
                String query1 = "select * from room where bdtyp = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availableoptions = 'Available' AND bdtype = '"+bedType.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else {
                    rs = conn.s.executeQuery(query1);

                }

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }else {
            dispose();
            new Reception();
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
