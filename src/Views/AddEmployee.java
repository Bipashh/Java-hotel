package Views;
import controllers.Conn;
import java.util.UUID;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    // Declare all the GUI components and variables that we will use
    JLabel label1,label2,label3,label4,label5,label6,label7;
    JTextField Name,Age,Email,PhoneNo,Nationalid;
    JRadioButton male,female,others;
    JComboBox Post;
    JButton Submit;
    public AddEmployee() {//Constructor
        setLayout(null); // Set the layout to null

        // Create a label for the name field, set its bounds, font, and add it to the frame
        label1 = new JLabel("Name");
        label1.setBounds(60, 30, 120, 30);
        label1.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label1);

        // Create a text field for the name, set its bounds, and add it to the frame
        Name = new JTextField();
        Name.setBounds(200, 30, 150, 30);
        add(Name);

        // Repeat the above process for all other fields and components, setting their bounds, fonts, and adding them to the frame
        label2 = new JLabel("Age");
        label2.setBounds(60, 80, 120, 30);
        label2.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label2);

        // Create a text field for the age and add it to the frame
        Age = new JTextField();
        Age.setBounds(200, 80, 150, 30);
        add(Age);

        // Create a label with text "Gender" and add it to the frame
        label3 = new JLabel("Gender");
        label3.setBounds(60, 130, 120, 30);
        label3.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label3);

        // Create radio buttons for gender selection and add them to the frame
        male = new JRadioButton("Male");
        male.setBounds(200, 135, 80, 20);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 135, 80, 20);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(400, 135, 80, 20);
        add(others);

        // Create a button group for the radio buttons and add them to the group
        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);
        gen.add(others);

        // Create a combo box with various post options and add it to the frame// Create a combo box with various post options and add it to the frame
        label4 = new JLabel("Post");
        label4.setBounds(60, 180, 120, 30);
        label4.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label4);
        String str[] = {"Select Post", "General Manager", "Receptionist", "Housekeeping", "Hotel Clerk", "Kitchen Staff", "Chef", "Waiter", "Attendant"};
        Post = new JComboBox(str);
        Post.setBounds(200, 180, 150, 30);
        add(Post);

        label5 = new JLabel("Email");
        label5.setBounds(60, 230, 120, 30);
        label5.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label5);
        Email = new JTextField();
        Email.setBounds(200, 230, 150, 30);
        add(Email);

        label6 = new JLabel("PhoneNo");
        label6.setBounds(60, 280, 120, 30);
        label6.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label6);
        PhoneNo = new JTextField();
        PhoneNo.setBounds(200, 280, 150, 30);
        add(PhoneNo);

        label7 = new JLabel("National ID");
        label7.setBounds(60, 330, 120, 30);
        label7.setFont(new Font("Verdana", Font.PLAIN, 17));
        add(label7);

        Nationalid = new JTextField();
        Nationalid.setBounds(200, 330, 150, 30);
        add(Nationalid);

        Submit = new JButton("Submit");
        Submit.setBounds(250, 430, 150, 30);
        Submit.addActionListener(this);
        add(Submit);

        // Creating a new ImageIcon object using the image file path and name
        ImageIcon image1 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\second.jpg");
        Image img = image1.getImage();
        Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        image1 = new ImageIcon(temp_img);
        JLabel backgroundLabel = new JLabel("", image1, JLabel.CENTER);
        backgroundLabel.setBounds(450, 0, 400, 550);
        add(backgroundLabel);

        getContentPane().setBackground(Color.lightGray);
        setBounds(280, 200, 850, 540);
        setVisible(true);
    }

        public void actionPerformed (ActionEvent ae){
            // Getting the employee details from the text fields and radio buttons
            String name = Name.getText();
            String age = Age.getText();
            String email = Email.getText();
            String phoneno = PhoneNo.getText();
            String nationalid = Nationalid.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (others.isSelected()) {
                gender = "Others";
            }
            String post = (String) Post.getSelectedItem();
            try {
                // Creating a new database connection object
                Conn conn = new Conn();
                // Creating an SQL query string to insert the employee details into the database
                String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + post + "','" + email + "','" + phoneno + "','" + nationalid + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee add Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            public static void main (String[]args){
                new AddEmployee();
            }
        }