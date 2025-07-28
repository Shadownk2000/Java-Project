package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class PortfolioPage extends JFrame implements ActionListener {
    JFrame port;
    JLabel title;
    JTextArea resumearea;
    JButton backB, downloadB;
    public static String userid;
    public PortfolioPage(String userid) {
    	this.userid = userid;
    	//Frame
        port = new JFrame("Portfolio");
        port.setExtendedState(JFrame.MAXIMIZED_BOTH);
        port.setLayout(null);
        port.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Title
        title = new JLabel("User Portfolio");
        title.setBounds(660, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        port.add(title);
        //frame box
        resumearea = new JTextArea();
        resumearea.setBounds(400, 70, 680, 660);
        resumearea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        resumearea.setEditable(false);
        resumearea.setLineWrap(true);
        resumearea.setWrapStyleWord(true);
        resumearea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        port.add(resumearea);
        backB = new JButton("← Back");
        backB.setBounds(450, 740, 200, 40);
        backB.setBackground(Color.BLACK);
        backB.setForeground(Color.WHITE);
        backB.setFont(new Font("Arial", Font.BOLD, 24));
        port.add(backB);
        backB.addActionListener(this);
        loadResume(userid);
        port.setVisible(true);
    }

    public void loadResume(String userid) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume WHERE userid = ?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
        		String resumetitle = "\t  ───── Resume Summary ─────\n\n";
            	String labels[] = {"  Name", "  Age", "  Place", "  Gender", "  Contact", "  Email", "  Qualification", "  College", "  Year","  Domain", "  Skills", "  Summary"};
            	String data[] = {rs.getString("name"), rs.getString("age"), rs.getString("place"), rs.getString("gender"), rs.getString("contact"), rs.getString("email"), rs.getString("qualification"), rs.getString("college"), rs.getString("year"), rs.getString("domain"), rs.getString("skills"), rs.getString("summary")};
            		for (int i = 0; i < labels.length; i++) {
            		    resumetitle += labels[i] + ": " + data[i] + "\n";
            		}
            		resumearea.setText(resumetitle);
            } else {
                resumearea.setText("Resume not found for userid: " + userid);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backB) {
			port.dispose();
			new Dashboard(userid);
		}	
	}
}

