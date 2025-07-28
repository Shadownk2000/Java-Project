package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ResumeInput extends JFrame implements ActionListener {
	JFrame res;
	JLabel title, name, age, place, gender, contact, email, qualification, college, yearOfPassing, domain, skills, summary, expectation;
    JTextField namefield, placefield, contactfield, emailfield, qualificationfield, collegefield;
    JRadioButton male, female;
    JComboBox<String> domainBox, agebox, yearbox;
    JTextArea skillsArea, summaryArea, expectationArea;
    JButton subB;
    public static String userid;
    public ResumeInput(String userid) {
    	this.userid = userid;
    	ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\resume.jpg");
        JLabel img = new JLabel(bg);
        img.setLayout(null);
    	res = new JFrame();
        res.setTitle("Resume Information");
        res.setExtendedState(JFrame.MAXIMIZED_BOTH);
        res.setDefaultCloseOperation(EXIT_ON_CLOSE);
        res.setContentPane(img);
        Font font = new Font("Arial", Font.BOLD, 20);
        // Title
        title = new JLabel("Resume Submission");
        title.setBounds(560, 10, 400, 50);
        title.setFont(new Font("serif", Font.BOLD, 40));
        title.setForeground(Color.MAGENTA);
        res.add(title);
        // Name
        name = new JLabel("Full Name:");
        name.setBounds(200, 80, 150, 30);
        name.setFont(font);
        res.add(name);
        namefield = new JTextField();
        namefield.setBounds(400, 80, 200, 30);
        namefield.setFont(font);
        res.add(namefield);
        // Age
        age = new JLabel("Age:");
        age.setBounds(200, 160, 50, 30);
        age.setFont(font);
        res.add(age);
        String ages[] = {null,"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
        agebox = new JComboBox<String>(ages);
        agebox.setBounds(400, 160, 70, 40);
        agebox.setFont(new Font("TimesRoman", Font.BOLD, 20));
        res.add(agebox);
        //Place from
        place = new JLabel("Place:");
        place.setBounds(200, 240, 200, 30);
        place.setFont(font);
        res.add(place);
        placefield = new JTextField();
        placefield.setBounds(400, 240, 150, 30);
        res.add(placefield);
        //Gender
        gender = new JLabel("Gender:");
        gender.setBounds(200, 320, 200, 30);
        gender.setFont(font);
        res.add(gender);
        male = new JRadioButton("Male");
        male.setFont(font);
        male.setSelected(false);
        male.setBounds(400, 320, 80, 30);
        res.add(male);
        female = new JRadioButton("Female");
        female.setFont(font);
        female.setSelected(false);
        female.setBounds(500, 320, 100, 30);
        res.add(female);
        ButtonGroup genb = new ButtonGroup();
        genb.add(male);
        genb.add(female);
        //Personal info
        contact = new JLabel("Contact No:");
        contact.setBounds(200, 400, 150, 30);
        contact.setFont(font);
        res.add(contact);
        contactfield = new JTextField();
        contactfield.setBounds(400, 400, 200, 30);
        contactfield.setFont(font);
        res.add(contactfield);
        email = new JLabel("Email:");
        email.setBounds(200, 480, 200, 30);
        email.setFont(font);
        res.add(email);
        emailfield = new JTextField();
        emailfield.setBounds(400,480,200,30);
        emailfield.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        res.add(emailfield);
        // Education
        qualification = new JLabel("Qualification:");
        qualification.setBounds(200, 560, 200, 30);
        qualification.setFont(font);
        res.add(qualification);
        qualificationfield = new JTextField();
        qualificationfield.setBounds(400, 560,200,30);
        qualificationfield.setFont(font);
        res.add(qualificationfield);
        college = new JLabel("College/University:");
        college.setBounds(200, 640, 300, 30);
        college.setFont(font);
        res.add(college);
        collegefield = new JTextField();
        collegefield.setBounds(400, 640, 300, 30);
        collegefield.setFont(font);
        res.add(collegefield);
        yearOfPassing = new JLabel("Year Of Passing:");
        yearOfPassing.setBounds(200, 720, 200, 30);
        yearOfPassing.setFont(font);
        res.add(yearOfPassing);
        String years[]= {null,"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};
        yearbox = new JComboBox<String>(years);
        yearbox.setBounds(400, 720, 100, 30);
        yearbox.setFont(new Font("Arial", Font.BOLD, 20));
        res.add(yearbox);
        // Career Info
        domain= new JLabel("Domain:");
        domain.setBounds(800, 80, 150, 30);
        domain.setFont(font);
        res.add(domain);
        String domains[] = {null,"Software Development", "Digital Marketing", "Data Analysis", "UI/UX Design" };
        domainBox = new JComboBox<String>(domains);
        domainBox.setBounds(950, 80, 300, 40);
        domainBox.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        res.add(domainBox);
        skills = new JLabel("Key Skills:");
        skills.setBounds(800, 160, 200, 30);
        skills.setFont(font);
        res.add(skills);
        skillsArea = new JTextArea();
        skillsArea.setBounds(950, 160, 400, 150);
        skillsArea.setFont(new Font("TimesRoman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        res.add(skillsArea);
        summary = new JLabel("Summary");
        summary.setBounds( 800, 340, 200, 35);
        summary.setFont(new Font("TimesRoman", Font.BOLD, 30));
		summary.setForeground(Color.RED);
        res.add(summary);
        summaryArea = new  JTextArea();
        summaryArea.setBounds(800, 380, 550, 100);
        summaryArea.setFont(font);
        res.add(summaryArea);
        // Expectations
        expectation = new JLabel("Expectations:");
        expectation.setBounds(800, 580, 200, 30);
        expectation.setFont(new Font("serif", Font.BOLD, 30));
        expectation.setForeground(Color.GREEN);
        res.add(expectation);
        expectationArea = new JTextArea();
        expectationArea.setBounds(1000, 580, 350, 100);
        expectationArea.setFont(font);
        res.add(expectationArea);
        // Submit Button
        subB = new JButton("Submit");
        subB.setBounds(680, 750, 180, 50);
        subB.setFont(new Font("Arial", Font.BOLD, 30));
        subB.setBackground(Color.DARK_GRAY);
        subB.setForeground(Color.WHITE);
        res.add(subB);
        subB.addActionListener(this);
        res.setVisible(true);
    }
	public void actionPerformed(ActionEvent e) {
		String Userid = userid;
        String Name = namefield.getText();
        String Age = (String) agebox.getSelectedItem();
        String Place = placefield.getText();
        String Gender = null;
        if(male.isSelected()) {
			  Gender = male.getText();
	        }else{
	       	  Gender = female.getText();
	        }
        String Contact = contactfield.getText();
        String Email = emailfield.getText();
        String Qualification = qualificationfield.getText();
        String College = collegefield.getText();
        String Year = (String) yearbox.getSelectedItem();
        String Domain = (String) domainBox.getSelectedItem();
        String Skills = skillsArea.getText();
        String Summary = summaryArea.getText();
        if (Name.isEmpty() || Age.isEmpty() || Qualification.isEmpty()) {
            JOptionPane.showMessageDialog(res, "Please fill all mandatory fields.");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (userid, name, age, place, gender, contact, email, qualification, college, year, domain, skills, summary) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, Userid);
                ps.setString(2, Name);
                ps.setString(3, Age);
                ps.setString(4, Place);
                ps.setString(5, Gender);
                ps.setString(6, Contact);
                ps.setString(7, Email);
                ps.setString(8, Qualification);
                ps.setString(9, College);
                ps.setString(10, Year);
                ps.setString(11, Domain);
                ps.setString(12, Skills);
                ps.setString(13, Summary);
                ps.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(this, "Resume saved successfully!");
                res.dispose();
                new Dashboard(userid);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
