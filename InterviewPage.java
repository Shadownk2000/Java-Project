package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class InterviewPage extends JFrame implements ActionListener {
    JFrame ques;
    JLabel title;
    JTextArea questionArea;
    JButton backB;
    String userid;
    public InterviewPage(String userid) {
        this.userid = userid;
        // Frame
        ques = new JFrame("Interview Preparation");
        ques.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ques.setLayout(null);
        ques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Title
        title = new JLabel("Top Interview Questions");
        title.setBounds(600, 20, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        ques.add(title);
        // Question area
        questionArea = new JTextArea();
        questionArea.setBounds(400, 70, 680, 660);
        questionArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        ques.add(questionArea);
        // Back button
        backB = new JButton("← Back");
        backB.setBounds(450, 740, 200, 40);
        backB.setBackground(Color.BLACK);
        backB.setForeground(Color.WHITE);
        backB.setFont(new Font("Arial", Font.BOLD, 24));
        backB.addActionListener(this);
        ques.add(backB);
        loadQuestions();
        ques.setVisible(true);
    }
    public void loadQuestions() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
            PreparedStatement ps = conn.prepareStatement("SELECT domain FROM resume WHERE userid = ?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String domain = rs.getString("domain");
                String output = null;
                switch (domainChoice(domain)) {
                case 1: 
                	output = "\t  ───── Must-Know Questions ─────\n\n"+" 1. What are the four pillars of OOP?\n"+
                            " 2. Difference between Stack and Heap memory?\n"+
                            " 3. What is exception handling in Java?\n"+
                            " 4. How does RESTful API work?\n"+
                            " 5. Explain Git and GitHub usage.\n"+
                            " 6. What is SQL Injection?\n"+
                            " 7. What is a constructor?\n"+
                            " 8. What’s the difference between ArrayList and LinkedList?\n"+
                            " 9. Describe method overloading vs overriding.\n"+
                            " 10. What is the role of backend development?";
                	break;
                case 2:
                	output = "\t  ───── Must-Know Questions ─────\n\n"+" 1. What is SEO and why is it important?\n"+
                            " 2. Explain PPC with examples.\n"+
                            " 3. What’s a customer persona?\n"+
                            " 4. How do Google Ads work?\n"+
                            " 5. Role of content in digital campaigns?\n"+
                            " 6. Difference between organic and paid traffic?\n"+
                            " 7. How to measure campaign success?\n"+
                            " 8. What is CTR and how is it calculated?\n"+
                            " 9. Tools for tracking engagement?\n"+
                            " 10. What’s the latest social media trend?";
                	break;
                case 3:
                	output = "\t  ───── Must-Know Questions ─────\n\n"+ " 1. What is a pivot table?\n"+
                            " 2. Difference between correlation and causation?\n"+
                            " 3. What are missing values and how to handle them?\n"+
                            " 4. Common tools for visualization?\n"+
                            " 5. Explain basic SQL queries used in reports.\n"+
                            " 6. What is data cleaning?\n"+
                            " 7. What is standard deviation?\n"+
                            " 8. When to use histograms?\n"+
                            " 9. How to validate accuracy in data?\n"+
                            " 10. What’s your process for interpreting results?";
                	break;
                case 4:
                	output = "\t  ───── Must-Know Questions ─────\n\n"+  "1. Difference between UI and UX?\n"+
                            "2. What is a wireframe and how is it used?\n"+
                            "3. Explain user-centered design.\n"+
                            "4. What tools are best for prototyping?\n"+
                            "5. What is responsive design?\n"+
                            "6. How to conduct usability testing?\n"+
                            "7. Importance of typography?\n"+
                            "8. What are accessibility standards?\n"+
                            "9. How do you implement visual hierarchy?\n"+
                            "10. Describe feedback handling in UI teams.";
                	break;
            }
                questionArea.setText(output);
            } else {
                questionArea.setText("Interview questions unavailable: resume missing.");
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
            ques.dispose();
            new Dashboard(userid);
        }
    }
}