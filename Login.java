package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	JFrame log;
	JLabel userId, password;
    JTextField useridfield;
    JPasswordField Passwordfield;
    JButton logB;
    public Login() {
    	//Background
    	ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\desktop-wallpaper-plain-backgrounds-for-websites-plain-background.jpg");
	    JLabel img = new JLabel(bg);
	    img.setLayout(null);
    	log = new JFrame();
        log.setTitle("Login");
        log.setBounds(390, 150, 600, 400);
        log.setDefaultCloseOperation(EXIT_ON_CLOSE);
        log.setContentPane(img);
        //User Id
        userId = new JLabel("User ID:");
        userId.setBounds(90, 100, 120, 30);
        userId.setFont(new Font("Arial", Font.BOLD, 30));
        userId.setForeground(Color.WHITE);
        log.add(userId);
        useridfield = new JTextField();
        useridfield.setBounds(300, 100, 180, 30);
        log.add(useridfield);
        //Password
        password = new JLabel("Password:");
        password.setBounds(90, 150, 200, 30);
        password.setFont(new Font("Arial", Font.BOLD, 30));
        password.setForeground(Color.WHITE);
        log.add(password);
        Passwordfield = new JPasswordField();
        Passwordfield.setBounds(300, 150, 180, 30);
        log.add(Passwordfield);
        //Login Button
        logB = new JButton("Login");
        logB.setBounds(230, 220, 120, 40);
        logB.setFont(new Font("Arial", Font.BOLD, 20));
        logB.setBackground(Color.DARK_GRAY);
        logB.setForeground(Color.WHITE);
        logB.addActionListener(this);
        log.add(logB);
        log.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String userid = useridfield.getText();
        String password = new String(Passwordfield.getPassword());
        if (userid.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(log, "Please enter both fields.");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE userid = ? AND password = ?");
                ps.setString(1, userid);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(log, "Login Successful!");
                    con.close();
                    log.dispose();
                    String enteredUserid = useridfield.getText();
                    new ResumeInput(enteredUserid);
                } else {
                    JOptionPane.showMessageDialog(log, "Invalid credentials.");
                    con.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}