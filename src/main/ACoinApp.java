package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data.ACoinData;
import data.ACoinUserData;
import data.User;
import db.SQL;
import ptdfj.PTDFJHandlerString;

public class ACoinApp implements ActionListener {

    public static SQL sqlH = new SQL();
    public static Font FONT;
    public static final String VERSION = "1.1"; 
    
    
    private JFrame frame;
    private JLabel loadFileText;
    private JTextField mineCodeINE;
    private JButton loadMineCodeBTNE;
    

    public ACoinApp() {


        try {

            ACoinApp.FONT = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/Roboto-Thin.ttf"));

        } catch (Exception e) {

            e.printStackTrace();

        }
        
        ACoinData aCoinData = ACoinApp.sqlH.getACoinData();
        
        if (!aCoinData.getCurrent_app_version().equals(ACoinApp.VERSION)) {
        	
        	
            JOptionPane.showMessageDialog(this.frame, "Error this app version is not up to date!", "Error", JOptionPane.ERROR_MESSAGE);

            System.exit(0);
        		
        	
        }
        
        if (!aCoinData.isCanMine()) {
        	
        	
            JOptionPane.showMessageDialog(this.frame, "You can not mine aCoin right now!", "Error", JOptionPane.WARNING_MESSAGE);

            System.exit(0);
        	
        	
        }
        

        this.frame = new JFrame();
        this.loadFileText = new JLabel("Enter your aCoin mine app code");
        this.mineCodeINE = new JTextField();
        this.loadMineCodeBTNE = new JButton("Load");

        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        this.loadFileText.setBounds(60, 50, 375, 30);
        this.loadFileText.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 25f));


        this.mineCodeINE.setBounds(100, 200, 250, 32);
        
        this.loadMineCodeBTNE.setFont(ACoinApp.FONT.deriveFont(Font.BOLD, 12f));

        this.loadMineCodeBTNE.setBounds(100, 250, 250, 32);
        this.loadMineCodeBTNE.addActionListener(this);


        this.frame.add(this.loadFileText);
        this.frame.add(this.mineCodeINE);
        this.frame.add(this.loadMineCodeBTNE);


        this.frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(this.loadMineCodeBTNE)) {

            try {

                String tString = new String(Base64.getDecoder().decode(this.mineCodeINE.getText()));

                PTDFJHandlerString dataH = new PTDFJHandlerString(tString);

                long userID =  Long.parseLong(dataH.get("user_id"));
                long acoinID = Long.parseLong(dataH.get("acoin_id"));

                User userData = ACoinApp.sqlH.getUserByID(userID);
                ACoinUserData acoinData = ACoinApp.sqlH.getAcoinUserDataByID(acoinID);


                if (userData == null) {
                	
                	
                	throw new Exception();
                	
                	
                	
                }
                
                if (acoinData == null) {
                	
                	
                	throw new Exception();
                	
                	
                }
                
                this.frame.setVisible(false);
                this.frame.dispose();
                
                new MineDash(userData, acoinData);



            } catch (Exception ex) {

                ex.printStackTrace();

                this.frame.setVisible(false);
                JOptionPane.showMessageDialog(this.frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                this.frame.dispose();

                System.exit(0);

            }

        }
        
    }
    
}
