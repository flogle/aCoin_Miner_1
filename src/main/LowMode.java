package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import data.User;
import db.SQL;

public class LowMode implements ActionListener {
	
	public class ThreadMine implements Runnable {
		
		private JLabel currAcoins;
		private double acoins;
		private byte tick;

		public ThreadMine(JLabel currAcoins) {
			
			this.currAcoins = currAcoins;
			this.acoins = 0.0;
			this.tick = 0;
			
		}
		
		public double getAcoins() {
			
			return this.acoins;
			
		}
		
		@Override
		public void run() {
			
			while (true) {
				
				this.tick++;
				
				if (this.tick > 60) {
					
					this.tick = 0;
					
				}
				
				this.acoins += 0.025;
				
				
				
				this.currAcoins.setText("aCoins: " + this.acoins);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				
			}
			
			
		}

	}

	private JFrame frame;
	private JLabel title;
	private JLabel currAcoins;
	private JButton claimBtn;
	private ThreadMine threadMine;
	
    private User userData;
	
	public LowMode(User userData) {
		
    	this.userData = userData;
    	
    	this.frame = new JFrame();
    	this.title = new JLabel("Low mode mine");
    	this.currAcoins = new JLabel("aCoins: 0");
    	this.claimBtn = new JButton("Claim aCoin!");
    	
    	this.threadMine = new LowMode.ThreadMine(this.currAcoins);
    	
        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
    	
        this.title.setBounds(25, 25, 350, 30);
    	this.title.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 25f));
        
    	
    	this.currAcoins.setBounds(25, 75, 400, 35);
    	this.currAcoins.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 20f));

    	
    	this.claimBtn.setBounds(50, 200, 150, 30);
    	this.claimBtn.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));
    	this.claimBtn.addActionListener(this);
    	
        
        this.frame.add(this.title);
        this.frame.add(this.currAcoins);
        this.frame.add(this.claimBtn);
        
    	
    	
        this.frame.setVisible(true);
        
        Thread thread = new Thread(this.threadMine);
        
        thread.setDaemon(false);
        
        thread.start();
    	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(this.claimBtn)) {
			
			this.claimBtn.setEnabled(false);
			
			SQL sql = new SQL();
			
			if (sql.addAcoins(this.userData.getId(), this.threadMine.getAcoins())) {
				
	            JOptionPane.showMessageDialog(this.frame, "Your aCoin has been claimed!", "Success", JOptionPane.PLAIN_MESSAGE);

	            System.exit(0);
				
			} else {
				
	            JOptionPane.showMessageDialog(this.frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);

	            System.exit(0);
				
			}
			
			
			
			
		}
		
		
		
	}
	
	
	

}
