package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class viewbooking extends JFrame implements ActionListener {

    String[] columnNames = {"Name", "Room", "Check-in Date", "Check-out Date", "Deposit","Time"};
    JTable table1;
    DefaultTableModel tableModel;
    JScrollPane scroll;
    JButton btn,edit;

    public viewbooking() {
        this.setTitle("Table Demo");
        this.setSize(650, 350);
        this.setResizable(false);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        table1=new JTable();
        table1.setModel(tableModel);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","");
            String sql = "SELECT * FROM makebooking";
            PreparedStatement pstat = conn.prepareStatement(sql);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                String name = rs.getString("Name");
                String room = rs.getString("room");
                String checkin = rs.getString("checkindate");
                String checkout = rs.getString("checkoutdate");
                String deposit = rs.getString("Deposit");
                String Time = rs.getString("time");
                tableModel.addRow(new Object[]{ name, room, checkin, checkout, deposit,Time});
            }
            rs.close();
            pstat.close();
            conn.close();
        }
        catch(Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
        btn = new JButton("Back");
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.addActionListener(this);
        btn.setBounds(520,500,120,30);
        add(btn);

        edit = new JButton("Update");
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.white);
        edit.addActionListener(this);
        edit.setBounds(320,500,120,30);
        add(edit);

        this.add(scroll);
        this.setVisible(true);
        this.setBounds(300,200,1000,600);
    }

    public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==btn){
           dispose();
           new Customerpg();
       }else {
           dispose();
           new updatecheck();
       }
    }

    public static void main(String[] args) {
        new viewbooking();
    }
}
