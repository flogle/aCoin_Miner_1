package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import data.ACoinUserData;
import data.User;

public class MineDash implements ActionListener {
    
    private JFrame frame;
    private JLabel title;
    private JLabel hiThere;
    private JLabel acoinCount;
    private JLabel islockedMess;
    private JLabel isadminMess;
    private JButton defaultMineBTN;
    private JButton displayModeMineBTN;
    private JButton lowModeMineBTN;
    
    private User userData;
    private ACoinUserData aCoinUserData;

    
    
    public MineDash(User userData, ACoinUserData aCoinUserData) {
    	
    	this.userData = userData;
    	this.aCoinUserData = aCoinUserData;
    	
    	this.frame = new JFrame();
    	this.title = new JLabel("Mine Dash");
    	this.hiThere = new JLabel(String.format("Hello, %s!", this.userData.getUsername()));
    	this.acoinCount = new JLabel(String.valueOf(this.aCoinUserData.getAcoins()));
    	this.islockedMess = new JLabel(this.aCoinUserData.isLocked() ? "This user is locked" : "This user is unlocked");
    	this.isadminMess = new JLabel(this.aCoinUserData.isAdmin() ? "This user is an admin" : "This user is not an admin");
    	this.defaultMineBTN = new JButton("Mine");
    	this.displayModeMineBTN = new JButton("Display Mode Mine");
    	this.lowModeMineBTN = new JButton("Low Mode mine");
    	
    	
        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
    	
        this.title.setBounds(25, 25, 250, 30);
    	this.title.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 25f));
    	
    	
    	this.hiThere.setBounds(175, 25, 220, 30);
    	this.hiThere.setFont(ACoinApp.FONT.deriveFont(Font.PLAIN, 25f));
    	
    	
    	this.acoinCount.setBounds(25, 75, 470, 32);
    	this.acoinCount.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 25f));
    	
    	this.islockedMess.setBounds(25, 425, 150, 32);
    	this.islockedMess.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	
    	this.isadminMess.setBounds(350, 425, 150, 32);
    	this.isadminMess.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	
    	this.defaultMineBTN.setBounds(200, 200, 100, 32);
    	this.defaultMineBTN.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	this.defaultMineBTN.addActionListener(this);
    	
    	this.displayModeMineBTN.setBounds(75, 250, 150, 32);
    	this.displayModeMineBTN.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	this.displayModeMineBTN.addActionListener(this);
    	
    	this.lowModeMineBTN.setBounds(300, 250, 150, 32);
    	this.lowModeMineBTN.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	this.lowModeMineBTN.addActionListener(this);
    	
    	
    	this.frame.add(this.title);
    	this.frame.add(this.hiThere);
    	this.frame.add(this.acoinCount);
    	this.frame.add(this.islockedMess);
    	this.frame.add(this.isadminMess);
    	this.frame.add(this.defaultMineBTN);
    	this.frame.add(this.displayModeMineBTN);
    	this.frame.add(this.lowModeMineBTN);
    	
    	
    	this.frame.setVisible(true);
    	
    	
    	
    }



	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		
		
	}
    
    
    
}
