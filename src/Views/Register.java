package Views;
import javax.swing.*;

import controllers.CustomerManager;
import models.Customer;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame{
    Register() {
        //Declare UI components
        JLabel label1, label2,label3,label4,label5,label6,label7,label8,label9;
        JTextField t1,t2,t3,t4,t5;
        JPanel heading,Register;
        JPasswordField p1;
        JRadioButton male,female,others;
        JComboBox day,month,year,Paymentcombo;

        JButton Signup, Cancel;
        //font
        Font f = new Font("Serif", Font.BOLD, 40);

        // Create and add UI components to container panel

        heading = new JPanel();
        Color bg = new Color(0, 0, 0,100);
        heading.setBackground(bg);
        heading.setBounds(0, 0, 1000, 55);
        JLabel name = new JLabel("Register");
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

        //Register Panel
        Register = new JPanel();
        Register.setLayout(null);
        Register.setSize(400, 350);
        Register.setBackground(new Color(0, 0, 0,150));
        Register.setBounds(100, 100, 800, 500);

        label1=new JLabel("Name");
        label1.setBounds(50,30,100,20);
        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setForeground(Color.WHITE);
        Register.add(label1);

        label2=new JLabel("Contact");
        label2.setBounds(450,30,100,20);
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setForeground(Color.WHITE);
        Register.add(label2);

        label3=new JLabel("Email");
        label3.setBounds(50,100,100,20);
        label3.setFont(new Font("Arial", Font.PLAIN, 24));
        label3.setForeground(Color.WHITE);
        Register.add(label3);

        label4=new JLabel("Password");
        label4.setBounds(425,100,150,20);
        label4.setFont(new Font("Arial", Font.PLAIN, 24));
        label4.setForeground(Color.WHITE);
        Register.add(label4);

        label5 = new JLabel("Address");
        label5.setBounds(50,165,100,20);
        label5.setFont(new Font("Arial", Font.PLAIN, 22));
        label5.setForeground(Color.WHITE);
        Register.add(label5);

        label6 = new JLabel("Gender");
        label6.setBounds(50,220,100,20);
        label6.setFont(new Font("Arial", Font.PLAIN, 22));
        label6.setForeground(Color.WHITE);
        Register.add(label6);

        label7=new JLabel("DOB");
        label7.setBounds(50,275,100,20);
        label7.setFont(new Font("Arial", Font.PLAIN, 24));
        label7.setForeground(Color.WHITE);
        Register.add(label7);

        label8=new JLabel("Payment method");
        label8.setBounds(50,330,200,22);
        label8.setFont(new Font("Arial", Font.PLAIN, 22));
        label8.setForeground(Color.WHITE);
        Register.add(label8);

        label8=new JLabel("National id");
        label8.setBounds(425,165,200,22);
        label8.setFont(new Font("Arial", Font.PLAIN, 22));
        label8.setForeground(Color.WHITE);
        Register.add(label8);

        t1 = new JTextField();
        t1.setBounds(140,30,200,30);
        Register.add(t1);

        t2 = new JTextField();
        t2.setBounds(550,30,200,30);
        Register.add(t2);

        t3 = new JTextField();
        t3.setBounds(140,100,200,30);
        Register.add(t3);

        t4 = new JTextField();
        t4.setBounds(140,165,200,30);
        Register.add(t4);

        t5 = new JTextField();
        t5.setBounds(550,165,200,30);
        Register.add(t5);

        p1 = new JPasswordField();
        p1.setBounds(550,100,200,26);
        Register.add(p1);

        male=new JRadioButton("Male");
        male.setBounds(150,220,80,20);
        Register.add(male);

        female=new JRadioButton("Female");
        female.setBounds(250,220,80,20);
        Register.add(female);

        others=new JRadioButton("Others");
        others.setBounds(350,220,80,20);
        Register.add(others);

        ButtonGroup gen=new ButtonGroup();
        gen.add(male);
        gen.add(female);
        gen.add(others);

        String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String months[]={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        String years[]={"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998"};

        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        day.setBounds(150,275,50,20);
        month.setBounds(210,275,50,20);
        year.setBounds(270,275,60,20);

        String Paymentoptions[]={"Select","Credit Card","Esewa","Khalti"};
        Paymentcombo = new JComboBox(Paymentoptions);
        Paymentcombo.setBounds(280,325,150,30);
        Paymentcombo.setBackground(Color.WHITE);
        Register.add(Paymentcombo);

        Register.add(day);
        Register.add(month);
        Register.add(year);
        //frame
        setSize(1000, 700);
        setLayout(null);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Button
        Signup = new JButton("Sign Up");
        Signup.setBounds(250, 400, 100, 50);
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = t3.getText().trim();
                String password = new String(p1.getPassword());
                String contact = t2.getText().trim();
                String nationalId = t5.getText().trim();
                // Validate email address
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern emailPattern = Pattern.compile(emailRegex);
                Matcher emailMatcher = emailPattern.matcher(email);
                if (!emailMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Use correct Email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate national ID (SSN)
                String nationalIdRegex = "^[0-9]{3}-[0-9]{2}-[0-9]{4}$";
                Pattern nationalIdPattern = Pattern.compile(nationalIdRegex);
                Matcher nationalIdMatcher = nationalIdPattern.matcher(nationalId);
                if (!nationalIdMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Use correct National ID (SSN)", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password
                String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$";
                Pattern passwordPattern = Pattern.compile(passwordRegex);
                Matcher passwordMatcher = passwordPattern.matcher(password);
                if (!passwordMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //Validate contact
                String contactRegex = "^\\d{10}$";
                Pattern contactPattern = Pattern.compile(contactRegex);
                Matcher contactMatcher = contactPattern.matcher(contact);

                // Check if any of the fields are invalid
                if (!emailMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Use correct Email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!passwordMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!contactMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid contact information", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }else if (!nationalIdMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid contact information", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                // If both email and password are valid, close the Register window and open the Login window
                dispose();
                new Login();
            }
        });
        Register.add(Signup);
        Cancel = new JButton("Cancel");
        Cancel.setBounds(500, 400, 100, 50);
        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose(); // close the Login window
            }
        });
        Register.add(Cancel);
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customer user = new Customer();
                user.setCustomerName(t1.getText());
                user.setCustomerContact(t2.getText());
                user.setCustomerEmail(t3.getText());
                user.setCustomerPassword(p1.getText());
                user.setCustomerAddress(t4.getText());
                String dob = day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
                user.setCustomerDOB(dob);
                String gen = null;
                if (male.isSelected()) {
                    gen = "Male";
                } else if (female.isSelected()) {
                    gen = "Female";
                } else if (others.isSelected()) {
                    gen = "Others";
                }
                user.setCustomerGender(gen);

                user.setCustomerNationalid(t5.getText());
                user.setCustomerPaymentmethod((String) Paymentcombo.getSelectedItem());

                CustomerManager CustomerManager = new CustomerManager();
                boolean result = CustomerManager.insert(user);
                if (result == true) {
                    JOptionPane.showMessageDialog(null, "Successfully registered!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error in registration!");
                }
            }
        });


        //image
        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\second.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1400, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 700);

        add(Register);
        add(heading);
        add(background);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}