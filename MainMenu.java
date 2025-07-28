package Jobseekerapp;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainMenu extends JFrame implements ActionListener{
	 JFrame menu;
	 JButton op1,op2,op3,op4;
	public MainMenu(){
		//Background
		ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\option.jpg");
	    JLabel img = new JLabel(bg);
	    img.setLayout(null);
		menu = new JFrame();
		menu.setTitle("Choose Your Path");
		menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menu.setDefaultCloseOperation(0);
		menu.setContentPane(img);
		//Option 1
	    op1 = new JButton("Seeking a Job");
		op1.setBounds(500, 150, 700, 90);
	    op1.setFont(new Font("Arial", Font.BOLD, 50));
		op1.setBackground(Color.DARK_GRAY);
		op1.setForeground(Color.WHITE);
		op1.addActionListener(this);
		menu.add(op1);
		//Option 2
		op2 = new JButton("Already in a Job (Improve)");
		op2.setBounds(500, 300, 700, 90);
	    op2.setFont(new Font("Arial", Font.BOLD, 50));
		op2.setBackground(Color.DARK_GRAY);
		op2.setForeground(Color.WHITE);
		op2.addActionListener(this);
		menu.add(op2);
		//Option 3
		op3 = new JButton("I Don’t Know What To Do");
		op3.setBounds(500, 450, 700, 90);
	    op3.setFont(new Font("Arial", Font.BOLD, 50));
		op3.setBackground(Color.DARK_GRAY);
		op3.setForeground(Color.WHITE);
		op3.addActionListener(this);
		menu.add(op3);
		//Option 4
		op4 = new JButton("Exit");
		op4.setBounds(740, 600, 200, 80);
	    op4.setFont(new Font("Arial", Font.BOLD, 50));
		op4.setBackground(Color.DARK_GRAY);
		op4.setForeground(Color.WHITE);
		op4.addActionListener(this);
		menu.add(op4);
		menu.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == op1) {
			menu.dispose();
			new Register();
		}else if(e.getSource() == op2) {
			menu.dispose();
			new Register();
		}else if(e.getSource() == op3) {
			menu.dispose();
			new Register();
		}else if(e.getSource() == op4) {
			System.exit(0);
		}	
		
	}
}
