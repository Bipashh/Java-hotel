package Views;

import controllers.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JLabel heading,roomno,status,price,bedtype;
    JComboBox availablecombo,availableroom1,bdtype,Pricecombo;
    JButton Add,Cancel;
    AddRooms(){
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Verdana",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        roomno = new JLabel("Room Number");
        roomno.setFont(new Font("Verdana",Font.PLAIN,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);

        String availableroom[]={"Select","101","102","103","104","105","106","107","201","202","203","204"};
        availableroom1 = new JComboBox(availableroom);
        availableroom1.setBounds(220,80,150,30);
        availableroom1.setBackground(Color.WHITE);
        add(availableroom1);

        status = new JLabel("Room Status");
        status.setFont(new Font("Verdana",Font.PLAIN,16));
        status.setBounds(60,130,120,30);
        add(status);

        String availableoptions[]={"Select","Available","Occupied"};
        availablecombo = new JComboBox(availableoptions);
        availablecombo.setBounds(220,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        price = new JLabel("Price");
        price.setFont(new Font("Verdana",Font.PLAIN,16));
        price.setBounds(60,180,120,30);
        add(price);

        String Priceoptions[]={"Select","1000","1500","2000","2500","3000"};
        Pricecombo = new JComboBox(Priceoptions);
        Pricecombo.setBounds(220,180,150,30);
        Pricecombo.setBackground(Color.WHITE);
        add(Pricecombo);

        bedtype = new JLabel("Bed Type");
        bedtype.setFont(new Font("Verdana",Font.PLAIN,16));
        bedtype.setBounds(60,230,120,30);
        add(bedtype);

        String bdtyp[]={"Select","Single Bed","Double Bed","Twin Bed"};
        bdtype = new JComboBox(bdtyp);
        bdtype.setBounds(220,230,150,30);
        bdtype.setBackground(Color.WHITE);
        add(bdtype);

        Add = new JButton("Add Room");
        Add.setForeground(Color.BLACK);
        Add.setBackground(Color.WHITE);
        Add.setBounds(60,350,130,30);
        Add.addActionListener(this);
        add(Add);

        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.BLACK);
        Cancel.setBackground(Color.WHITE);
        Cancel.setBounds(300,350,130,30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon image1 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\luroom.jpg");
        Image img = image1.getImage();
        Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(temp_img);
        JLabel backgroundLabel = new JLabel("", image1, JLabel.CENTER);
        backgroundLabel.setBounds(400, 30, 500, 300);
        add(backgroundLabel);

        setBounds(280,200,840,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== Add){
            String availableroom = (String) availableroom1.getSelectedItem();
            String availableoptions = (String) availablecombo.getSelectedItem();
            String Priceoptions = (String) Pricecombo.getSelectedItem();
            String bdtyp = (String) bdtype.getSelectedItem();

            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+availableroom+"','"+availableoptions+"','"+Priceoptions+"','"+bdtyp+"')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
