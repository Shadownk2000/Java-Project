package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Register extends JFrame implements ActionListener {
	JFrame reg;
	JLabel name, userId, password;
	JTextField namefield, useridfield;
	JPasswordField Passwordfield;
	JButton regB;
	public Register() {
		//Background
		ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\reg2.jpg");
	    JLabel img = new JLabel(bg);
	    img.setLayout(null);
		reg = new JFrame();
	    reg.setTitle("User Registration");
	    reg.setBounds(390, 150, 600, 620);
	    reg.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    reg.setContentPane(img);
	    //User Name
	    name = new JLabel("Full Name:");
	    name.setBounds(90, 100, 200, 30);
	    name.setFont(new Font("Arial", Font.BOLD, 30));
	    name.setForeground(Color.WHITE);
	    reg.add(name);
	    namefield = new JTextField();
	    namefield.setBounds(280, 100, 200, 30);
	    reg.add(namefield);
	    //User Id
	    userId = new JLabel("User ID:");
	    userId.setBounds(90, 150, 200, 30);
	    userId.setFont(new Font("Arial", Font.BOLD, 30));
	    userId.setForeground(Color.WHITE);
	    reg.add(userId);
	    useridfield = new JTextField();
	    useridfield.setBounds(280, 150, 200, 30);
	    reg.add(useridfield);
	    //Password
	    password = new JLabel("Password:");
	    password.setBounds(90, 200, 200, 30);
	    password.setFont(new Font("Arial", Font.BOLD, 30));
	    password.setForeground(Color.WHITE);
	    reg.add(password);
	    Passwordfield = new JPasswordField();
	    Passwordfield.setBounds(280, 200, 200, 30);
	    reg.add(Passwordfield);
	    //Register Button
	    regB = new JButton("Register");
	    regB.setBounds(230, 320, 150, 40);
	    regB.setFont(new Font("Arial", Font.BOLD, 20));
	    regB.setBackground(Color.DARK_GRAY);
	    regB.setForeground(Color.WHITE);
	    regB.addActionListener(this);  
	    reg.add(regB);
	    reg.setVisible(true);
	 }
	public void actionPerformed(ActionEvent e) {
			 String name = namefield.getText();
	         String userId = useridfield.getText();
	         String password = new String(Passwordfield.getPassword());
	         if (name.isEmpty() || userId.isEmpty() || password.isEmpty()) {
	             JOptionPane.showMessageDialog(reg, "Please fill all fields.");
	         }
	         else {
	        	 try {
	                 Class.forName("com.mysql.cj.jdbc.Driver");
	                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
	                 PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, userid, password) VALUES (?, ?, ?)");
	                 ps.setString(1, name);
	                 ps.setString(2, userId);
	                 ps.setString(3, password);
	                 ps.executeUpdate();
	                 con.close();
	                 JOptionPane.showMessageDialog(reg, "Registration Successful!");
	                 reg.dispose();
	                 new Login(); 
	             } catch (Exception e1) {
	                 e1.printStackTrace();
	           } 
	     }
	}
}
