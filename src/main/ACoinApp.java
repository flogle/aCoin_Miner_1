package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ptdfj.PTDFJHandlerString;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

public class ACoinApp implements ActionListener {

    private JFrame frame;
    private JLabel loadFileText;
    private JTextField mineCodeINE;
    private JButton loadMineCodeBTNE;

    public ACoinApp() {

        this.frame = new JFrame();
        this.loadFileText = new JLabel("Enter your aCoin mine app code");
        this.mineCodeINE = new JTextField();
        this.loadMineCodeBTNE = new JButton("Load");

        this.frame.setTitle("Mine aCoin");
        this.frame.setSize(512, 512);
        this.frame.setLayout(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        this.loadFileText.setBounds(100, 50, 250, 30);

        this.mineCodeINE.setBounds(100, 200, 250, 32);

        this.loadMineCodeBTNE.setBounds(100, 250, 100, 32);
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

                System.out.println(dataH.getData().get("user_id"));
                System.out.println(dataH.getData().get("acoin_id"));

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }
        
    }
    
}
