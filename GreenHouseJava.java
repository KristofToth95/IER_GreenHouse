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
	
	private int novekedes = 0;
	private boolean water = false;
	private int homerseklet =(new Random()).nextInt(50);
	
	public boolean getWater() {return this.water;}
	public void setWater(boolean a) {water=a;}
	
	public int getNovekedes() {return this.novekedes;}
	public void setNovekedes(int a) {novekedes=a;}
	
	public int getHomerseklet() {return this.homerseklet;}
	public void setHomerseklet(int a) {homerseklet=a;}
	
	private static final Literal lFutes = ASSyntax.createLiteral("futes");
	private static final Literal lHutes = ASSyntax.createLiteral("hutes");
	private static final Literal lRiasztas = ASSyntax.createLiteral("riasztas");
	private static final Literal lOntozes = ASSyntax.createLiteral("ontozes");
	
    private Logger logger = Logger.getLogger("GreenHouse.mas2j."+GreenHouseJava.class.getName());
	private GreenHouseGUI gui = new GreenHouseGUI();
	private GreenHouseGraphics kinezet;
	private Object modelLock = new Object(); 

    /** Called before the MAS execution with the args informed in .mas2j */

	public GreenHouseJava(){	
		createPercept();	
		new Thread() {
            public void run() {
                try {
					createPercept();
					Thread.sleep(1000);
					
                } catch (Exception e) {} 
            }
        }.start();  
	}
	
	private void createPercept(){
	clearPercepts();
	
	if (getHomerseklet() < 5) {
		addPercept(lFutes);	
	} else if (getHomerseklet() > 4 && getHomerseklet() < 31) {
		gui.label.setText("");
		gui.ontoz.setEnabled(true);
	} else if( getHomerseklet() > 30 && getHomerseklet() < 41) {
		addPercept(lHutes);
	} else if (getHomerseklet() > 40) {
		addPercept(lRiasztas);
	}
			
	}
	
    @Override
    public void init(String[] args) {
      /*  super.init(args);
        addPercept(ASSyntax.parseLiteral("percept(demo)"));*/
    }



    @Override

    public boolean executeAction(String agName, Structure action) {
		
		if(action.getFunctor().equals("futes")){
			setHomerseklet(getHomerseklet() + 1);
			gui.label.setText("Futes");
			gui.ontoz.setEnabled(false);
			gui.homersekletSet();
			
		} else if (action.getFunctor().equals("hutes")){
			setHomerseklet(getHomerseklet() - 1);
			gui.label.setText("Hutes");
			gui.ontoz.setEnabled(false);
			gui.homersekletSet();
			
		} else if (action.getFunctor().equals("riasztas")){
			setHomerseklet(getHomerseklet() - 1);
			gui.label.setText("Riasztas");
			gui.ontoz.setEnabled(false);
			gui.homersekletSet();
		}else if (action.getFunctor().equals("ontozes")){
			setWater(false);
			setNovekedes(getNovekedes()+1);
			kinezet.repaint();
			
		} else {
			logger.info("executing: "+action+", but not implemented!");
		}
		
		
		createPercept();
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
		 JButton ontoz = new JButton("Ontozes");
		 JButton uj_hom_btn = new JButton("Uj homerseklet");
		 JButton rand_hom_btn = new JButton("Random homerseklet");
		 JTextArea uj_hom_txt = new JTextArea();
		 JLabel akt_hom_txt = new JLabel("Aktualis homerseklet: " + getHomerseklet());
		 
		 public void homersekletSet(){
			 akt_hom_txt.setText("Aktualis homerseklet: " + getHomerseklet());
		 }
					
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
			
			ontoz.setBounds(120, 425, 142, 23);
			panel.add(ontoz);
			ontoz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getNovekedes()<3){
						setWater(true);
						kinezet.repaint();
						addPercept(lOntozes);
			}
			else {
				setNovekedes(0);
				kinezet.repaint();
			}
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
					homersekletSet();
					createPercept();
				}
			});
			
			rand_hom_btn.setBounds(495, 465, 170, 23);
			panel.add(rand_hom_btn);
			rand_hom_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setHomerseklet((new Random()).nextInt(50));
					homersekletSet();
					createPercept();
				}
			});
			
			uj_hom_txt.setBounds(495, 425, 42, 23);  
			panel.add(uj_hom_txt);
			
			akt_hom_txt.setBounds(520, 365, 300, 40);
			panel.add(akt_hom_txt);
			
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(300, 460, 100, 40);
			label.setForeground(Color.RED);
			panel.add(label);
			 
			 pack();
             setVisible(true);
             this.repaint();
		 }
		 
	 }
	 
	 public class GreenHouseGraphics extends JComponent {
		 	Graphics2D g2d;
			
        @Override
        public void paint(Graphics g) {
			g2d = (Graphics2D) g;
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
			if(getNovekedes() == 1){
				for(int j=0; j<3; j++){
					for(int i=0; i<9; i++){
						g2d.setColor(new Color(239 - j*100, 37 + 30*j, 47 + 100*j));
						g2d.fillOval(80 + 50*i, 60 + 90*j, 40, 40);
						g2d.setColor(new Color(239, 193, 37));
						g2d.fillOval(95 + 50*i, 75 + 90*j, 10, 10);
					}
				}
			}
			if(getNovekedes() == 2){
				for(int j=0; j<3; j++){
					for(int i=0; i<9; i++){
						g2d.setColor(new Color(239 - j*100, 37 + 30*j, 47 + 100*j));
						g2d.fillOval(80 + 50*i, 60 + 90*j, 50, 50);
						g2d.setColor(new Color(239, 193, 37));
						g2d.fillOval(98 + 50*i, 78 + 90*j, 12, 12);
					}
				}
			}
			if(getWater()==true){
				
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

    }

}


