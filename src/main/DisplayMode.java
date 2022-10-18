package main;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import data.ACoinUserData;
import data.User;

public class DisplayMode {
	
	private JFrame frame;
	private JLabel title;
	private JLabel currAcoins;
	private JButton lowModeBTN;
	private JButton claimBtn;
	private JProgressBar currBar;
	
    private User userData;
    private ACoinUserData aCoinUserData;
	
	public DisplayMode(User userData, ACoinUserData aCoinUserData) {
		
    	this.userData = userData;
    	this.aCoinUserData = aCoinUserData;
    	
    	this.frame = new JFrame();
    	this.title = new JLabel("Display mode mine");
    	
        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
    	
        this.title.setBounds(25, 25, 350, 30);
    	this.title.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 25f));
        
        
        this.frame.add(this.title);
    	
    	
        this.frame.setVisible(true);
    	
		
	}
	

}
