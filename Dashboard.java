package Jobseekerapp;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    JFrame home;
    JLabel title;
    JButton portB,introB,quesB,taskB,logregB,logB,regB,backB;
    JPanel logreg;
    String userid;
    public Dashboard(String userid) {
    	this.userid = userid;
    	ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\home.jpg");
    	JLabel img = new JLabel(bg);
    	img.setLayout(null);
        home = new JFrame("Career Dashboard");
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setContentPane(img);
        //Title
        title = new JLabel("User Dashboard");
        title.setBounds(550, 100, 360, 50);
        title.setFont(new Font("Impact", Font.BOLD,50));
        title.setBorder(new TitledBorder(""));
        title.setForeground(Color.WHITE);
        home.add(title);
        Font font = new Font("Futura", Font.BOLD, 30);   
        //Portfolio
        portB = new JButton("Portfolio");
        portB.setBackground(Color.BLACK);
        portB.setForeground(Color.WHITE);
        portB.setBounds(50, 200, 400, 200);
        portB.setFont(font);
        home.add(portB);
        portB.addActionListener(this);
        //Self-Intro
        introB = new JButton("Self Introduction");
        introB.setBounds(550, 200, 400, 200);
        introB.setBackground(Color.BLACK);
        introB.setForeground(Color.WHITE);
        introB.setFont(font);
        home.add(introB);
        introB.addActionListener(this);
        //Interview Questions
        quesB = new JButton("Interview Questions");
        quesB.setBounds(1050, 200, 400, 200);
        quesB.setBackground(Color.BLACK);
        quesB.setForeground(Color.WHITE);
        quesB.setFont(font);
        home.add(quesB);
        quesB.addActionListener(this);
        //Daily Tasks
        taskB = new JButton("Tasks");
        taskB.setBounds(300, 500, 400, 200);
        taskB.setBackground(Color.BLACK);
        taskB.setForeground(Color.WHITE);
        taskB.setFont(font);
        home.add(taskB);
        taskB.addActionListener(this);
        //Login & Register
        logregB = new JButton("Login & Register");
        logregB.setBounds(800, 500, 400, 200);
        logregB.setBackground(Color.BLACK);
        logregB.setForeground(Color.WHITE);
        logregB.setFont(font);
        home.add(logregB);
        logregB.addActionListener(this);
        home.setVisible(true);
        logreg = new JPanel();
        logreg.setBounds(500, 200, 500, 400);
        logreg.setBackground(Color.DARK_GRAY);
        logreg.setForeground(Color.WHITE);
        logreg.setLayout(null);
        logreg.setBorder(new TitledBorder("Login & Register"));
        logreg.setVisible(false);
        home.add(logreg);
        regB = new JButton("Register");
        regB.setBounds(130, 100, 230, 70);
        regB.setBackground(Color.BLACK);
        regB.setForeground(Color.WHITE);
        regB.setFont(new Font("Futura", Font.BOLD, 40));
        regB.setVisible(false);
        logreg.add(regB);
        regB.addActionListener(this);
        logB = new JButton("Login");
        logB.setBounds(130, 250, 230, 70);
        logB.setBackground(Color.BLACK);
        logB.setForeground(Color.WHITE);
        logB.setFont(new Font("Futura", Font.BOLD, 40));
        logB.setVisible(false);
        logreg.add(logB);
        logB.addActionListener(this);   
        // Back Button
        backB = new JButton("← Back");
        backB.setBounds(40, 350, 150, 30);
        backB.setBackground(Color.white);
        backB.setForeground(Color.black);
        backB.setFont(new Font("Arial", Font.BOLD, 14));
        backB.setVisible(false);
        backB.addActionListener(this);
        logreg.add(backB);
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == portB) {
			home.dispose();
			new PortfolioPage(userid);
		}else if(e.getSource() == introB) {
			home.dispose();
			new SelfIntroPage(userid);
		}else if(e.getSource() == quesB) {
			home.dispose();
			new InterviewPage(userid);
		}else if(e.getSource() == taskB) {
			home.dispose();
			new TaskPage(userid);
		}else if(e.getSource() == logregB) {
			logreg.setVisible(true);
			regB.setVisible(true);
			logB.setVisible(true);
			backB.setVisible(true);
			title.setVisible(false);
			portB.setVisible(false);
			introB.setVisible(false);
			quesB.setVisible(false);
			taskB.setVisible(false);
			logregB.setVisible(false);
		} else if(e.getSource() == regB) {
			home.dispose();
			new Register();
		}else if(e.getSource() == logB) {
			home.dispose();
			new Login();
	}else if(e.getSource() == backB) {
        home.dispose();
        new Dashboard(userid);
    }
}
}