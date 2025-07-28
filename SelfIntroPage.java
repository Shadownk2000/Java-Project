package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SelfIntroPage extends JFrame implements ActionListener {
    JFrame intro;
    JLabel title;
    JTextArea introArea;
    JButton backB;
    public static String userid;
    public SelfIntroPage(String userid) {
        this.userid = userid;
        // Frame setup
        intro = new JFrame("Self Introduction");
        intro.setExtendedState(JFrame.MAXIMIZED_BOTH);
        intro.setLayout(null);
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Title
        title = new JLabel("Self Introduction");
        title.setBounds(660, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        intro.add(title);
        // Self-Intro box
        introArea = new JTextArea();
        introArea.setBounds(400, 70, 680, 660);
        introArea.setFont(new Font("Monospaced", Font.PLAIN, 24));
        introArea.setLineWrap(true);
        introArea.setWrapStyleWord(true);
        introArea.setEditable(false);
        introArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        intro.add(introArea);
        // Back button
        backB = new JButton("← Back");
        backB.setBounds(450, 740, 200, 40);
        backB.setBackground(Color.BLACK);
        backB.setForeground(Color.WHITE);
        backB.setFont(new Font("Arial", Font.BOLD, 24));
        backB.addActionListener(this);
        intro.add(backB);
        loadIntro();
        intro.setVisible(true);
    }
    public void loadIntro() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
            PreparedStatement ps = conn.prepareStatement("SELECT name, place, college, qualification, domain FROM resume WHERE userid = ?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String place = rs.getString("place");
                String college = rs.getString("college");
                String qualification = rs.getString("qualification");
                String domain = rs.getString("domain");
                String base = "I’m " + name + " from " + place + ". I completed my " + qualification
                        + " at " + college + ", specializing in " + domain + ". ";
                String intro = null;
                switch (domainChoice(domain)) {
                    case 1: 
                    	intro = base + "I enjoy building scalable applications and solving real-world challenges through code.";
                    	break;
                    case 2:
                    	intro = base + "I’m passionate about brand strategy, engagement, and data-driven digital campaigns.";
                    	break;
                    case 3:
                    	intro = base + "I love diving into structured data to extract insights that shape smart decisions.";
                    	break;
                    case 4:
                    	intro = base + "I’m inspired by intuitive design, user empathy, and building seamless digital experiences.";
                    	break;
                }
                introArea.setText(intro);
            } else {
                introArea.setText("Unable to generate introduction: resume data missing.");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int domainChoice (String domain) {
  	  int choose = 0;
  	  if(domain.equals("Software Development")) {
  		  choose = 1;
  	  }else if(domain.equals("Digital Marketing")) {
  		  choose = 2;
  	  }else if(domain.equals("Data Analysis")) {
  		  choose = 3;
  	  }else if(domain.equals("UI/UX Design")) {
  		  choose = 4;
  	  }
  	  return choose;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backB) {
            intro.dispose();
            new Dashboard(userid);
        }
    }
}