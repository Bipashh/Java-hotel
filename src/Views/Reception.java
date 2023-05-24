package Views;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener
{
    JPanel Data;
    JButton  room,Status,employee,customerinfo,searchroom,manager,checkout,logout,Update;
    Reception(){
        Data = new JPanel();
        Data.setLayout(null);
        Data.setBackground(new Color(0, 0, 0,50));
        Data.setBounds(0, 0, 800, 570);

        //frame
        setLayout(null);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //button
        room = new JButton("Rooms");
        room.setBounds(600,30,150,30);
        room.setBackground(Color.WHITE);
        room.setForeground(Color.BLACK);
        room.addActionListener(this);
        Data.add(room);

        employee = new JButton("Employee Details");
        employee.setBounds(600,80,150,30);
        employee.setBackground(Color.WHITE);
        employee.setForeground(Color.BLACK);
        employee.addActionListener(this);
        Data.add(employee);


        customerinfo = new JButton("Customer info");
        customerinfo.setBounds(600,130,150,30);
        customerinfo.setBackground(Color.WHITE);
        customerinfo.setForeground(Color.BLACK);
        customerinfo.addActionListener(this);
        Data.add(customerinfo);

        searchroom = new JButton("Search Room");
        searchroom.setBounds(600,180,150,30);
        searchroom.setBackground(Color.WHITE);
        searchroom.setForeground(Color.BLACK);
        searchroom.addActionListener(this);
        Data.add(searchroom);

        manager = new JButton("Manager Info");
        manager.setBounds(600,230,150,30);
        manager.setBackground(Color.WHITE);
        manager.setForeground(Color.BLACK);
        manager.addActionListener(this);
        Data.add(manager);

        checkout = new JButton("Check Out");
        checkout.setBounds(600,330,150,30);
        checkout.setBackground(Color.WHITE);
        checkout.setForeground(Color.BLACK);
        checkout.addActionListener(this);
        Data.add(checkout);

        Update = new JButton("Update Status");
        Update.setBounds(600,280,150,30);
        Update.setBackground(Color.WHITE);
        Update.setForeground(Color.BLACK);
        Update.addActionListener(this);
        Data.add(Update);

        logout = new JButton("Logout");
        logout.setBounds(600, 380, 150, 30);
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        Data.add(logout);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    System.exit(0);
                }
            }
        });

        //image
        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\reception office.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 800, 570);
        add(Data);
        add(background);
        setBounds(350, 200, 800, 570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== room) {
            dispose();
            new viewroom();
    } else if (ae.getSource()==employee) {
            dispose();
            new viewemployee();
        } else if (ae.getSource()==manager) {
            dispose();
            new Managerinfo();
        } else if (ae.getSource()==customerinfo) {
            dispose();
            new viewbooking();
        }else if (ae.getSource()==searchroom) {
            dispose();
            new SearchRoom();
        }else if (ae.getSource()==Update) {
            dispose();
            new update1();
        }else if (ae.getSource()==checkout) {
            dispose();
            new Checkout();
        }
    }
    public static void main(String[] args){
            new Reception();
        }
    }

