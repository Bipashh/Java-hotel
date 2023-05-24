package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends JFrame{
    Login() {
        // Labels, buttons, and text fields used in the Login window
        JLabel label1,label2,label3;
        JButton login,Signup;
        JTextField t1;
        JPasswordField t2;
        // Font used in the Login window
        Font f = new Font("Serif", Font.BOLD, 40);

        // Header panel at the top of the Login window
        JPanel heading = new JPanel();
        Color bg = new Color(0, 0, 0, 80);
        heading.setBackground(bg);
        heading.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Hotel Luton");
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

        // Login panel in the middle of the Login window
        JPanel Login = new JPanel();
        Login.setLayout(null);
        Login.setSize(400, 350);
        Login.setBackground(new Color(255, 255, 255, 255));
        Login.setBounds(150, 150, 700, 450);

        // Email label and text field
        label1=new JLabel("Email:");
        label1.setBounds(100,100,100,20);
        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setForeground(Color.BLACK);
        Login.add(label1);

        t1 = new JTextField();
        t1.setBounds(250,100,250,30);
        Login.add(t1);

        // Password label and text field
        label2=new JLabel("Password:");
        label2.setBounds(100,200,250,20);
        label2.setFont(new Font("Arial", Font.PLAIN, 22));
        label2.setForeground(Color.BLACK);
        Login.add(label2);

        t2 = new JPasswordField();
        t2.setBounds(250,200,250,30);
        Login.add(t2);

        // Login page label
        label3= new JLabel("Login Page");
        label3.setBounds(270,0,250,30);
        label3.setFont(new Font("Arial", Font.PLAIN, 26));
        label3.setForeground(Color.BLACK);
        Login.add(label3);


        // Set properties of the Login window
        setSize(1000, 700);
        setLayout(null);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Login Button
        login = new JButton("Login");
        login.setBounds(175, 300, 100, 50);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get email and password entered by the user
                String email = t1.getText().trim();
                String password = new String(t2.getPassword());

                // Validate email address using regular expression
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern emailPattern = Pattern.compile(emailRegex);
                Matcher emailMatcher = emailPattern.matcher(email);
                if (!emailMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password using regular expression
                String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$";
                Pattern passwordPattern = Pattern.compile(passwordRegex);
                Matcher passwordMatcher = passwordPattern.matcher(password);
                if (!passwordMatcher.matches()) {
                    JOptionPane.showMessageDialog(null, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // If both email and password are valid, close the Login window and open the appropriate page
                dispose();
                if(email.equals("admin@gmail.com") && password.equals("Admin@123")) {
                    new DashBoard();
                } else {
                    new Customerpg();
                }
            }
        });
        Login.add(login);
        Signup = new JButton("SignUp");
        Signup.setBounds(375, 300, 100, 50);
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Register window and close the Login window
                new Register();
                dispose(); // close the Login window
            }
        });
        Login.add(Signup);

        // Add image to login panel
        ImageIcon background_image1 = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\Profile Icon Silhouette PNG Transparent, Avatar Icon Profile Icon Member Login Vector Isolated, Login Icons, Profile Icons, Avatar Icons PNG Image For Free Download.jpg");
        Image img1 = background_image1.getImage();
        Image temp_img1 = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        background_image1 = new ImageIcon(temp_img1);
        JLabel background1 = new JLabel("", background_image1, JLabel.CENTER);
        background1.setBounds(450, 0, 300, 250);
        Login.add(background1);
        ImageIcon background_image = new ImageIcon("E:\\New folder\\HotelBookingsys\\out\\second.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        //Add background image to window
        background.add(Login);
        background.add(heading);
        background.setBounds(0, 0, 1000, 700);
        add(background);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}


