package Views;

import controllers.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.jar.JarFile;

public class updatecheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField troom, tname, tcheckin, tpaid, tpending;
    JButton check, update, back, Cancel;

    updatecheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from makebooking");
            while (rs.next()) {
                ccustomer.add(rs.getString("Nationalid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        troom = new JTextField();
        troom.setBounds(200, 120, 150, 25);
        add(troom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tname = new JTextField();
        tname.setBounds(200, 160, 150, 25);
        add(tname);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tcheckin = new JTextField();
        tcheckin.setBounds(200, 200, 150, 25);
        add(tcheckin);

        JLabel lblamount = new JLabel("Amount Paid");
        lblamount.setBounds(30, 240, 100, 20);
        add(lblamount);

        tpaid = new JTextField();
        tpaid.setBounds(200, 240, 150, 25);
        add(tpaid);


        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30, 280, 100, 20);
        add(lblpending);

        tpending = new JTextField();
        tpending.setBounds(200, 280, 150, 25);
        add(tpending);

        check = new JButton("Check");
        check.setBackground(Color.WHITE);
        check.setForeground(Color.BLACK);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.WHITE);
        Cancel.setForeground(Color.BLACK);
        Cancel.setBounds(270, 340, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.WHITE);
        Cancel.setForeground(Color.BLACK);
        Cancel.setBounds(270, 340, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\Update icon with gears_ Loading or updating files, install new software, operating system, update support, setting options, maintenance, adjusting app process, service concept – stock vector.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(400, 50, 500, 300);
        add(background);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from makebooking where Nationalid = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    troom.setText(rs.getString("room"));
                    tname.setText(rs.getString("Name"));
                    tcheckin.setText(rs.getString("time"));
                    tpaid.setText(rs.getString("Deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where availableroom = '"+troom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("Priceoptions");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tpaid.getText());
                    tpending.setText(""+amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String Nationalid = ccustomer.getSelectedItem();
            String room = troom.getText();
            String Name = tname.getText();
            String time = tcheckin.getText();
            String Deposit = tpaid.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("Update makebooking set room = '"+room+"',Name = '"+Name+"',time = '"+time+"',Deposit = '"+Deposit+"'where Nationalid = '"+Nationalid+"'");

                JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
                setVisible(false);
                new Customerpg();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            String query1 = "delete from makebooking where Nationalid = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availableoptions = 'Available' where availableroom = '"+troom.getText()+"'";
        try {
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Booking Canceled");
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        new updatecheck();
    }
}