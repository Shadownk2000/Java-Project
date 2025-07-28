package Jobseekerapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class TaskPage extends JFrame implements ActionListener {
    JFrame task;
    JLabel title;
    JButton backB;
    JCheckBox taskBox[];
    String userid;
    String domain;
    String todayTasks[];
    public TaskPage(String userid) {
        this.userid = userid;
        task = new JFrame("Daily Career Tasks");
        task.setExtendedState(JFrame.MAXIMIZED_BOTH);
        task.setLayout(null);
        task.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Title
        title = new JLabel("Today's Tasks");
        title.setBounds(600, 40, 400, 50);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        task.add(title);
        // Back Button
        backB = new JButton("← Back");
        backB.setBounds(640, 700, 200, 40);
        backB.setBackground(Color.BLACK);
        backB.setForeground(Color.WHITE);
        backB.setFont(new Font("Arial", Font.BOLD, 24));
        backB.addActionListener(this);
        task.add(backB);
        loadDomainAndTasks();
        task.setVisible(true);
    }
    public void loadDomainAndTasks() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobseeker", "root", "1212");
            PreparedStatement ps = conn.prepareStatement("SELECT domain FROM resume WHERE userid = ?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                domain = rs.getString("domain");
                loadCheckboxTasks();
            } else {
                JOptionPane.showMessageDialog(task, "Domain not found. Please submit your resume.");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCheckboxTasks() {
        todayTasks = generateTasks(domain);
        taskBox = new JCheckBox[todayTasks.length];
        for (int i = 0; i < todayTasks.length; i++) {
            taskBox[i] = new JCheckBox( todayTasks[i]);
            taskBox[i].setFont(new Font("Monospaced", Font.PLAIN, 22));
            taskBox[i].setBounds(520, 120 + i * 60, 500, 40);
            task.add(taskBox[i]);
        }
    }
    public String[] generateTasks(String domain) {
        if (domain.equalsIgnoreCase("Software Development")) {
            return new String[]{ "Write loop", "Use if", "Create array", "Reverse string" };
        } else if (domain.equalsIgnoreCase("Digital Marketing")) {
            return new String[]{ "Search keywords", "Plan post", "Write caption", "Check CTR" };
        } else if (domain.equalsIgnoreCase("Data Analysis")) {
            return new String[]{ "Clean rows", "Find max value", "Draw chart", "Select in SQL" };
        } else if (domain.equalsIgnoreCase("UI/UX Design")) {
            return new String[]{ "Sketch login", "Choose color", "Place icons", "Fix layout" };
        } else {
            return new String[]{ "Reflect on goal", "Note strength", "Read career tip", "List achievements" };
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backB) {
            task.dispose();
            new Dashboard(userid);
        }
    }
}