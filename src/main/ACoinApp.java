package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ACoinApp {

    private JFrame frame;
    private JLabel loadFileText;

    public ACoinApp() {

        this.frame = new JFrame();
        this.loadFileText = new JLabel("Select your aCoin miner config file");

        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        this.loadFileText.setBounds(100, 50, 250, 30);

        this.frame.add(this.loadFileText);



        this.frame.setVisible(true);

    }
    
}
