package Jobseekerapp;
import java.awt.*;
import javax.swing.*;

public class Welcome extends JFrame implements  Runnable {
	JFrame wel;
	JLabel title;
	public Welcome(){
		// BACKGROUND
        ImageIcon bg = new ImageIcon("D:\\project\\JavaProject\\Business-High-Resolution-Wallpapers-1920x1080.jpg");
        JLabel img = new JLabel(bg);
        img.setLayout(null);
		 wel = new JFrame();
		wel.setTitle("Welcome to Job Seeker App");
		wel.setExtendedState(JFrame.MAXIMIZED_BOTH);
		wel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		wel.setContentPane(img);
		wel.setVisible(true);
	}
		public void run(){
			//Welcome page
		 title = new JLabel("Welcome to Job Seeker Assistant");
		    title.setBounds(100, 250, 1300, 200);
		    title.setFont(new Font("TimeRoman", Font.BOLD, 80));
			title.setForeground(Color.black);
			title.setVisible(true);
			wel.add(title);
			try {
				Thread.sleep(2500);
				wel.dispose();
				new MainMenu();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		Welcome w = new Welcome();
		Thread t = new Thread(w);
		t.start();
	}	
}
