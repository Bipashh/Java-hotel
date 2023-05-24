package Views;

import com.mysql.cj.protocol.Resultset;
import controllers.Conn;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.EventObject;

public class Customerpg extends JFrame implements ActionListener{
    JLabel heading,room,Date,status,deposit,name,lbltime,checkintime,nationalid;
    Date date;
    JTextField namef,depositf,nationalidf;
    Choice croom;
    JComboBox day,month,year,day1,month1,year1;
    JButton Add,Cancel,update;
    public Customerpg() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        heading = new JLabel("Make Booking");
        heading.setFont(new Font("Verdana", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        nationalid = new JLabel("National id");
        nationalid.setFont(new Font("Verdana", Font.PLAIN, 16));
        nationalid.setBounds(60, 80, 120, 30);
        add(nationalid);

        nationalidf = new JTextField();
        nationalidf.setBounds(220, 80, 150, 30);
        nationalidf.setBackground(Color.WHITE);
        add(nationalidf);

        name = new JLabel("Name");
        name.setFont(new Font("Verdana", Font.PLAIN, 16));
        name.setBounds(60, 130, 120, 30);
        add(name);

        namef = new JTextField();
        namef.setBounds(220, 130, 150, 30);
        namef.setBackground(Color.WHITE);
        add(namef);

        room = new JLabel("Room Number");
        room.setFont(new Font("Verdana", Font.PLAIN, 16));
        room.setBounds(60, 180, 120, 30);
        add(room);

        croom = new Choice();
        try {
            Conn conn = new Conn();
            String query = "Select * from room";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("availableroom"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(220, 180, 150, 30);
        croom.setBackground(Color.WHITE);
        add(croom);

        status = new JLabel("Check in Date");
        status.setFont(new Font("Verdana", Font.PLAIN, 16));
        status.setBounds(60, 230, 120, 30);
        add(status);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String years[] = {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998"};

        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        day.setBounds(220, 230, 50, 20);
        month.setBounds(280, 230, 50, 20);
        year.setBounds(340, 230, 60, 20);

        add(day);
        add(month);
        add(year);

        Date = new JLabel("Checkout Date");
        Date.setFont(new Font("Verdana", Font.PLAIN, 16));
        Date.setBounds(60, 280, 120, 30);
        add(Date);

        String dayss[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String monthss[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String yearss[] = {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998"};

        day1 = new JComboBox(dayss);
        month1 = new JComboBox(monthss);
        year1 = new JComboBox(yearss);

        day1.setBounds(220, 280, 50, 20);
        month1.setBounds(280, 280, 50, 20);
        year1.setBounds(340, 280, 60, 20);

        add(day1);
        add(month1);
        add(year1);

        deposit = new JLabel("Deposit");
        deposit.setFont(new Font("Verdana", Font.PLAIN, 16));
        deposit.setBounds(60, 330, 120, 30);
        add(deposit);

        depositf = new JTextField();
        depositf.setBounds(220, 330, 150, 30);
        depositf.setBackground(Color.WHITE);
        add(depositf);

        lbltime = new JLabel("Checkin time");
        lbltime.setFont(new Font("Verdana", Font.PLAIN, 16));
        lbltime.setBounds(60, 380, 120, 30);
        add(lbltime);

        date = new Date();

        checkintime = new JLabel("" + date);
        checkintime.setBounds(200,380,180,25);
        checkintime.setFont(new Font("Verdana",Font.PLAIN,16));
        add(checkintime);
        Add = new JButton("Book");
        Add.setForeground(Color.BLACK);
        Add.setBackground(Color.WHITE);
        Add.setBounds(30,450,130,30);
        Add.addActionListener(this);
        add(Add);

        update = new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.setBounds(165,450,130,30);
        update.addActionListener(this);
        add(update);

        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.BLACK);
        Cancel.setBackground(Color.WHITE);
        Cancel.setBounds(300,450,130,30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon image1 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\luroom2.jpg");
        Image img = image1.getImage();
        Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(temp_img);
        JLabel backgroundLabel = new JLabel("", image1, JLabel.CENTER);
        backgroundLabel.setBounds(400, 30, 400, 300);
        add(backgroundLabel);

        ImageIcon image2 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\luroom.jpg");
        Image img1 = image2.getImage();
        Image temp_img1 = img1.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(temp_img1);
        JLabel backgroundLabel1 = new JLabel("", image1, JLabel.CENTER);
        backgroundLabel1.setBounds(810, 30, 400, 300);
        add(backgroundLabel1);
        setBounds(200,200,1210,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== Add){
            String Nationalid = nationalidf.getText();
            String Name = namef.getText();
            String room = croom.getSelectedItem();
            String checkindate = day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
            String checkoutdate = day1.getSelectedItem() + "/" + month1.getSelectedItem() + "/" + year1.getSelectedItem();
            String Deposit = depositf.getText();
            String time = checkintime.getText();
            try{
                Conn conn = new Conn();
                String str = "insert into makebooking values('"+Nationalid+"','"+Name+"','"+room+"', '"+checkindate+"','"+checkoutdate+"','"+Deposit+"','"+time+"')";
                String str2 = "update room set availableoptions = 'Occupied' where availableroom = '"+room+"'";
                conn.s.executeUpdate(str);
                conn.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"Booking Added Successfully");
                setVisible(false);

                dispose();
                new viewbooking();

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==update) {
            dispose();
            new updatecheck();
        } else {
            dispose();
            new Login();
        }
    }

    public static void main(String[] args) {
        new Customerpg();
    }
}
