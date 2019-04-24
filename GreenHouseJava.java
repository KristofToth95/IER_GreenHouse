// Environment code for project GreenHouse.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.lang.*;



public class GreenHouseJava extends Environment {
	private GreenHouseGraphics kinezet;
	private int novekedes = 0;
	private boolean water = false;
	
	private int homerseklet = (new Random()).nextInt(50);
	
	public int getHomerseklet() {
		return homerseklet;
	}
	
	public void setHomerseklet(int a){
		homerseklet = a;
	}

    private Logger logger = Logger.getLogger("GreenHouse.mas2j."+GreenHouseJava.class.getName());
	private GreenHouseGUI gui = new GreenHouseGUI();
	
	private Object modelLock = new Object(); 

    /** Called before the MAS execution with the args informed in .mas2j */

	public GreenHouseJava(){		
		new Thread() {
            public void run() {
                try {
                    while (isRunning()) {
						 //gui.paintAll(gui.getGraphics());
						 //Thread.sleep(1000);
						 }
                } catch (Exception e) {} 
            }
        }.start();  
	}
	
    @Override
    public void init(String[] args) {
      /*  super.init(args);
        addPercept(ASSyntax.parseLiteral("percept(demo)"));*/
    }



    @Override

    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        if (true) { // you may improve this condition
             informAgsEnvironmentChanged();
        }
     
		 gui.paintAll(gui.getGraphics());
		 return true; // the action was executed with success
    }



    /** Called before the end of MAS execution */

    @Override
    public void stop() {
        super.stop();
		gui.setVisible(false);
    }
	
	
	 class GreenHouseGUI extends JFrame {
		 JPanel panel = new JPanel();
		 JPanel grafikuspanel = new JPanel();
		 JLabel label = new JLabel();
		 JButton riaszt = new JButton("Riasztas");
		 JButton ontoz = new JButton("Ontozes");
		 JButton hut = new JButton("Hutes"); 
		 JButton fut = new JButton("Futes");
		 JButton uj_hom_btn = new JButton("Uj homerseklet");
		 JTextArea uj_hom_txt = new JTextArea();
		 JLabel akt_hom_txt = new JLabel("Aktualis homerseklet: " + getHomerseklet());
		 JButton reset = new JButton("Reset");
					
		 GreenHouseGUI(){
			 super("Okos UvegHaz");
			 
			 		  
			 setPreferredSize(new Dimension(800,600));
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			 kinezet = new GreenHouseGraphics();
			 kinezet.setBounds(75, 15, 700, 400);
			 this.add(kinezet);
			
			 this.add(panel, BorderLayout.CENTER);
			 panel.setLayout(null);
			 
			 this.pack();
			
			riaszt.setBounds(120, 375, 142, 23);
			panel.add(riaszt);
			riaszt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(riaszt.getText());
					reset.setVisible(true);
				}
			});
			
			ontoz.setBounds(120, 425, 142, 23);
			panel.add(ontoz);
			ontoz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(novekedes<3){
							water = true;
							Thread.sleep(700);
							water = false;
							novekedes++;
						}
						else
							novekedes = 0;
					} catch (Exception ex) {
					}
					
					//label.setText(ontoz.getText());
					//reset.setVisible(true);
				}
			});
			
			hut.setBounds(320, 425, 142, 23);
			panel.add(hut);
			hut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(hut.getText());
					reset.setVisible(true);
				}
			});
		
			fut.setBounds(320, 375, 142, 23);
			panel.add(fut);
			fut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText(fut.getText());
					reset.setVisible(true);
				}
			});
			
			uj_hom_btn.setBounds(545, 425, 120, 23);
			panel.add(uj_hom_btn);
			uj_hom_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						setHomerseklet(Integer.parseInt(uj_hom_txt.getText()));
					} catch (Exception ex){
						System.out.println("Nem megfelelo homerseklet ertek");
					}
					akt_hom_txt.setText("Aktualis homerseklet: " + getHomerseklet());
				}
			});
			
			uj_hom_txt.setBounds(495, 425, 42, 23);  
			panel.add(uj_hom_txt);
			
			akt_hom_txt.setBounds(520, 365, 300, 40);
			panel.add(akt_hom_txt);
			
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(400, 460, 100, 40);
			//label.setForeground(Color.RED);
			panel.add(label);
			
			reset.setBounds(400, 510, 100, 23);
			panel.add(reset);
			reset.setVisible(false);
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText("");
					reset.setVisible(false);
				}
			});
			 
			 pack();
             setVisible(true);
             this.repaint();
		 }
		 
	 }
	 
	 public class GreenHouseGraphics extends JComponent {

		

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(24, 231, 82));
            g2d.fillRect(0, 0, 600, 350);
            g2d.setColor(new Color(150, 91, 8));
            g2d.fillRect(50, 30, 500, 290);
            g2d.setColor(new Color(189, 182, 173));
            g2d.fillRect(54, 34, 492, 282);
			for(int j=0; j<3; j++){
					for(int i=0; i<9; i++){
						g2d.setColor(new Color(239 - j*100, 37 + 30*j, 47 + 100*j));
						g2d.fillOval(82 + 50*i, 62 + 90*j, 30, 30);
						g2d.setColor(new Color(239, 193, 37));
						g2d.fillOval(93 + 50*i, 73 + 90*j, 8, 8);
					}
				}
			
			
			if(novekedes == 1){
				for(int j=0; j<3; j++){
					for(int i=0; i<9; i++){
						g2d.setColor(new Color(239 - j*100, 37 + 30*j, 47 + 100*j));
						g2d.fillOval(80 + 50*i, 60 + 90*j, 40, 40);
						g2d.setColor(new Color(239, 193, 37));
						g2d.fillOval(95 + 50*i, 75 + 90*j, 10, 10);
					}
				}
			}
			if(novekedes == 2){
				for(int j=0; j<3; j++){
					for(int i=0; i<9; i++){
						g2d.setColor(new Color(239 - j*100, 37 + 30*j, 47 + 100*j));
						g2d.fillOval(80 + 50*i, 60 + 90*j, 50, 50);
						g2d.setColor(new Color(239, 193, 37));
						g2d.fillOval(98 + 50*i, 78 + 90*j, 12, 12);
					}
				}
			}
			if(water){
				
					for(int k=0; k<9; k++){
						g2d.setColor(new Color(67, 199, 249));
						g2d.fillRect(60+20*k, 50+30*k, 10, 10);
					}
					for(int k=0; k<9; k++){
						g2d.setColor(new Color(67, 199, 249));
						g2d.fillRect(210+20*k, 50+30*k, 10, 10);
					}
					for(int k=0; k<9; k++){
						g2d.setColor(new Color(67, 199, 249));
						g2d.fillRect(360+20*k, 50+30*k, 10, 10);
					}
				
			}
			
        }

       // @Override
       // public Dimension getPreferredSize() {
       //     return new Dimension(800, 500);
       // }
    }

}


